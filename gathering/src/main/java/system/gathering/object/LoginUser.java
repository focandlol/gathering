package system.gathering.object;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginUser {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;
}
