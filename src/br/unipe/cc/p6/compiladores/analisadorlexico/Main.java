package br.unipe.cc.p6.compiladores.analisadorlexico;

import java.io.IOException;

import br.unipe.cc.p6.compiladores.analisadorlexico.util.Reader;

public class Main {

	public static void main(String[] args) {

		String source_code = null;

		try {
			source_code = Reader.getSourceFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (source_code == null)
			System.out.println("Código fonte não localizado");
		else {
			AnalisadorLexico analisador_lexico = new AnalisadorLexico();
	
			TabelaDeSimbolos tabela_de_simbolos;
			try {
				tabela_de_simbolos = analisador_lexico.analisar(source_code);
				tabela_de_simbolos.imprimirTabelaDeSimbolos();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro!\n Detalhes: " + e.getMessage());
			}
		}
	}
	
}
