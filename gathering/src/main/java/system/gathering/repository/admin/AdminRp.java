package system.gathering.repository.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import system.gathering.object.FeedSearchCond;
import system.gathering.object.Feedback;
import system.gathering.object.User;
import system.gathering.object.UserSearchCond;


public interface AdminRp {
    public Page<User> searchUser(UserSearchCond userSearchCond, Pageable pageable);
    public void userOut(String userId);

    public Page<Feedback> searchFeedback(FeedSearchCond feedSearchCond, Pageable pageable);

    public void checkFeedback(Long id);

    public void downGrade(String defendant);
}
