package com.example.springrest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Post;

@RestController
public class MyPostController {
	
	//List<Post> posts = new ArrayList<Post>();
	static List<Post> posts = new ArrayList<>(
				Arrays.asList(
						new Post(1,"Title-1", "Body-1"),
						new Post(2,"Title-2", "Body-2"),
						new Post(3,"Title-3", "Body-3")
				));
		
	public MyPostController() {
		/*
		 * posts.add(new Post(1,"Title-1", "Body-1")); posts.add(new Post(2,"Title-2",
		 * "Body-2")); posts.add(new Post(3,"Title-3", "Body-3"));
		 */
	}


	@RequestMapping("/post")
	public List<Post> getPosts() {
		return posts;
	}
	
	@RequestMapping("/post/{id}")
	public Post getPost(@PathVariable int id) {
		for(Post post: posts) {
			if(post.getId() == id) {
				return post;
			}
		}
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/post")
	public void addPost(@RequestBody Post listelement) {
		posts.add(listelement);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/post/{id}")
	public void updatePost(@RequestBody Post updatedPost, @PathVariable int id) {
		for(int i=0; i<posts.size(); i++) {
			if(posts.get(i).getId() == id) {
				posts.add(i, updatedPost);
				return;
			}
		}
		
	}

}
