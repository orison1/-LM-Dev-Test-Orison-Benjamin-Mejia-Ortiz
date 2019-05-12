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
	
	public static class accounType{
		private static final String personal = "SAVINGS_ACCOUNT";
		private static final String card = "CREDIT_CARD";
		private static final String loan = "LOAN";
		
		public static String getPersonal() {
			return personal;
		}
		
		public static String getCard() {
			return card;
		}
		
		public static String getLoan() {
			return loan;
		}
	}
}
