package br.com.cast.filme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmeDTO {

	private Integer id;

	@JsonProperty("imdbID")
	private String idImdb;

	@JsonProperty("Title")
	private String titulo;

	@JsonProperty("Poster")
	private String imagem;

	@JsonProperty("Year")
	private String ano;
	
	@JsonProperty("Genre")
	private String genero;
	
	@JsonProperty("Director")
	private String diretor;
	
	@JsonProperty("Runtime")
	private String duracao;
	
	@JsonProperty("Writer")
	private String escritores;
	
	@JsonProperty("Actors")
	private String atores;
	
	@JsonProperty("Plot")
	private String enredo;
	
	@JsonProperty("Language")
	private String idioma;
	
	@JsonProperty("Country")
	private String pais;
	
	@JsonProperty("Production")
	private String producao;
	
	@JsonProperty("Website")
	private String site;
	
	private String atualizado;

	public String getAtualizado() {
		return atualizado;
	}

	public void setAtualizado(String atualizado) {
		this.atualizado = atualizado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdImdb() {
		return idImdb;
	}

	public void setIdImdb(String idImdb) {
		this.idImdb = idImdb;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getEscritores() {
		return escritores;
	}

	public void setEscritores(String escritores) {
		this.escritores = escritores;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public String getEnredo() {
		return enredo;
	}

	public void setEnredo(String enredo) {
		this.enredo = enredo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
