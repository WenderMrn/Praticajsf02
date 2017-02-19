package br.edu.ifpb.pweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbean")
@RequestScoped
public class MeuBackingBean {

	private String mensagem = "Produzido no bbean";
	private String nome;

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return this.mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String minusculas(){
		this.nome = this.nome.toLowerCase();
		return null;
	}
	
	public String maiusculas(){
		this.nome = this.nome.toUpperCase();
		return null;
	}


}
