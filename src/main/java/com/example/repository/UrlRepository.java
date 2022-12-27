package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Url;

@Repository
public interface UrlRepository extends MongoRepository<Url, Long> {

	public List<Url> findByNome(String nome);
	public List<Url> findByNomeCurto(String nomeCurto);
}