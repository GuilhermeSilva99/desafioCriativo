package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.model.Url;
import com.example.repository.UrlRepository;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class UrlControllerTest {

	@Autowired
	private UrlController urlController;
	@Autowired
	private UrlRepository urlRepository;
		
	@Test
	public void salvarUrlInexistenteComSucesso() {
		Url url = new Url();
		url.setNome("www.ufape.com.br");
		String resultado = urlController.adicionar(url);
		String subStringResultadoString = resultado.substring(0, 23);
		urlRepository.delete(url);
		assertEquals("Cadastrada com sucesso:", subStringResultadoString);
	}
	
	@Test
	public void naoSalvarUrlJaExistente() {
		Url url = new Url();
		url.setNome("www.facebook.com.br");
		urlController.adicionar(url);
		String resultado = urlController.adicionar(url);
		String subStringResultadoString = resultado.substring(0, 47);
		urlRepository.delete(url);
		assertEquals("Url já foi cadastrada anteiormente, acesse por:", subStringResultadoString);
	}
	
	@Test
	public void acessarUrlPelaUrlCurta() {
		Url url = new Url();
		url.setNome("https://www.estado9898988.com/");
		url.setNomeCurto("es8986.com");
		urlRepository.save(url);
		String resultado = urlController.acessar(url.getNomeCurto());
		urlRepository.delete(url);
		assertEquals("https://www.estado9898988.com/", resultado);
	}
	
	@Test
	public void naoAcessarUrlPelaUrlCurta() {
		String nomeCurto = "batarinha.com";
		String resultado = urlController.acessar(nomeCurto);
		assertEquals("Url não encontrada", resultado);
	}
	
	@Test
	public void acessarEstatisticas() {
		Url url = new Url();
		url.setNome("www.facebook.com.br");
		urlController.adicionar(url);
		urlController.acessar(url.getNomeCurto());
		List<String> resultados = urlController.estatisticas();
		urlRepository.delete(url);
		assertEquals(1, resultados.size());
	}
	
}
