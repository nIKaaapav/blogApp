package app.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@SuperBuilder
@RequiredArgsConstructor
@SuppressWarnings("ID")
@EqualsAndHashCode(callSuper = false)
@ToString
public class Post{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String title;
    private String content;

    private boolean star = false;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
    List<Comment> comments = new ArrayList<>();
}
