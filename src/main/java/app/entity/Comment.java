package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@SuppressWarnings("ID")
@EqualsAndHashCode(callSuper = false)
@ToString
public class Comment extends AbstractEntity<Comment> {
    private String text;

    @CreationTimestamp
    private LocalDateTime creationDate = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;
}
