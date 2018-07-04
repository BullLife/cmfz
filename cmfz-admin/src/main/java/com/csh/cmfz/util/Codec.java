package com.csh.cmfz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Codec {
	
	public static String encryption(String str){
		MessageDigest md;
		StringBuilder sb=new StringBuilder();
		try {
			md = MessageDigest.getInstance("MD5");

			byte[] code=md.digest(str.getBytes());
			
			for (byte b : code) {
				int c=b & 255;
				if(c<16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(c));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
