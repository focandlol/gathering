package system.gathering.object.club;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import system.gathering.object.Category;

@Data
public class AddClub {

    private String clubName;
    private String intro;
    private MultipartFile uploadFile;

    private Category category;
}
