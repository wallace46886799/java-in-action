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
	       // ��һ��Selector
	       Selector acceptSelector =
	           SelectorProvider.provider().openSelector();
	 
	       // ����һ��ServerSocketChannel������һ��SelectableChannel������
	       ServerSocketChannel ssc = ServerSocketChannel.open();
	       // ������Ϊnon-blocking״̬���������ܽ��з�����IO����
	       ssc.configureBlocking(false);
	 
	       // ��ServerSocketChannel��Ӧ��socket��IP�Ͷ˿�
	       InetAddress lh = InetAddress.getLocalHost();
	       InetSocketAddress isa = new InetSocketAddress(lh, port);
	       ssc.socket().bind(isa);
	 
	       // ��ServerSocketChannelע�ᵽSelector�ϣ����ض�Ӧ��SelectionKey
	       SelectionKey acceptKey =
	           ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);
	 
	       int keysAdded = 0;
	 
	       // ��select()���������ע����Selector�ϵ�SelectableChannel
	       // ����ֵ�������ж���channel���Խ���IO���� (ready for IO)
	       while ((keysAdded = acceptSelector.select()) > 0) {
	           // selectedKeys()����һ��SelectionKey�ļ��ϣ�
	           // ����ÿ��SelectionKey������һ�����Խ���IO������channel��
	           // һ��ServerSocketChannel���Խ���IO������ζ�����µ�TCP����������
	           Set readyKeys = acceptSelector.selectedKeys();
	           Iterator i = readyKeys.iterator();
	 
	           while (i.hasNext()) {
	              SelectionKey sk = (SelectionKey) i.next();
	              //��Ҫ���������key��selectedKeys���������ɾ��
	              i.remove();
	              // ��SelectionKey�õ���Ӧ��channel
	              ServerSocketChannel nextReady = (ServerSocketChannel) sk.channel();
	              // �����µ�TCP����
	              Socket s = nextReady.accept().socket();
	              // �ѵ�ǰ��ʱ��д������µ�TCP������
	              PrintWriter out = new PrintWriter(s.getOutputStream(), true);
	              Date now = new Date();
	              out.println(now);
	              // �ر�����
	              out.close();
	           }
	       }
	    }

}
