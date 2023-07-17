package com.vikash.joblisting.Controller;

import com.vikash.joblisting.model.*;
import com.vikash.joblisting.repository.PostRepository;
import com.vikash.joblisting.repository.SearchRepository;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class PostController {

	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	
	@ApiIgnore // ignore the options of api
	@RequestMapping(value = "/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
       return repo.findAll();
    		   
	}
	
	@GetMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text){
		return srepo.findByText(text);
		
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
	}

}
