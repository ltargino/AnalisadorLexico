package br.unipe.cc.p6.compiladores.analisadorsintatico;

import java.util.ArrayList;
import java.util.List;

import br.unipe.cc.p6.compiladores.comum.No;

public class ArvoreDeDerivacao {

	private No raiz;
	
	public void adicionarNoADireita(No no){
		if (this.raiz != null)
			this.raiz.adicionarNoADireita(no);
	}
	
	public List<No> getListNoInOrdem(){
		List<No> listNoInOrdem = new ArrayList<No>();
		No reference_no = this.raiz;
		
		while(reference_no != null) {
			
			if (!listNoInOrdem.contains(reference_no)) {
				listNoInOrdem.add(reference_no);
			}
			
			if (reference_no.getNoEsquerdo() != null && !listNoInOrdem.contains(reference_no.getNoEsquerdo())) {
				reference_no = reference_no.getNoEsquerdo();
			} else if(reference_no.getNoDireito() != null && !listNoInOrdem.contains(reference_no.getNoDireito())) {
				reference_no = reference_no.getNoDireito();
			} else if(reference_no.getNoEsquerdo() == null && reference_no.getNoDireito() == null) {
				reference_no = reference_no.getNoPai();
			} else {
				reference_no = null;
			}
		
		}
		
		return listNoInOrdem;
	}
	
	public void imprimirArvoreDeDerivacao(){
		System.out.println("ARVORE DE DERIVAÇÃO");

		if (this.raiz != null)
			this.raiz.imprimirNo(10);
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
}
