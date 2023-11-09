package system.gathering.object;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="lt_participant")
public class LtParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long forumId;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;
}
