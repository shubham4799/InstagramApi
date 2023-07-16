package com.example.InstagramAPI.service;

import com.example.InstagramAPI.exception.ResourceNotFoundException;
import com.example.InstagramAPI.model.Post;
import com.example.InstagramAPI.model.User;
import com.example.InstagramAPI.repository.PostRepository;
import com.example.InstagramAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void savePost(Long userId, String postData) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Post post = new Post();
        post.setUser(user);
        post.setPostData(postData);
        post.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        post.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

        postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}