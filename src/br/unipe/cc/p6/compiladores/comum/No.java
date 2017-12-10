package br.unipe.cc.p6.compiladores.comum;

import java.util.ArrayList;
import java.util.List;

public class No {

	private List<Simbolo> dadosDoNo;
	
	private No noEsquerdo;
	
	private No noDireito;

	public No(){
		this.dadosDoNo = new ArrayList<Simbolo>();
	}
	
	public void adicionarNoADireita(No no){
		if (this.noDireito == null){
			this.noDireito = no;
		} else {
			this.noDireito.adicionarNoADireita(no);
		}
	}
	
	public void imprimirNo(int positionReference){
		for (Simbolo simbolo : this.dadosDoNo) {
			System.out.println( Replicator.leftReplicate(positionReference*10,' ') + simbolo.getLexema());
		}
		
		if (this.noEsquerdo != null)
			this.noEsquerdo.imprimirNo(positionReference-1);
		
		if (this.noDireito != null)
			this.noDireito.imprimirNo(positionReference+1);
	}
	
	public No getNoEsquerdo() {
		return noEsquerdo;
	}
	
	public void setNoEsquerdo(No noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}

	public No getNoDireito() {
		return noDireito;
	}

	public void setNoDireito(No noDireito) {
		this.noDireito = noDireito;
	}

	public List<Simbolo> getDadosDoNo() {
		return dadosDoNo;
	}

	public void setDadosDoNo(List<Simbolo> dadosDoNo) {
		this.dadosDoNo = dadosDoNo;
	}
	
}
