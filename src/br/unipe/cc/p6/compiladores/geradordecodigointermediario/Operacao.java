package br.unipe.cc.p6.compiladores.geradordecodigointermediario;

import br.unipe.cc.p6.compiladores.comum.Replicator;

public class Operacao {

	private int id;
	
	private String oper;
	
	private String arg1;
	
	private String arg2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperador() {
		return oper;
	}

	public void setOperador(String oper) {
		this.oper = oper;
	}

	public String getArg1() {
		return arg1;
	}

	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}
	
	@Override
	public String toString() {
		String linhaDeOperacao = "";
		
		linhaDeOperacao += "|[" + this.id +"]";
		linhaDeOperacao += "| " + this.oper + Replicator.replicate(this.oper, new Long(20), ' ');
		linhaDeOperacao += "| " + this.arg1 + Replicator.replicate(this.arg1, new Long(20), ' ');
		linhaDeOperacao += "| " + this.arg2 + Replicator.replicate(this.arg2, new Long(20), ' ');
		linhaDeOperacao += "|";
		
		return linhaDeOperacao;
	}
	
}
