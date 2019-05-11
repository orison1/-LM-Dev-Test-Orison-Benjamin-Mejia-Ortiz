package com.prueba.model;

public class PruebaProperties {
	
	public static class status{
		private static final String unlocked = "UNLOCKED";
		private static final String locked ="LOCKED";
		
		public static String getUnlocked() {
			return unlocked;
		}
		
		public static String getLocked() {
			return locked;
		}
		
	}
}
