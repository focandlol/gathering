package system.gathering.object.club;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    //private Long clubId;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    private String subject;
    private String host;
    private String content;
    private LocalDate date;
}
