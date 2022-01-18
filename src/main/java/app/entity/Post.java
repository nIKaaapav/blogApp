package app.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@RequiredArgsConstructor
public class Post  extends AbstractEntity<Post> {
    private String title;
    private String content;

    @Setter
    private boolean star = false;
}
