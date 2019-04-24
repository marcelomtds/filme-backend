package br.com.cast.filme.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.filme.dto.UsuarioDTO;
import br.com.cast.filme.service.UsuarioService;

@RestController
@RequestMapping(path = "usuario")
public class UsuarioAPI {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping(path = "/buscarTodos/{id}")
	public List<UsuarioDTO> buscarTodos(@PathVariable("id") Integer id) {
		List<UsuarioDTO> usuariosDTO = usuarioService.buscarTodos(id);
		return usuariosDTO;
	}

	@GetMapping(path = "/autenticar/{email}/{senha}")
	public UsuarioDTO autenticar(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		UsuarioDTO usuarioDTO = usuarioService.autenticar(email, senha);
		return usuarioDTO;
	}

	@PostMapping
	public void inserir(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.inserir(usuarioDTO);
	}

	@GetMapping(path = "/downloadFoto")
	public void downloadFoto(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("foto") String nomeImagem) throws IOException {
		String diretorioArquivos = "C:\\treinamento\\wsweb\\filme\\fotos\\";
		File file = new File(diretorioArquivos + nomeImagem);
		FileInputStream in = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		in.read(bytes);
		response.setContentType("image/jpeg");
		response.getOutputStream().write(bytes);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/foto")
	public Resposta foto(@RequestPart("file") Part part) throws IOException {
		String uuid = UUID.randomUUID().toString();
		String diretorioArquivos = "C:\\treinamento\\wsweb\\filme\\fotos\\";
		String nomeDoArquivo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String c = uuid + "-" + nomeDoArquivo;
		String caminhoCompleto = diretorioArquivos + c;
		part.write(caminhoCompleto);
		return new Resposta(c);
	}

	private class Resposta {
		private String caminhoCompleto;

		public Resposta(String caminhoCompleto) {
			this.caminhoCompleto = caminhoCompleto;
		}

		public String getCaminhoCompleto() {
			return caminhoCompleto;
		}

	}
}
