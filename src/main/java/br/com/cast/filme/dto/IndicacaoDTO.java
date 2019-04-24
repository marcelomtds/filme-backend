package br.com.cast.filme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.filme.entity.Filme;
import br.com.cast.filme.entity.Usuario;

public class IndicacaoDTO {

	private Integer id;
	private Integer destino;
	private String data;
	private String mensagem;
	private Usuario usuario;
	private Filme filme;

	@JsonProperty("idUsuario")
	private Integer idUsuarioDTO;

	@JsonProperty("idFilme")
	private Integer idFilmeDTO;

	public Integer getId() {
		return id;
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Filme getFilme() {
		return filme;
	}



	public void setFilme(Filme filme) {
		this.filme = filme;
	}



	public String getMensagem() {
		return mensagem;
	}



	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDestino() {
		return destino;
	}

	public void setDestino(Integer destino) {
		this.destino = destino;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getIdUsuarioDTO() {
		return idUsuarioDTO;
	}

	public void setIdUsuarioDTO(Integer idUsuarioDTO) {
		this.idUsuarioDTO = idUsuarioDTO;
	}

	public Integer getIdFilmeDTO() {
		return idFilmeDTO;
	}

	public void setIdFilmeDTO(Integer idFilmeDTO) {
		this.idFilmeDTO = idFilmeDTO;
	}

}
