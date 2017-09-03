package br.unipe.cc.p6.compiladores.analisadorlexico;

import br.unipe.cc.p6.compiladores.analisadorlexico.util.Constants;

public class Main {

	public static void main(String[] args) {
		
		AnalisadorLexico analisador_lexico = new AnalisadorLexico();
		TabelaDeSimbolos tabela_de_simbolos = analisador_lexico.analisar(Constants.inputSourceCode);
		tabela_de_simbolos.imprimirTabelaDeSimbolos();
		
	}
	
}
