package app.controller;

import app.entity.Comment;
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

    @GetMapping("/star")
    public List<Post> getStarPost(){
        return postService.getStarPost();
    }

    @PutMapping("{id}/star")
    public void updatePostLikeStar(@PathVariable("id") Long id){
        postService.updatePostLikeStar(id);
    }

    @DeleteMapping("{id}/star")
    public void deleteStarInPost(@PathVariable("id") Long id){
        postService.deleteStarInPost(id);
    }

    @GetMapping("{id}/comments")
    public List<Comment> getCommentsPostById(@PathVariable("id") Long id){
        return postService.getCommentsPostById(id);
    }

    @PostMapping("{id}/comments")
    public void saveCommentsPost(@PathVariable("id") Long id, @RequestBody String text){
        postService.saveCommentsPost(id, text);
    }

    @GetMapping("{id}/comments/{commentId}")
    public Comment getComment(@PathVariable("id") Long postId, @PathVariable("commentId") Long commentId){
        return postService.getComment(commentId);
    }
}
