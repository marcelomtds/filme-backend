package br.com.cast.filme.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.filme.dto.IndicacaoDTO;
import br.com.cast.filme.service.IndicacaoService;

@RestController
@RequestMapping("/indicacao")
public class IndicacaoAPI {
	
	@Autowired
	IndicacaoService indicacaoService;
	
	@PostMapping
	public void inserir(@RequestBody IndicacaoDTO indicacaoDTO) {
		indicacaoService.inserir(indicacaoDTO);
	}
	
	@GetMapping(path="/{id}")
	public List<IndicacaoDTO> buscarPorUsuario(@PathVariable("id") Integer id){
		return indicacaoService.buscarPorUsuario(id);
	}

}
