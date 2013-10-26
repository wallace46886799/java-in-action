package com.dreamslab.jvm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OOMTest {
	
	
	public static void main(String[] args) throws IOException{
		List holder = new ArrayList();
		while(true){
			holder.add(new Object());
		}
		
		
	}
}
