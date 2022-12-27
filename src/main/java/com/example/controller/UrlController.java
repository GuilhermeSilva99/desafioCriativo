package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Url;
import com.example.service.UrlService;

@RestController
@RequestMapping("/url")
public class UrlController {
	
	@Autowired
	private UrlService urlService;
	
	@GetMapping("/estatisticas")
	public List<String> estatisticas() {
		List<String> estatisticaStrings = new ArrayList<>();
		List<Url> urls = urlService.obterUrls();
		String informacoes = "";
		for (Url url : urls) {
			informacoes = "Nome: "+url.getNome()+" | nomeCurto: "+url.getNomeCurto()+" | quantidade de acessos: "+url.getAcessos();
			estatisticaStrings.add(informacoes);
		}
		return estatisticaStrings;
	}
	
	@PostMapping
	public String adicionar(@RequestBody Url url) {
		return urlService.adicionar(url);
	}
	
	@GetMapping("/{nomeCurto}")
	public String acessar(@PathVariable String nomeCurto) {
		return this.urlService.acessar(nomeCurto);
	}
}
