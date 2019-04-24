package br.com.cast.filme.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuscarOMDb {

	@JsonProperty("Search")
	private List<FilmeDTO> listaFilmesOMDb;

	public List<FilmeDTO> getListaFilmesOMDb() {
		return listaFilmesOMDb;
	}

	public void setListaFilmesOMDb(List<FilmeDTO> listaFilmesOMDb) {
		this.listaFilmesOMDb = listaFilmesOMDb;
	}
}
