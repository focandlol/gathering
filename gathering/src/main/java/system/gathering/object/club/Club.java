package system.gathering.object.club;

import jakarta.persistence.*;
import lombok.Data;
import system.gathering.object.Category;
import system.gathering.object.User;

@Entity
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;
    private String clubName;

    @ManyToOne
    @JoinColumn(name = "host")
    private User host;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String intro;
    private String uploadFile;
    private String storeFile;
}
