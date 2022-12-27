package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Url;
import com.example.repository.UrlRepository;
import com.example.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	private UrlRepository urlRepository;

	@Override
	public List<Url> obterUrls() {
		return this.urlRepository.findAll();
	}

	@Override
	public String adicionar(Url url) {
		String mensagem = "";
		if(!url.getNome().equals("")) {
			List<Url> nomesList = this.urlRepository.findByNome(url.getNome());
			if(nomesList.size() == 0) {
				url.gerarUrlCurta();
				List<Url> nomesCurtosList = this.urlRepository.findByNomeCurto(url.getNomeCurto());
				while(nomesCurtosList.size() != 0) {
					url.gerarUrlCurta();
					nomesCurtosList = this.urlRepository.findByNomeCurto(url.getNomeCurto());
				}
				this.urlRepository.save(url);
				mensagem = "Cadastrada com sucesso: "+ url.getNomeCurto();
				
			}else {
				mensagem = "Url já foi cadastrada anteiormente, acesse por: "+nomesList.get(0).getNomeCurto();
			}
			
		}else {
			mensagem = "Nome da url vazio, por favor prencher";
		}
		return mensagem;		
	}
	
	@Override
	public List<Url> findByNomeCurto(String nomeCurto) {
		return this.urlRepository.findByNomeCurto(nomeCurto);
	}

	@Override
	public List<Url> findByNome(String nome) {
		return this.urlRepository.findByNome(nome);
	}

	@Override
	public String acessar(String nomeCurto) {
		List<Url> urls = this.urlRepository.findByNomeCurto(nomeCurto);
		if(urls.size() == 0) {
			return "Url não encontrada";
		}else {
			Url url = urls.get(0);
			url.incrementarQuantidadeAcessos();
			this.urlRepository.save(url);
			return url.getNome();
		}
	}
	
}
