package br.unipe.cc.p6.compiladores.comum;

import java.io.IOException;

import br.unipe.cc.p6.compiladores.analisadorlexico.AnalisadorLexico;
import br.unipe.cc.p6.compiladores.analisadorsintatico.AnalisadorSintatico;

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
			AnalisadorSintatico analisador_Sintatico = new AnalisadorSintatico();
			
			TabelaDeSimbolos tabela_de_simbolos;
			ArvoreDeDerivacao arvore_de_derivacao;
			try {
				tabela_de_simbolos = analisador_lexico.analisar(source_code);
				tabela_de_simbolos.imprimirTabelaDeSimbolos();
				
				arvore_de_derivacao = analisador_Sintatico.analisar(tabela_de_simbolos);
				arvore_de_derivacao.imprimirArvoreDeDerivacao();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro!\n Detalhes: " + e.getMessage());
			}
		}
	}
	
}
