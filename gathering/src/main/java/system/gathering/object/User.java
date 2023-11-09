package system.gathering.object;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@DynamicInsert
@DynamicUpdate
@Entity(name = "user2")
public class User {
    @NotBlank
    @Size(max = 20)
    @Id
    private String userId;

    @NotBlank
    @Size(min = 6,max = 30)
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 2, max = 10)
    @Column(name = "nickname")
    private String nickName;

    @NotBlank
    private String postcode;

    @NotBlank
    private String detailAddress;

    @NotBlank
    private String extraAddress;

    @NotBlank
    private String address;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;

    //@ColumnDefault("500")
    private Long grade;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String recentGathering;

    private String storeFile;

    private String uploadFile;

}
