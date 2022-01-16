package app.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Post  extends AbstractEntity<Post> {
    private String title;
    private String content;
}
