package br.unipe.cc.p6.compiladores.analisadorsintatico;

import br.unipe.cc.p6.compiladores.analisadorlexico.TabelaDeSimbolos;
import br.unipe.cc.p6.compiladores.comum.No;
import br.unipe.cc.p6.compiladores.comum.Simbolo;

public class AnalisadorSintatico {

	public ArvoreDeDerivacao analisar(TabelaDeSimbolos tabela){
		ArvoreDeDerivacao arvore_de_derivacao = new ArvoreDeDerivacao();
		
		arvore_de_derivacao.setRaiz(new No(null));
		No reference_no = arvore_de_derivacao.getRaiz();

		for (int i = 0; i < tabela.getTabela().size(); i++) {
			
			Simbolo simbolo = tabela.getTabela().get(i);  
			
			switch (simbolo.getToken()) {
				case "Delimitador":{
					if (!simbolo.getLexema().equals(":")){
						if (reference_no.getNoDireito() == null){
							reference_no.setNoDireito(new No(reference_no));; 
						}
						
						reference_no = reference_no.getNoDireito();
					}
					break;
				}
				case "Palavra Reservada":{
					reference_no.getDadosDoNo().add(simbolo);
					break;
				}
				case "Identificador":{
					if (tabela.getTabela().get(i+1).getToken().equals("Comando de Atribuição") || tabela.getTabela().get(i+1).getToken().equals("Operador Aditivo")){
						
						No no_aux_direito = new No(reference_no);

						No no_aux_esquerdo = new No(no_aux_direito);
						no_aux_esquerdo.getDadosDoNo().add(simbolo);
						
						no_aux_direito.getDadosDoNo().add(tabela.getTabela().get(i+1));
						no_aux_direito.setNoEsquerdo(no_aux_esquerdo);
						
						reference_no.setNoDireito(no_aux_direito);
						reference_no = reference_no.getNoDireito();
					} else if (tabela.getTabela().get(i-1).getToken().equals("Comando de Atribuição") || tabela.getTabela().get(i-1).getToken().equals("Operador Aditivo")){
						No no_aux_direito = new No(reference_no);
						no_aux_direito.getDadosDoNo().add(simbolo);
						
						reference_no.setNoDireito(no_aux_direito);
						reference_no = reference_no.getNoDireito();
					} else {
						
						if (reference_no.getNoEsquerdo() == null){
							reference_no.setNoEsquerdo(new No(reference_no));
						}
					
						reference_no.getNoEsquerdo().getDadosDoNo().add(simbolo);
					}
					break;
				}
				case "Número Inteiro":{
					if (tabela.getTabela().get(i+1).getToken().equals("Comando de Atribuição") || tabela.getTabela().get(i+1).getToken().equals("Operador Aditivo")){
						
						No no_aux_direito = new No(reference_no);

						No no_aux_esquerdo = new No(no_aux_direito);
						no_aux_esquerdo.getDadosDoNo().add(simbolo);
						
						no_aux_direito.getDadosDoNo().add(tabela.getTabela().get(i+1));
						no_aux_direito.setNoEsquerdo(no_aux_esquerdo);

						
						reference_no.setNoDireito(no_aux_direito);
						reference_no = reference_no.getNoDireito();
					} else if (tabela.getTabela().get(i-1).getToken().equals("Comando de Atribuição") || tabela.getTabela().get(i-1).getToken().equals("Operador Aditivo")){
						No no_aux_direito = new No(reference_no);
						no_aux_direito.getDadosDoNo().add(simbolo);
						
						reference_no.setNoDireito(no_aux_direito);
						reference_no = reference_no.getNoDireito();
					} else {
						if (reference_no.getNoEsquerdo() == null){
							reference_no.setNoEsquerdo(new No(reference_no));
						}
						reference_no.getNoEsquerdo().getDadosDoNo().add(simbolo);
					}
					break;
				}	
			}
			
		}
		
		return arvore_de_derivacao;
	}
	
}
