package Restaurante.model;

import java.text.NumberFormat;

public class ultis {
	static 	NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
	
		public static String nfMoeda(double value) {
			return nfMoeda.format(value);
		}
	
	
}
