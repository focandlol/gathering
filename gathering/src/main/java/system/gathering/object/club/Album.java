package system.gathering.object.club;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    //private Long clubId;
    @ManyToOne
    @JoinColumn(name = "club_id")
    @JsonIgnore
    private Club club;

    private String uploadFile;
    private String storeFile;

}
