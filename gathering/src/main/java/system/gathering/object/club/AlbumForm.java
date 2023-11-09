package system.gathering.object.club;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AlbumForm {

    private List<MultipartFile> imageFiles;
}
