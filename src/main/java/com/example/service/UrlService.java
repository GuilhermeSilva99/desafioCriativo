package com.example.service;

import java.util.List;

import com.example.model.Url;

public interface UrlService {
	
	public List<Url> obterUrls();
	public String adicionar(Url url);
	public String acessar(String nomeCurto);
	public List<Url> findByNome(String nome);
	public List<Url> findByNomeCurto(String nomeCurto);
}
