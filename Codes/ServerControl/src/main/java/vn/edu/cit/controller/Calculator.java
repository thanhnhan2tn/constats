package vn.edu.cit.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Calculator {

	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	public static String MD5(String str) {
		// MD5 encrypt
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] message = md.digest(str.getBytes());
			BigInteger number = new BigInteger(message);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			return "error";
		}
	}
}