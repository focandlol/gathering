package system.gathering.object;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Data
@DynamicInsert
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private Long forumId;

    @ManyToOne
    @JoinColumn(name = "host")
    private User host;
    private String comment;

    @ColumnDefault("unjoin")
    private String part;
}
