package system.gathering.object;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity(name = "lt_forum")
@DynamicInsert
public class LtForum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forumId;
    @NotBlank
    private String subject;
    @NotBlank
    private String content;

    @ManyToOne
    @JoinColumn(name = "host")
    private User host;
    @NotBlank
    private String postcode;
    @NotBlank
    private String address;
    @NotBlank
    private String detailAddress;
    @NotBlank
    private String extraAddress;

    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    private int num;
    @NotBlank
    private String startTime;

    private LocalDate date;

    private String state; //ing,com

}
