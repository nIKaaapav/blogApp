package app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T> {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Getter
    @Setter
    private Long id;
}

