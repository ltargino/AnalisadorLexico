package br.unipe.cc.p6.compiladores.analisadorlexico.util;

public class Replicator {

	public static String replicate(String input, Long size, char charToReplicate) {
		String result = "";
		
		for (int i = 0; i < size - input.length() ; i++)
			result += charToReplicate;
		
		return result;
	}
	
	public static String replicate(Long size, char charToReplicate) {
		String result = "";
		
		for (int i = 0; i < size ; i++)
			result += charToReplicate;
		
		return result;
	}
	
}
