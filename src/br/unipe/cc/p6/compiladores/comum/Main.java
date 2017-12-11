package br.unipe.cc.p6.compiladores.comum;

import java.io.IOException;

import br.unipe.cc.p6.compiladores.analisadorlexico.AnalisadorLexico;
import br.unipe.cc.p6.compiladores.analisadorlexico.TabelaDeSimbolos;
import br.unipe.cc.p6.compiladores.analisadorsintatico.AnalisadorSintatico;
import br.unipe.cc.p6.compiladores.analisadorsintatico.ArvoreDeDerivacao;
import br.unipe.cc.p6.compiladores.geradordecodigointermediario.GeradorDeCodigoIntermediario;
import br.unipe.cc.p6.compiladores.geradordecodigointermediario.TabelaDeOperacoes;

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
			GeradorDeCodigoIntermediario gerador_de_codigo_intermediario = new GeradorDeCodigoIntermediario();
			
			TabelaDeSimbolos tabela_de_simbolos;
			ArvoreDeDerivacao arvore_de_derivacao;
			TabelaDeOperacoes tabela_de_operacoes;
			try {
				tabela_de_simbolos = analisador_lexico.analisar(source_code);
				tabela_de_simbolos.imprimirTabelaDeSimbolos();
				
				arvore_de_derivacao = analisador_Sintatico.analisar(tabela_de_simbolos);
				arvore_de_derivacao.imprimirArvoreDeDerivacao();
				
				tabela_de_operacoes = gerador_de_codigo_intermediario.gerarCodigoIntermediario(arvore_de_derivacao);
				tabela_de_operacoes.imprimirTabelaDeOperacoes();
			} catch (Exception e) {
				System.out.println("Ocorreu um erro!\n Detalhes: " + e.getMessage());
			}
		}
	}
	
}
