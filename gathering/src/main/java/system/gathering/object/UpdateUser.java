package system.gathering.object;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateUser {
    @NotBlank
    @Size(min = 6,max = 30)
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String postcode;

    @NotBlank
    private String detailAddress;

    @NotBlank
    private String extraAddress;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;

    private MultipartFile uploadFile;

}
