package com.paulofigueiredo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.paulofigueiredo.workshopmongo.domain.Post;
import com.paulofigueiredo.workshopmongo.domain.User;
import com.paulofigueiredo.workshopmongo.repositories.PostRepository;
import com.paulofigueiredo.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar pra São Paulo. Abraços!",
				maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom Dia", "Acordei feliz hoje!", maria);

		postRepository.saveAll(Arrays.asList(post1, post2));
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

	}

}
