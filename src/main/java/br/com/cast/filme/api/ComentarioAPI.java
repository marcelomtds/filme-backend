package br.com.cast.filme.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.filme.dto.ComentarioDTO;
import br.com.cast.filme.service.ComentarioService;

@RestController
@RequestMapping(path="/comentario")
public class ComentarioAPI {
	
	@Autowired
	private ComentarioService comentarioService;
	
	@PostMapping
	public void comentar(@RequestBody ComentarioDTO comentarioDTO){
		comentarioService.comentar(comentarioDTO);
	}
	
	@GetMapping(path="/{idFilme}")
	public List<ComentarioDTO> buscarTodos(@PathVariable("idFilme") Integer idFilme) {
		return comentarioService.buscarTodos(idFilme);
	}
}
