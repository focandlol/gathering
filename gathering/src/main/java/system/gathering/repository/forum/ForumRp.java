package system.gathering.repository.forum;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import system.gathering.object.*;

import java.util.List;
import java.util.Optional;

public interface ForumRp {

    public LtForum save(LtForum ltForum);

    public void out(Long forumId, User user);

    public void feedBack(Feedback feedback);

    public Comment commentSave(Comment comment);

    public LtParticipant participantSave(LtParticipant ltParticipant);

    public List<LtForum> findAll();

    public LtForum findById(Long forumId);

    public List<Comment> commentFindById(Long forumId);

    public Comment findByCommentId(Long commentId);

    public Optional<LtParticipant> findLtParticipant(Long forumId, String userId);
    public List<LtParticipant> findAllParticipant(Long forumId);

    public Optional<Comment> findComment(Long forumId, String host);

    public void deleteComment(Long commentId);

    public void deleteForum(Long forumId);

    public List<LtParticipant> findAll(String userId);

    public List<LtParticipant> findPart(Long forumId, String host);

    public void updateLtForum(Long forumId, UpdateLtForum updateLtForum);

    public void updateComment(Long commentId);

    public void updateComments(Long forumId, String userId);

    public List<LtForum> indexLtForum();
    public Page<LtForum> searchLtForumPage(LtForumSearchCond ltForumSearchCond, Pageable pageable);
}
