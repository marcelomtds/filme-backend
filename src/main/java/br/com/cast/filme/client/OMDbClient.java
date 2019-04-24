package br.com.cast.filme.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.filme.dto.BuscarOMDb;
import br.com.cast.filme.dto.FilmeDTO;

@Component
public class OMDbClient {

	private static final String URL_BUSCAR_TODOS = "http://www.omdbapi.com/?s={titulo}&apikey={apikey}";
	private static final String URL_BUSCAR_POR_IDIMDB = "http://www.omdbapi.com/?i={id}&plot=full&apikey={apikey}";
	private static final String apikey = "e3ce8a9a";
	private RestTemplate client;
	
	public OMDbClient(RestTemplateBuilder builder) {
		this.client = builder.build();
	}
	
	public BuscarOMDb buscarPorTitulo(String titulo) {
		BuscarOMDb filmesOMDb = this.client.getForObject(URL_BUSCAR_TODOS, BuscarOMDb.class, titulo, apikey);
		return filmesOMDb;
	}

	public FilmeDTO buscarPorIdIMDb(String id) {
		FilmeDTO filmeDTO =  this.client.getForObject(URL_BUSCAR_POR_IDIMDB, FilmeDTO.class, id, apikey);
		return filmeDTO;
	}
}
