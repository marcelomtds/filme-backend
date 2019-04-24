package br.com.cast.filme.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.filme.dto.IndicacaoDTO;
import br.com.cast.filme.entity.Filme;
import br.com.cast.filme.entity.Indicacao;
import br.com.cast.filme.entity.Usuario;
import br.com.cast.filme.repository.IndicacaoRepository;

@Service
public class IndicacaoService {

	@Autowired
	IndicacaoRepository indicacaoRepository;

	public void inserir(IndicacaoDTO indicacaoDTO) {

		Indicacao indicacao = DTOparaEntidade(indicacaoDTO);
		indicacaoRepository.inserir(indicacao);

	}

	private Indicacao DTOparaEntidade(IndicacaoDTO indicacaoDTO) {
		Indicacao indicacao = new Indicacao();
		indicacao.setId(indicacaoDTO.getId());
		indicacao.setDestino(indicacaoDTO.getDestino());
		indicacao.setMensagem(indicacaoDTO.getMensagem());
		indicacao.setData(new Date());

		Usuario usuario = new Usuario();
		usuario.setId(indicacaoDTO.getIdUsuarioDTO());

		Filme filme = new Filme();
		filme.setId(indicacaoDTO.getIdFilmeDTO());

		indicacao.setUsuario(usuario);
		indicacao.setFilme(filme);
		return indicacao;
	}

	private String DateparaString(Date date) {
		SimpleDateFormat formatador;
		formatador = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
		String dataFormatada = formatador.format(date);
		return dataFormatada;

	}

	public List<IndicacaoDTO> buscarPorUsuario(Integer id) {
		List<Indicacao> indicacoes = indicacaoRepository.buscarPorId(id);
		if (indicacoes != null) {
			List<IndicacaoDTO> indicacoesDTO = new ArrayList<>();
			for (Indicacao indicacao : indicacoes) {
				IndicacaoDTO indicacaoDTO = entidadeParaDTO(indicacao);
				indicacoesDTO.add(indicacaoDTO);
				
			}
			return indicacoesDTO;
		}
		return null;
	}

	private IndicacaoDTO entidadeParaDTO(Indicacao indicacao) {
		IndicacaoDTO indicacaoDTO = new IndicacaoDTO();
		indicacaoDTO.setId(indicacao.getId());
		indicacaoDTO.setMensagem(indicacao.getMensagem());
		indicacaoDTO.setFilme(indicacao.getFilme());
		indicacaoDTO.setData(DateparaString(indicacao.getData()));
		indicacaoDTO.setUsuario(indicacao.getUsuario());
		indicacaoDTO.setDestino(indicacao.getDestino());
		indicacaoDTO.setIdUsuarioDTO(indicacao.getUsuario().getId());
		indicacaoDTO.setIdFilmeDTO(indicacao.getFilme().getId());
		
		return indicacaoDTO;
	}
}
