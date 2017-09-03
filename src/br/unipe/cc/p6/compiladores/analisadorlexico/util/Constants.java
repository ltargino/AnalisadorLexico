package br.unipe.cc.p6.compiladores.analisadorlexico.util;

import java.util.Arrays;
import java.util.List;

public final class Constants {

	public static final String breakLine = System.getProperty("line.separator");
	
	public static final List<String> palavrasReservadas = Arrays.asList( "program", "var", "integer", "real", "boolean", "procedure", "begin", "end", "if", "then", "else", "while", "do", "not" );
	
	public static final String identificador = "[a-zA-Z].*";
	
	public static final String numerosInteiros = "[0-9]+";
	
	public static final String numeroReais = "";
	
	public static final List<String> delimitadores = Arrays.asList( ";", ".", ":", "(", ")", "," );
	
	public static final String comandoDeAtribuicao = ":=";
	
	public static final List<String> operadoresRelacionais = Arrays.asList( "=", "<", ">", "<=", ">=", "<>" );
	
	public static final List<String> operadoresAditivos = Arrays.asList( "+", "-", "or" );
	
	public static final List<String> operadoresMultiplicativos = Arrays.asList( "*", "/", "and" );
	
	public static final char initComment = '{';
	
	public static final char finalComment = '}';
	
	public static final String inputSourceCode = 
	
		  "program exemplo; {este eh um exemplo}" + breakLine
		+ "var" + breakLine
		+ "   nota1: integer;" + breakLine
		+ "   nota2: integer;" + breakLine
		+ "   total: real;" + breakLine
		+ "" + breakLine
		+"begin" + breakLine
		+ "   nota1:=10;" + breakLine
		+ "   nota2:=20;" + breakLine
		+ "   total:=nota1+nota2;" + breakLine
		+ "end." + breakLine
	
	;
}
