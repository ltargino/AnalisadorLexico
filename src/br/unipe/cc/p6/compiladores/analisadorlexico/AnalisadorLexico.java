package br.unipe.cc.p6.compiladores.analisadorlexico;


import java.util.regex.Pattern;

import br.unipe.cc.p6.compiladores.comum.Constants;
import br.unipe.cc.p6.compiladores.comum.Simbolo;
import br.unipe.cc.p6.compiladores.comum.TabelaDeSimbolos;

public class AnalisadorLexico {
	
	public TabelaDeSimbolos analisar(String input) throws Exception {
		TabelaDeSimbolos result = new TabelaDeSimbolos();
		Long lineCount = new Long(0);
		
		try {
		
			for (String linha : removerComentarios(input).split(Constants.breakLine)) {
				lineCount++;
				
				String palavra_auxiliar = "";
				String delimitadorParaAdicionar = null;
				String operadorAditivoParaAdicionar = null;
				String operadorMultiplicativoParaAdicionar = null;
				String operadorRelacionalParaAdicionar = null;
				
				for (int i = 0; i < linha.length(); i++) {

					if (delimitadorParaAdicionar != null) {
						result.getTabela().add(new Simbolo(delimitadorParaAdicionar, "Delimitador", lineCount.toString()));
						delimitadorParaAdicionar = null;
					}
					if (operadorAditivoParaAdicionar != null) {
						result.getTabela().add(new Simbolo(palavra_auxiliar, "Identificador", lineCount.toString()));
						palavra_auxiliar = "";
						result.getTabela().add(new Simbolo(operadorAditivoParaAdicionar, "Operador Aditivo", lineCount.toString()));
						operadorAditivoParaAdicionar = null;
					}
					if (operadorMultiplicativoParaAdicionar != null) {
						result.getTabela().add(new Simbolo(palavra_auxiliar, "Identificador", lineCount.toString()));
						palavra_auxiliar = "";
						result.getTabela().add(new Simbolo(operadorMultiplicativoParaAdicionar, "Operador Multiplicativo", lineCount.toString()));
						operadorMultiplicativoParaAdicionar = null;
					}
					if (operadorRelacionalParaAdicionar != null) {
						result.getTabela().add(new Simbolo(palavra_auxiliar, "Identificador", lineCount.toString()));
						palavra_auxiliar = "";
						result.getTabela().add(new Simbolo(operadorRelacionalParaAdicionar, "Operador Relacional", lineCount.toString()));
						operadorRelacionalParaAdicionar = null;
					}
					
					if (linha.charAt(i) == ' ') {
						palavra_auxiliar = "";
					} else {
					
						char c = linha.charAt(i);
						
						if ( c == Constants.comandoDeAtribuicao.charAt(0) && linha.charAt(i+1) == Constants.comandoDeAtribuicao.charAt(1) ) {
							//result.getTabela().add(new Simbolo(palavra_auxiliar.replace(Constants.comandoDeAtribuicao, ""), "Identificador", lineCount.toString()));
							result.getTabela().add(new Simbolo(Constants.comandoDeAtribuicao, "Comando de Atribuição", lineCount.toString()));
							palavra_auxiliar = "";
							i++;
							continue;
						}
						
						if ( Constants.delimitadores.contains(""+c) ) {
							delimitadorParaAdicionar = ""+c;
						} else if( Constants.operadoresAditivos.contains(""+c) ) {
							operadorAditivoParaAdicionar = ""+c;
						} else if( Constants.operadoresMultiplicativos.contains(""+c) ) {
							operadorMultiplicativoParaAdicionar = ""+c;
						} else if( Constants.operadoresRelacionais.contains(""+c) ) {
							operadorRelacionalParaAdicionar = ""+c;
						} else {
							palavra_auxiliar += linha.charAt(i);
						}
						
						// Palavras Rervadas
						if ( Constants.palavrasReservadas.contains(palavra_auxiliar) && (i == linha.length()-1 || i == linha.length()-2 || (i < linha.length()-1 && linha.charAt(i+1) == ' ')) ) {
							result.getTabela().add(new Simbolo(palavra_auxiliar, "Palavra Reservada", lineCount.toString()));
							palavra_auxiliar = "";
							continue;
						}
											
						// Identificador
						if ((i == linha.length()-1 || (i < linha.length()-1 && (linha.charAt(i+1) == ' ' || Constants.delimitadores.contains(""+linha.charAt(i+1)))))) {
							if ( Pattern.matches(Constants.identificador, palavra_auxiliar) ) {
								result.getTabela().add(new Simbolo(palavra_auxiliar, "Identificador", lineCount.toString()));
								palavra_auxiliar = "";
								continue;
							}
						}
						
						// Numeros Inteiros
						if ( Pattern.matches(Constants.numerosInteiros, palavra_auxiliar)) {
							if (!Pattern.matches(Constants.numerosInteiros, ""+linha.charAt(i+1))) {
								result.getTabela().add(new Simbolo(palavra_auxiliar, "Número Inteiro", lineCount.toString()));
								palavra_auxiliar = "";
								continue;
							}
						} else {
							// Numero Reais
							if ( Pattern.matches(Constants.numeroReais, palavra_auxiliar) ) {
								if (!Pattern.matches(Constants.numeroReais, ""+linha.charAt(i+1))) {
									result.getTabela().add(new Simbolo(palavra_auxiliar, "Número Real", lineCount.toString()));
									continue;
								}
							}
						}
						
						// Operadores Relacionais
						if ( Constants.operadoresRelacionais.contains(palavra_auxiliar) ) {
							result.getTabela().add(new Simbolo(palavra_auxiliar, "Operador Relacional", lineCount.toString()));
							palavra_auxiliar = "";
							continue;
						}
						
						// Operadores Aditivos
						if ( Constants.operadoresAditivos.contains(palavra_auxiliar) ) {
							result.getTabela().add(new Simbolo(palavra_auxiliar, "Operador Aditivo", lineCount.toString()));
							palavra_auxiliar = "";
							continue;
						}
						
						// Operadores Multiplicativos
						if ( Constants.operadoresMultiplicativos.contains(palavra_auxiliar) ) {
							result.getTabela().add( new Simbolo(palavra_auxiliar, "Operador Multiplicativo", lineCount.toString()));
							palavra_auxiliar = "";
							continue;
						}
						
					}
					if (delimitadorParaAdicionar != null) {
						result.getTabela().add(new Simbolo(delimitadorParaAdicionar, "Delimitador", lineCount.toString()));
						delimitadorParaAdicionar = null;
					}
				}
			}
		
		} catch(Exception ex) {
			throw ex;
		}
		
		return result;
	}
	
	private String removerComentarios(String input_com_comentarios) throws Exception  {
		String output_sem_comentarios = input_com_comentarios;
		
		boolean achou_chave_inicio = false;
		boolean achou_chave_final = false;
		
		int posicao_chave_inicial = 0;
		int posicao_chave_final = 0;
		
		for (int i = 0; i < output_sem_comentarios.length(); i++) {
			
			if (output_sem_comentarios.charAt(i) == Constants.initComment) {
				posicao_chave_inicial = i;
				achou_chave_inicio = true;
			}
			
			if (output_sem_comentarios.charAt(i) == Constants.finalComment) {
				posicao_chave_final = i;
				achou_chave_final = true;
			}			
			
		}
		
		if (achou_chave_inicio && !achou_chave_final) {
			throw new Exception("Chave final de comentário não localizada");
		} else if (!achou_chave_inicio && achou_chave_final) { 
			throw new Exception("Chave inicial de comentário não localizada");
		} else if ( !achou_chave_inicio && !achou_chave_final ) {
		} else {
			output_sem_comentarios = new StringBuilder(output_sem_comentarios).delete(posicao_chave_inicial, posicao_chave_final).toString();
		}
		
		return output_sem_comentarios;
	}
	
}
