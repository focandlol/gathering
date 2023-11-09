package system.gathering.object;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class UpdateLtForum {

    private String subject;
    private String content;
    private String postcode;
    private String address;
    private String detailAddress;
    private String extraAddress;
    private Category category;
    private int num;
    private String startTime;

}
