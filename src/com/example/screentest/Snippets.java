package com.example.screentest;

public class Snippets {
	/**
	 * @author saran
	 * This has some useful java snippets, which i'll keep updating
	 */
	public static void main(String[] args){
		try {
			String content = "dc87e21c-0492-4818-ad23-90e49f4af8cc:your are missing out on great rewards";
			System.out.println(content.substring(content.indexOf(":", 0)));
			System.out.println(content.subSequence(0, content.indexOf(":")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
