package br.com.cast.filme.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.filme.dto.FilmeDTO;
import br.com.cast.filme.service.FilmeService;

@RestController
@RequestMapping(path = "/filme")
public class FilmeAPI {

	@Autowired
	private FilmeService filmeService;

	@GetMapping
	public List<FilmeDTO> buscarTodos() {
		List<FilmeDTO> filmesDTO = filmeService.buscarTodos();
		return filmesDTO;
	}

	@GetMapping("/{id}")
	public FilmeDTO buscarPorId(@PathVariable Integer id) {
		FilmeDTO filmeDTO = filmeService.buscarPorId(id);
		return filmeDTO;
	}

	@GetMapping("buscarPorTitulo/{titulo}")
	public List<FilmeDTO> buscarPorTitulo(@PathVariable String titulo) {
		List<FilmeDTO> filmesDTO = filmeService.buscarPorTitulo(titulo);
		return filmesDTO;
	}
	
	@GetMapping(path="buscarPorTituloOMDb/{titulo}")
	public List<FilmeDTO> buscarPorTituloOMDb(@PathVariable String titulo) {
		List<FilmeDTO> filmesDTO = filmeService.buscarPorTituloOMDb(titulo);
		return filmesDTO;
	}
	
	@GetMapping(path="buscarPorIdOMDb/{id}")
	public FilmeDTO buscarPorIdOMDb(@PathVariable String id) {
		FilmeDTO filmeDTO = filmeService.buscarPorIdOMDb(id);
		return filmeDTO;
	}

	@PutMapping
	public void alterar(@RequestBody FilmeDTO filmeDTO) {
		filmeService.alterar(filmeDTO);
	}

	@DeleteMapping("/{id}")
	public String excluir(@PathVariable Integer id) {
		filmeService.excluir(id);
		return "";
	}
}