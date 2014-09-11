package com.o2oweb.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class BlockAndType {
	public static Set<String> blockset;
	public static String[] typeset;
	
	static {
		blockset = new LinkedHashSet<String>();
		blockset.add("XSQ");
		blockset.add("ShaQ");
		blockset.add("ShuiQ");
		blockset.add("TSQ");
		typeset= new String[]{"shop","food"};
	}
}
