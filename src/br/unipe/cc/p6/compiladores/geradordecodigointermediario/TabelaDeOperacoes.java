package br.unipe.cc.p6.compiladores.geradordecodigointermediario;

import java.util.ArrayList;
import java.util.List;

import br.unipe.cc.p6.compiladores.comum.Replicator;

public class TabelaDeOperacoes {

	private List<Operacao> operacoes;
	
	public void imprimirTabelaDeOperacoes() {
		
		System.out.println("TABELA DE OPERAÇÕES");
		
		System.out.println("|[#]| "
							+ Replicator.replicate(new Long(6), ' ')
			                + "Operação"
			                + Replicator.replicate(new Long(6), ' ')
			                + "| "
			                + Replicator.replicate(new Long(5), ' ')
			                + "Argumento 1"
			                + Replicator.replicate(new Long(4), ' ')
			                + "| "
			                + Replicator.replicate(new Long(5), ' ')
			                + "Argumento 2"
			                + Replicator.replicate(new Long(4), ' ')
			                + "|" );
		
		for (Operacao operacao : operacoes) {
			System.out.println(operacao);
		}
	}

	public void addOperacao(Operacao operacao) {
		if (this.operacoes == null)
			this.operacoes = new ArrayList<Operacao>();
		this.operacoes.add(operacao);
	}
	
	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}
	
}
