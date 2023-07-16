package com.example.InstagramAPI.controller;

import com.example.InstagramAPI.model.Post;
import com.example.InstagramAPI.model.User;
import com.example.InstagramAPI.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/")
    public ResponseEntity<Void> savePost(@RequestBody Post postRequest) {
        postService.savePost(postRequest.getUser().getId(), postRequest.getPostData());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        Post postResponse = new Post(post.getCreatedDate(), post.getUpdatedDate(), post.getPostData(), post.getUser());
        return ResponseEntity.ok(postResponse);
    }

}





