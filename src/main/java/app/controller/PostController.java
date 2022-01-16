package app.controller;

import app.entity.Post;
import app.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/posts")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public List<Post> getPosts(){
        return  postService.getPosts();
    }

    @PostMapping("")
    public void savePost(@RequestBody() Post post){
        postService.savePost(post);
    }

    @PutMapping("")
    public void updatePost(@RequestBody() Post post){
        postService.updatePost(post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }
}
