package com.example.model;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Url {
	
	@Id
	private String id;
	private String nome;
	private String nomeCurto;
	private int acessos;
	
	public void incrementarQuantidadeAcessos() {
		this.acessos += 1;
	}
	
	public void gerarUrlCurta() {
		String nomeAuxiliar = "";
		if(this.nome.contains(".")) {
			String nomeReplace = this.nome.replace(":", "/");
			nomeReplace = nomeReplace.replace(".", ":");
			String[] partesDaUrl = nomeReplace.split(":");
			for(int i = 0; i < partesDaUrl.length; i++) {
				if(!partesDaUrl[i].contains("www") && !partesDaUrl[i].contains("com") && !partesDaUrl[i].contains("br")) {
					if(partesDaUrl[i].length() > 2) {
						nomeAuxiliar += partesDaUrl[i].substring(0, 2);
					}else {
						nomeAuxiliar += partesDaUrl[i].substring(0, 1);
					}
				}
			}
		}
		Random random = new Random();
		nomeAuxiliar += random.nextInt(0000,9999);
		if(this.nome.contains("com")) {
			nomeAuxiliar+=".com";
		}
		if(this.nome.contains("br")) {
			nomeAuxiliar+=".br";
		}
		this.nomeCurto = nomeAuxiliar;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomeCurto() {
		return nomeCurto;
	}
	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}
	public int getAcessos() {
		return acessos;
	}
	public void setAcessos(int acessos) {
		this.acessos = acessos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Url other = (Url) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
