package app.services;

import app.entity.Post;
import app.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getPosts(String title, Sort.Direction sort){

        if (title != null){
            return postRepository.findAllByTitle(title);
        } else if (sort != null){
            return postRepository.findAll(Sort.by(sort, "title"));
        }

        return postRepository.findAll();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

    public void updatePost(Post post){
        postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public List<Post> getStarPost(){
        return postRepository.findAllByStar(true);
    }

    public void updatePostLikeStar(Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Post newPost = post.get();
            newPost.setStar(true);
            postRepository.save(newPost);
        }
    }

    public void deleteStarInPost(Long id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()){
            Post newPost = post.get();
            newPost.setStar(false);
            postRepository.save(newPost);
        }
    }
}
