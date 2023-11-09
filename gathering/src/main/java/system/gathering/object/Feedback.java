package system.gathering.object;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Data
@Entity
@DynamicInsert
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "defendant")
    private User defendant;

    private Long forumId;

    @Enumerated(value = EnumType.STRING)
    private Feed feed;

    private String content;

    @Enumerated(value = EnumType.STRING)
    private Checking checking;
}
