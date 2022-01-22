package app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@SuperBuilder
@RequiredArgsConstructor
@SuppressWarnings("ID")
@EqualsAndHashCode(callSuper = false)
@ToString
//@Builder
public class Comment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String text;

    @CreationTimestamp
    private LocalDateTime creationDate = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "post_id")
    @JoinColumn(name="post_id", nullable=false)
    private Post post;
}
