package test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class listtext {

	@Test
	public void testadd(){
		List<String> ss = new LinkedList<String>();
		ss.add(null);
		System.out.println(ss.size());
	}
}
