package br.unipe.cc.p6.compiladores.geradordecodigointermediario;

import br.unipe.cc.p6.compiladores.analisadorsintatico.ArvoreDeDerivacao;
import br.unipe.cc.p6.compiladores.comum.No;
import br.unipe.cc.p6.compiladores.comum.Simbolo;

public class GeradorDeCodigoIntermediario {

	public TabelaDeOperacoes gerarCodigoIntermediario(ArvoreDeDerivacao arvore) {
		TabelaDeOperacoes tabela_de_operacoes = new TabelaDeOperacoes();
		
		int id = 1;
		
		for (No reference_no : arvore.getListNoInOrdem()) {
			
			for (Simbolo simbolo : reference_no.getDadosDoNo()) {
				
				if (simbolo.getToken().equals("Comando de Atribuição")) {
					
					if (reference_no.getNoDireito().getDadosDoNo().get(0).getToken().equals("Operador Aditivo")) {
						Operacao operacao1 = new Operacao();
						operacao1.setId(id);
						operacao1.setOperador("+");
						operacao1.setArg1(reference_no.getNoDireito().getNoEsquerdo().getDadosDoNo().get(0).getLexema());
						operacao1.setArg2(reference_no.getNoDireito().getNoDireito().getDadosDoNo().get(0).getLexema());
						id++;
						tabela_de_operacoes.addOperacao(operacao1);
						
						Operacao operacao2 = new Operacao();
						operacao2.setId(id);
						operacao2.setOperador(":=");
						operacao2.setArg1(reference_no.getNoEsquerdo().getDadosDoNo().get(0).getLexema());
						operacao2.setArg2(""+operacao1.getId());
						id++;
						tabela_de_operacoes.addOperacao(operacao2);
					} else {
						Operacao operacao = new Operacao();
						operacao.setId(id);
						operacao.setOperador(":=");
						operacao.setArg1(reference_no.getNoEsquerdo().getDadosDoNo().get(0).getLexema());
						operacao.setArg2(reference_no.getNoDireito().getDadosDoNo().get(0).getLexema());
						id++;
						
						tabela_de_operacoes.addOperacao(operacao);
					}
					
				}
				
			}			
		}
		
		return tabela_de_operacoes;
	}
	
}
