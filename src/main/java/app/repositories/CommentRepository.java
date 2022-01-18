package app.repositories;

import app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comment WHERE post_id = postID", nativeQuery = true)
    List<Comment> findAllByPostId(Long postID);
}
