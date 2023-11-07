package com.myprojects.springbootblogapplication.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.myprojects.springbootblogapplication.models.Account;
import com.myprojects.springbootblogapplication.models.Post;
import com.myprojects.springbootblogapplication.services.AccountService;
import com.myprojects.springbootblogapplication.services.PostService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postService.getById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }
    }

    @GetMapping("/posts/new")
    public String createNewPost(Model model) {
        Optional<Account> optionalAccount = accountService.findByEmail("user.user@domain.com");
        if (optionalAccount.isPresent()) {
            Post post = new Post();
            post.setAccount(optionalAccount.get());
            model.addAttribute("post", post);
            return "post_new";
        } else {
            return "404";
        }
        
    }

    @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post) {
        Optional<Account> optionalAccount = accountService.findByEmail("user.user@domain.com");

        if (optionalAccount.isPresent()) {
            post.setAccount(optionalAccount.get());
            postService.save(post);
            return "redirect:/posts/" + post.getId();
        } else {
            return "home";
        }
    }
    
}
