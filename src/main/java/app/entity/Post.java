package app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@SuppressWarnings("ID")
@EqualsAndHashCode(callSuper = false)
@ToString
public class Post  extends AbstractEntity<Post> {
    private String title;
    private String content;

    private boolean star = false;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
//    @JoinColumn(name = "comments")
    List<Comment> comments = new ArrayList<>();
}
