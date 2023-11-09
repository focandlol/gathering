package system.gathering.service.ltForum;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.gathering.object.*;
import system.gathering.repository.forum.ForumRepository2;
import system.gathering.repository.forum.ForumRp;
import system.gathering.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LtForumService {

    private final ForumRp forumRp;
    private final ForumRepository2 forumRepository2;
    private final UserRepository userRepository;

    public LtForum save(LtForum ltForum){
        return forumRp.save(ltForum);
    }

    public void out(Long forumId, User user){
        forumRp.out(forumId, user);
    }

    public Comment commentSave(Comment comment){
        return forumRp.commentSave(comment);
    }

    public LtParticipant participantSave(LtParticipant ltParticipant){
        return forumRp.participantSave(ltParticipant);
    }

    public List<LtForum> findAll(){
        return forumRp.findAll();
    }

    public Page<LtForum> findAll(Pageable pageable){
        return forumRepository2.findAll(pageable);
    }

    public LtForum findById(Long forumId){
        return forumRp.findById(forumId);
    }

    public List<Comment> commentFindById(Long forumId){
        return forumRp.commentFindById(forumId);
    }

    public Comment findByCommentId(Long commentId){
        return forumRp.findByCommentId(commentId);
    }

    public Optional<Comment> findComment(Long forumId, String host){
        return forumRp.findComment(forumId, host);
    }

    public Optional<LtParticipant> findLtParticipant(Long forumId, String userId){
        return forumRp.findLtParticipant(forumId, userId);
    }

    public void deleteComment(Long commentId){
        forumRp.deleteComment(commentId);
    }

    public void deleteForum(Long forumId){
        forumRp.deleteForum(forumId);
    }

    public List<LtParticipant> findAll(String userId){
        return forumRp.findAll(userId);
    }

    public List<LtParticipant> findPart(Long forumId, String host){
        return forumRp.findPart(forumId,host);
    }

    public void updateLtForum(Long forumId, UpdateLtForum updateLtForum){
        forumRp.updateLtForum(forumId, updateLtForum);
    }

    public void updateComment(Long commentId){
        forumRp.updateComment(commentId);
    }
    public void updateComments(Long forumId, String userId){
        forumRp.updateComments(forumId, userId);
    }

    public Page<LtForum> searchLtForumPage(LtForumSearchCond ltForumSearchCond, Pageable pageable){
        return forumRp.searchLtForumPage(ltForumSearchCond, pageable);
    }

    public void create(String a){
        String tableName = "ltforum" + a;
        userRepository.create(tableName);
    }

    public void updateToStart(Long forumId){
        LtForum findForum = forumRp.findById(forumId);
        findForum.setState("ing");
    }

    public void updateToEnd(Long forumId){
        LtForum findForum = forumRp.findById(forumId);
        findForum.setState("com");
    }

    public List<LtParticipant> findAllParticipant(Long forumId){
        return forumRp.findAllParticipant(forumId);
    }

    public void feedBack(Feedback feedback){
        forumRp.feedBack(feedback);
    }
}
