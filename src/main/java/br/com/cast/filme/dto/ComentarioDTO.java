package br.com.cast.filme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComentarioDTO {

	private Integer id;

	private String comentario;

	private String data;

	private String nomeUsuario;

	private String fotoUsuario;

	@JsonProperty("idUsuario")
	private Integer idUsuarioDTO;

	@JsonProperty("idFilme")
	private Integer idFilmeDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getFotoUsuario() {
		return fotoUsuario;
	}

	public void setFotoUsuario(String fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}
}
