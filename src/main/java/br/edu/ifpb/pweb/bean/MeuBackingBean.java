package br.edu.ifpb.pweb.bean;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.edu.ifpb.pweb.util.EstadoCivilEnum;

@ManagedBean(name = "bbean")
@RequestScoped
public class MeuBackingBean {

	private String mensagem = "Produzido no bbean";
	private String nome;
	private int idade;
	private String faixa;
	private String senha;
	private String nomeCidade;
	private Integer cidade;
	private EstadoCivilEnum estCivil;
	private String estadoSelecionado;

	private String[] cidades = { "João Pessoa", "Campina Grande", "Taperoá", "Soledade", "Juazeirinho" };

	private Map<String, String> estados;

	public MeuBackingBean(){
		this.estados = new HashMap<String, String>();
		estados.put("AC","Acre");  
		estados.put("AL","Alagoas");  
		estados.put("AM","Amazonas");  
		estados.put("AP","Amapá");  
		estados.put("BA","Bahia");  
		estados.put("CE","Ceará");  
		estados.put("DF","Distrito Federal");  
		estados.put("ES","Espirito Santo");  
		estados.put("GO","Goias");  
		estados.put("MA","Maranhão");  
		estados.put("MG","Minas Gerais");  
		estados.put("MS","Mato Grosso Sul");  
		estados.put("MT","Mato Grosso");  
	    estados.put("MT","Mato Grosso");  
	    estados.put("PA","Pará");  
	    estados.put("PB","Paraiba");  
	    estados.put("PE","Pernanbuco");  
	    estados.put("PI","Piaui");  
	    estados.put("PR","Parana");  
	    estados.put("RJ","Rio de Janeiro");  
	    estados.put("RN","Rio Grande do Norte");  
	    estados.put("RO","Rondônia");  
	    estados.put("RR","Roraima");  
	    estados.put("RS","Rio Grande do Sul");  
	    estados.put("SC","Santa Catarina");  
	    estados.put("SE","Sergipe");  
	    estados.put("SP","São Paulo");  
	    estados.put("TO","Tocantins");
	}

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

	public String minusculas() {
		this.nome = this.nome.toLowerCase();
		return null;
	}

	public String maiusculas() {
		this.nome = this.nome.toUpperCase();
		return null;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getFaixa() {
		return faixa;
	}

	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}

	public String calculeFaixa() {
		if (this.idade >= 18 && this.idade <= 25) {
			this.faixa = "Jovem";
		} else if (this.idade <= 59) {
			this.faixa = "Adulto";
		} else if (this.idade <= 90) {
			this.faixa = "Idoso";
		}
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String valideSenha() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String msg = "Senha não confere!";
		FacesMessage.Severity nivel = FacesMessage.SEVERITY_ERROR;
		if (this.senha.equalsIgnoreCase("secret")) {
			msg = "Senha confere!";
			nivel = FacesMessage.SEVERITY_INFO;
		}
		FacesMessage facesMsg = new FacesMessage(nivel, msg, null);
		fc.addMessage("form4:senha", facesMsg);
		return null;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String[] getCidades() {
		return cidades;
	}

	public void setCidades(String[] cidades) {
		this.cidades = cidades;
	}

	public void selecioneCidade(ActionEvent e) {
		if (cidade != null) {
			this.nomeCidade = cidades[cidade];
		}
	}

	public EstadoCivilEnum getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(EstadoCivilEnum estCivil) {
		this.estCivil = estCivil;
	}

	public EstadoCivilEnum[] getEstadosCivis() {
		return EstadoCivilEnum.values();
	}

	public void selecioneEstCivil(ActionEvent e) {
		// vazio!
	}

	public Map<String, String> getEstados() {
		return estados;
	}

	public void setEstados(Map<String, String> estados) {
		this.estados = estados;
	}

	public String getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(String estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}
	
}
