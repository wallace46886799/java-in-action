/**
 * 
 */
package com.dreamslab.nio;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Frank Zhang
 *
 */
public class SocketMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		SocketMain.acceptConnections(8080);
	}
	
	
	private static void acceptConnections(int port) throws Exception {
	       // 打开一个Selector
	       Selector acceptSelector =
	           SelectorProvider.provider().openSelector();
	 
	       // 创建一个ServerSocketChannel，这是一个SelectableChannel的子类
	       ServerSocketChannel ssc = ServerSocketChannel.open();
	       // 将其设为non-blocking状态，这样才能进行非阻塞IO操作
	       ssc.configureBlocking(false);
	 
	       // 给ServerSocketChannel对应的socket绑定IP和端口
	       InetAddress lh = InetAddress.getLocalHost();
	       InetSocketAddress isa = new InetSocketAddress(lh, port);
	       ssc.socket().bind(isa);
	 
	       // 将ServerSocketChannel注册到Selector上，返回对应的SelectionKey
	       SelectionKey acceptKey =
	           ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);
	 
	       int keysAdded = 0;
	 
	       // 用select()函数来监控注册在Selector上的SelectableChannel
	       // 返回值代表了有多少channel可以进行IO操作 (ready for IO)
	       while ((keysAdded = acceptSelector.select()) > 0) {
	           // selectedKeys()返回一个SelectionKey的集合，
	           // 其中每个SelectionKey代表了一个可以进行IO操作的channel。
	           // 一个ServerSocketChannel可以进行IO操作意味着有新的TCP连接连入了
	           Set readyKeys = acceptSelector.selectedKeys();
	           Iterator i = readyKeys.iterator();
	 
	           while (i.hasNext()) {
	              SelectionKey sk = (SelectionKey) i.next();
	              //需要将处理过的key从selectedKeys这个集合中删除
	              i.remove();
	              // 从SelectionKey得到对应的channel
	              ServerSocketChannel nextReady = (ServerSocketChannel) sk.channel();
	              // 接受新的TCP连接
	              Socket s = nextReady.accept().socket();
	              // 把当前的时间写到这个新的TCP连接中
	              PrintWriter out = new PrintWriter(s.getOutputStream(), true);
	              Date now = new Date();
	              out.println(now);
	              // 关闭连接
	              out.close();
	           }
	       }
	    }

}
