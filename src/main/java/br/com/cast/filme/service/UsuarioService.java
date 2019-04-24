package br.com.cast.filme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.filme.dto.UsuarioDTO;
import br.com.cast.filme.entity.Usuario;
import br.com.cast.filme.repository.UsuarioRepositry;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepositry usuarioRepository;

	public List<UsuarioDTO> buscarTodos(Integer id) {
		
		List<UsuarioDTO> usuariosDTO = usuarioRepository.buscarTodos(id);
		return usuariosDTO;
			
	}
	

	public UsuarioDTO autenticar(String email, String senha) {
		Usuario usuario = usuarioRepository.autenticar(email, senha);
		if(usuario != null) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setEmail(usuario.getEmail());
			usuarioDTO.setFoto(usuario.getFoto());
			usuarioDTO.setId(usuario.getId());
			usuarioDTO.setNome(usuario.getNome());
			usuarioDTO.setSenha(usuario.getSenha());
			return usuarioDTO;
		}
		return null;
	}

	public void inserir(UsuarioDTO usuarioDTO) {
		Usuario usuario = DTOparaEntidade(usuarioDTO);
		usuarioRepository.inserir(usuario);
	}

	private Usuario DTOparaEntidade(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setFoto(usuarioDTO.getFoto());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setSenha(usuarioDTO.getSenha());
		return usuario;
	}


}
