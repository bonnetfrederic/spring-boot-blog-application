package com.myprojects.springbootblogapplication.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myprojects.springbootblogapplication.models.Account;
import com.myprojects.springbootblogapplication.models.Post;
import com.myprojects.springbootblogapplication.services.AccountService;
import com.myprojects.springbootblogapplication.services.PostService;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {
            Account account1 = new Account();
            Account account2 = new Account();

            account1.setEmail("user.user@domain.com");
            account1.setPassword("password");
            account1.setFirstName("user");
            account1.setLastName("user");

            account2.setEmail("admin.admin@domain.com");
            account2.setPassword("password");
            account2.setFirstName("admin");
            account2.setLastName("admin");

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("title of post1");
            post1.setBody("This is the body of post1");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("title of post2");
            post2.setBody("This is the body of post2");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);
        }
    }
}
