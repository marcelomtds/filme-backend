package br.com.cast.filme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.filme.client.OMDbClient;
import br.com.cast.filme.dto.BuscarOMDb;
import br.com.cast.filme.dto.FilmeDTO;
import br.com.cast.filme.entity.Filme;
import br.com.cast.filme.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	FilmeRepository filmeRepository;

	@Autowired
	OMDbClient omDbClient;

	public void inserir(List<FilmeDTO> filmesDTO) {

		for (FilmeDTO filmeDTO : filmesDTO) {
			Filme filme = DTOParaEntidade(filmeDTO);
			filmeRepository.inserir(filme);
		}

	}

	public void alterar(FilmeDTO filmeDTO) {
		Filme filme = DTOParaEntidade(filmeDTO);
		filmeRepository.alterar(filme);
	}

	public List<FilmeDTO> buscarTodos() {
		List<Filme> filmes = filmeRepository.buscarTodos();
		List<FilmeDTO> filmesDTO = new ArrayList<>();
		for (Filme filme : filmes) {
			FilmeDTO filmeDTO = EntidadeParaDTO(filme);
			filmesDTO.add(filmeDTO);
		}
		return filmesDTO;
	}

	public FilmeDTO buscarPorId(Integer id) {
		Filme filme = filmeRepository.buscarPorId(id);
		FilmeDTO filmeDTO = EntidadeParaDTO(filme);
		return filmeDTO;
	}

	public void excluir(Integer id) {
		Filme filme = filmeRepository.buscarPorId(id);
		filmeRepository.excluir(filme);
	}

	public List<FilmeDTO> buscarPorTitulo(String titulo) {
		List<Filme> filmes = filmeRepository.buscarPorTitulo(titulo);
		if (!filmes.isEmpty()) {
			List<FilmeDTO> filmesDTO = new ArrayList<>();
			for (Filme f : filmes) {
				FilmeDTO filmeDTO = EntidadeParaDTO(f);
				filmesDTO.add(filmeDTO);
			}
			return filmesDTO;
		}
		return null;
	}

	private FilmeDTO EntidadeParaDTO(Filme filme) {
		FilmeDTO filmeDTO = new FilmeDTO();
		filmeDTO.setAno(filme.getAno());
		filmeDTO.setAtores(filme.getAtores());
		filmeDTO.setAtualizado(filme.getAtualizado());
		filmeDTO.setDiretor(filme.getDiretor());
		filmeDTO.setDuracao(filme.getDuracao());
		filmeDTO.setEnredo(filme.getEnredo());
		filmeDTO.setEscritores(filme.getEscritores());
		filmeDTO.setGenero(filme.getGenero());
		filmeDTO.setId(filme.getId());
		filmeDTO.setIdImdb(filme.getIdImdb());
		filmeDTO.setIdioma(filme.getIdioma());
		filmeDTO.setImagem(filme.getImagem());
		filmeDTO.setPais(filme.getPais());
		filmeDTO.setProducao(filme.getProducao());
		filmeDTO.setSite(filme.getSite());
		filmeDTO.setTitulo(filme.getTitulo());
		return filmeDTO;
	}

	private Filme DTOParaEntidade(FilmeDTO filmeDTO) {
		Filme filme = new Filme();
		filme.setId(filmeDTO.getId());
		filme.setAno(filmeDTO.getAno());
		filme.setIdImdb(filmeDTO.getIdImdb());
		filme.setTitulo(filmeDTO.getTitulo());		
		filme.setImagem(filmeDTO.getImagem());		
		filme.setAtores(filmeDTO.getAtores());
		filme.setAtualizado(filmeDTO.getAtualizado());
		filme.setDiretor(filmeDTO.getDiretor());
		filme.setDuracao(filmeDTO.getDuracao());
		filme.setEnredo(filmeDTO.getEnredo());
		filme.setEscritores(filmeDTO.getEscritores());
		filme.setGenero(filmeDTO.getGenero());
		filme.setIdioma(filmeDTO.getIdioma());
		filme.setPais(filmeDTO.getPais());
		filme.setProducao(filmeDTO.getProducao());
		filme.setSite(filmeDTO.getSite());
		return filme;
	}

	public List<FilmeDTO> buscarPorTituloOMDb(String titulo) {
		BuscarOMDb listaOMDb = omDbClient.buscarPorTitulo(titulo);
		List<FilmeDTO> filmesDTO = new ArrayList<>();
		for (FilmeDTO filme : listaOMDb.getListaFilmesOMDb()) {
			FilmeDTO filmeDTO = new FilmeDTO();
			filmeDTO.setAno(filme.getAno());
			filmeDTO.setId(filme.getId());
			filmeDTO.setIdImdb(filme.getIdImdb());
			filmeDTO.setTitulo(filme.getTitulo());
			if(filme.getImagem() == "N/A") {
				filmeDTO.setImagem("http://www.navegantescorteedobra.com.br/wp-content/uploads/2012/01/sem-foto1.jpg");
			} else {
				filmeDTO.setImagem(filme.getImagem());
			}
			filmesDTO.add(filmeDTO);
		}
		inserir(filmesDTO);
		return filmesDTO;
	}

	public FilmeDTO buscarPorIdOMDb(String id) {
		Filme filme = filmeRepository.buscarPorIdOMDb(id);

		if(filme != null) {			
			if (filme.getAtualizado() != null) {
				FilmeDTO filmeDTO = EntidadeParaDTO(filme);
				return filmeDTO;
				
			} else {
				
				FilmeDTO filmeDTO = omDbClient.buscarPorIdIMDb(id);
				Filme filmeAtualizado = DTOParaEntidade(filmeDTO);
				filmeAtualizado.setAtualizado("atualizado");
				filmeAtualizado.setId(filme.getId());
				filmeRepository.inserirDetalhes(filmeAtualizado);
				return filmeDTO;
			}
		}
		return null;
	}
}
