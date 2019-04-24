package br.com.cast.filme.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.filme.dto.ComentarioDTO;
import br.com.cast.filme.entity.Comentario;
import br.com.cast.filme.entity.Filme;
import br.com.cast.filme.entity.Usuario;
import br.com.cast.filme.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	ComentarioRepository comentarioRepository;

	public void comentar(ComentarioDTO comentarioDTO) {
		Usuario usuario = new Usuario();
		Filme filme = new Filme();

		usuario.setId(comentarioDTO.getIdUsuarioDTO());
		filme.setId(comentarioDTO.getIdFilmeDTO());

		Comentario comentario = new Comentario();
		comentario.setComentario(comentarioDTO.getComentario());
		comentario.setData(new Date());
		comentario.setFilme(filme);
		comentario.setUsuario(usuario);

		comentarioRepository.inserir(comentario);
	}

	public List<ComentarioDTO> buscarTodos(Integer idFilme) {
		List<Comentario> comentarios = comentarioRepository.buscarTodos(idFilme);
		if (comentarios != null) {
			List<ComentarioDTO> comentariosDTO = new ArrayList<>();
			for (Comentario comentario : comentarios) {
				ComentarioDTO comentarioDTO = new ComentarioDTO();
				comentarioDTO.setComentario(comentario.getComentario());			
				comentarioDTO.setData(DateparaString(comentario.getData()));
				comentarioDTO.setIdFilmeDTO(comentario.getFilme().getId());
				comentarioDTO.setIdUsuarioDTO(comentario.getUsuario().getId());
				comentarioDTO.setNomeUsuario(comentario.getUsuario().getNome());
				comentarioDTO.setFotoUsuario(comentario.getUsuario().getFoto());
				comentariosDTO.add(comentarioDTO);
			}
			return comentariosDTO;
		}
		return null;
	}

	private String DateparaString(Date date) {
		SimpleDateFormat formatador;
		formatador = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
		String dataFormatada = formatador.format(date);
		return dataFormatada;

	}
}
