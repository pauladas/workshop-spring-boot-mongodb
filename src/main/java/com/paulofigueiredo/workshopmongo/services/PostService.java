package com.paulofigueiredo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulofigueiredo.workshopmongo.domain.Post;
import com.paulofigueiredo.workshopmongo.exception.ObjectNotFoundException;
import com.paulofigueiredo.workshopmongo.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}

}
