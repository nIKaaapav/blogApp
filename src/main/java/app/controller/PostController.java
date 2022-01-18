package app.controller;

import app.entity.Post;
import app.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/posts")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public List<Post> getPosts(@RequestParam(value = "title", required = false) String title, @RequestParam(value = "sort", required = false) Sort.Direction sort){
        return postService.getPosts(title, sort);
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
