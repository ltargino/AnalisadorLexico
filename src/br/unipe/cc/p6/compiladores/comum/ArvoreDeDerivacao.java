package br.unipe.cc.p6.compiladores.comum;

public class ArvoreDeDerivacao {

	private No raiz;
	
	public void adicionarNoADireita(No no){
		if (this.raiz != null)
			this.raiz.adicionarNoADireita(no);
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
