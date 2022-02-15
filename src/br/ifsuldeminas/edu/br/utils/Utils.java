package br.ifsuldeminas.edu.br.utils;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Utils {
	
	 public static String formatarString(String mascara,String texto)  {
	        MaskFormatter mf = null;
	        String st = null;
			try {
				mf = new MaskFormatter(mascara);
				  mf.setValueContainsLiteralCharacters(false);
				  st = mf.valueToString(texto);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
	        return st;
	    }
}