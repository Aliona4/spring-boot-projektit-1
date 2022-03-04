package com.example.demo2.controllers;

import com.example.demo2.models.Post;
import com.example.demo2.pero.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<com.example.demo2.models.Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text,
            Model model) {
        if (!(title.isEmpty()) && !(full_text.isEmpty()) && !(anons.isEmpty())) {
            Post post = new Post(title, full_text, anons);
            postRepository.save(post);
            return "redirect:/blog";
        } else {
            return "redirect:/blog/add";
        }
    }
}
/*
 * @Controller
 * public class BlogController {
 * 
 * @Autowired
 * private PostRepository postRepository;
 * 
 * @GetMapping("/blog")
 * public String blogMain(Model model) {
 * Iterable<com.example.demo2.models.Post> posts = postRepository.findAll();
 * model.addAttribute("posts", posts);
 * return "blog-main";
 * }
 * 
 * @GetMapping("/blog/add")
 * public String blogAdd(Model model) {
 * 
 * return "blog-add";
 * }
 * 
 * @PostMapping("/blog/add")
 * public String blogPostAdd(@RequestParam String title, @RequestParam String
 * anons, @RequestParam String full_text,
 * Model model) {
 * if (!(title.isEmpty()) && !(full_text.isEmpty()) && !(anons.isEmpty())) {
 * Post post = new Post(title, full_text, anons);
 * postRepository.save(post);
 * return "redirect:/blog";
 * } else {
 * return "redirect:/blog/add";
 * }
 * }
 * }
 */