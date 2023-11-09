package system.gathering.object.club;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateClub {

    private String clubName;
    private String intro;

    private String uploadFile;
    private String storeFile;

    private MultipartFile file;
}
