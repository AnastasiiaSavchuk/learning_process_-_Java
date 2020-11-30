package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @Column(nullable = false)
    private Set<Post> posts;

    public Comment(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                Objects.equals(authorName, comment.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName);
    }
}