package com.skolarajak.utils;

public class RandomUtils {
	private static int SLOVO_A = 65;
	private static int SLOVO_Z = 90;
	private static double PRAG_RASPODELE_AKTIVNIH_VOZILA = 0.5;

	public static String slucajnoSlovo() {
		char c = (char) slucajanBrojUintervalu(SLOVO_A, SLOVO_Z);
		return String.valueOf(c);
	}
	public static boolean randomBoolean() {
		return Math.random() < PRAG_RASPODELE_AKTIVNIH_VOZILA;
	}

	public static int slucajanBrojUintervalu(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}
}
