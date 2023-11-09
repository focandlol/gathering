package system.gathering.object;

import lombok.Data;

@Data
public class LtForumSearchCond {

    private String subject;
    private String host;
    private String content;
    private Category category;
    private String state;

}
