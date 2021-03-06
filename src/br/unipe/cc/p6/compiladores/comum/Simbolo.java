package br.unipe.cc.p6.compiladores.comum;

public class Simbolo {
	
	private final String lexema;
	
	private final String token;
	
	private final String linha;
	
	public Simbolo(String lexema, String token, String linha) {
		this.lexema = lexema;
		this.token = token;
		this.linha = linha;
	}

	@Override
	public String toString() {
		String linhaDeSimbolo = "";
		
		linhaDeSimbolo += "| " + this.lexema + Replicator.replicate(this.lexema, new Long(50), ' ');
		linhaDeSimbolo += "| " + this.token + Replicator.replicate(this.token, new Long(50), ' ');
		linhaDeSimbolo += "| " + this.linha + Replicator.replicate(this.linha, new Long(49), ' ');
		linhaDeSimbolo += "|";
		
		return linhaDeSimbolo;
	}
	
	public String getLexema() {
		return lexema;
	}

	public String getToken() {
		return token;
	}

	public String getLinha() {
		return linha;
	}
	
}
