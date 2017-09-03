package br.unipe.cc.p6.compiladores.analisadorlexico;

import java.util.ArrayList;
import java.util.List;

import br.unipe.cc.p6.compiladores.analisadorlexico.util.Replicator;

public class TabelaDeSimbolos {

	private List<Simbolo> tabela;

	public TabelaDeSimbolos() {
		this.tabela = new ArrayList<Simbolo>();
	}
	
	public void imprimirTabelaDeSimbolos() {
		
		System.out.println(   "| "
							+ Replicator.replicate(new Long(22), ' ')
		                    + "Lexema"
		                    + Replicator.replicate(new Long(22), ' ')
		                    + "| "
		                    + Replicator.replicate(new Long(22), ' ')
		                    + "Token "
		                    + Replicator.replicate(new Long(22), ' ')
		                    + "| "
		                    + Replicator.replicate(new Long(22), ' ')
		                    + "Linha"
		                    + Replicator.replicate(new Long(22), ' ')
		                    + "|");
		
		for (Simbolo simbolo : tabela) 
			System.out.println(simbolo);
	}
	
	public List<Simbolo> getTabela() {
		return tabela;
	}

	public void setTabela(List<Simbolo> tabela) {
		this.tabela = tabela;
	}
	
}
