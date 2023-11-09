package system.gathering.repository.forum;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import system.gathering.object.*;
import system.gathering.object.club.Club;
import system.gathering.object.club.ClubParticipant;
import system.gathering.object.club.ClubSearchCond;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

import static system.gathering.object.QLtForum.ltForum;
import static system.gathering.object.club.QClub.club;

@Slf4j
@Repository
public class ForumRepository implements ForumRp{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public ForumRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public void out(Long forumId, User user){
        em.createQuery("delete from lt_participant a where a.forumId = :forumId and a.user =:user")
                .setParameter("forumId", forumId)
                .setParameter("user",user)
                .executeUpdate();
        em.clear();
    }

    @Override
    public LtForum save(LtForum ltForum) {
        em.persist(ltForum);
        return ltForum;
    }

    @Override
    public void feedBack(Feedback feedback){
        em.persist(feedback);
    }

    @Override
    public Comment commentSave(Comment comment) {
        em.persist(comment);
        log.info("commentrep={}",comment);
        return comment;
    }

    @Override
    public LtParticipant participantSave(LtParticipant ltParticipant){
        em.persist(ltParticipant);
        return ltParticipant;
    }

    @Override
    public List<LtForum> findAll() {
        String jpql = "select i from lt_forum i";
        TypedQuery<LtForum> query = em.createQuery(jpql, LtForum.class);
        return query.getResultList();
    }

    @Override
    public LtForum findById(Long forumId){
        LtForum ltForum = em.find(LtForum.class, forumId);
        return ltForum;
    }

    @Override
    public List<Comment> commentFindById(Long forumId){
        List<Comment> findComment = em.createQuery("select i from Comment i where i.forumId = :forumId", Comment.class)
                .setParameter("forumId", forumId)
                .getResultList();
        return findComment;
    }

    @Override
    public Comment findByCommentId(Long commentId){
        Comment comment = em.find(Comment.class, commentId);
        return comment;
    }

    @Override
    public Optional<Comment> findComment(Long forumId, String host){
        Optional<Comment> first = em.createQuery("select i from Comment i where i.forumId= :forumId and i.host.userId= :host",
                       Comment.class)
                .setParameter("forumId", forumId)
                .setParameter("host", host)
                .getResultList()
                .stream().findFirst();
        return first;
    }

    @Override
    public Optional<LtParticipant> findLtParticipant(Long forumId, String userId){
        Optional<LtParticipant> first = em.createQuery("select i from lt_participant i where i.forumId= :forumId and i.user.userId= :userId",
                        LtParticipant.class)
                .setParameter("forumId", forumId)
                .setParameter("userId", userId)
                .getResultList()
                .stream().findFirst();
        return first;
    }

    @Override
    public List<LtParticipant> findAllParticipant(Long forumId){
        List<LtParticipant> forumId1 = em.createQuery("select i from lt_participant i where i.forumId= :forumId",
                        LtParticipant.class)
                .setParameter("forumId", forumId)
                .getResultList();
        return forumId1;
    }

    @Override
    public void deleteComment(Long commentId){
       /* em.createQuery("delete from Comment i where i.commentId=:commentId", Comment.class)
                .setParameter("commentId", commentId);*/
        Comment comment = em.find(Comment.class, commentId);
        em.remove(comment);
    }

    @Override
    public void deleteForum(Long forumId){
        LtForum ltForum = em.find(LtForum.class, forumId);
        em.remove(ltForum);
    }

    @Override
    public List<LtParticipant> findAll(String userId){
        List<LtParticipant> part = em.createQuery("select i from lt_participant i where i.user.userId = :userId", LtParticipant.class)
                .setParameter("userId", userId)
                .getResultList();
    return part;
    }

    @Override
    public List<LtParticipant> findPart(Long forumId, String host){
        List<LtParticipant> part = em.createQuery("select i from lt_participant i where i.forumId = :forumId and i.user.userId=:host", LtParticipant.class)
                .setParameter("forumId", forumId)
                .setParameter("host",host)
                .getResultList();
        return part;
    }

    @Override
    public void updateLtForum(Long forumId, UpdateLtForum updateLtForum){
        LtForum forum = em.createQuery("select i from lt_forum i where i.forumId=:forumId", LtForum.class)
                .setParameter("forumId", forumId)
                .getSingleResult();

        forum.setSubject(updateLtForum.getSubject());
        forum.setContent(updateLtForum.getContent());
        forum.setPostcode(updateLtForum.getPostcode());
        forum.setAddress(updateLtForum.getAddress());
        forum.setDetailAddress(updateLtForum.getDetailAddress());
        forum.setExtraAddress(updateLtForum.getExtraAddress());
        forum.setCategory(updateLtForum.getCategory());
        forum.setNum(updateLtForum.getNum());
        forum.setStartTime(updateLtForum.getStartTime());
    }

    @Override
    public void updateComment(Long commentId){
        Comment comment = em.createQuery("select i from Comment i where i.commentId=:commentId", Comment.class)
                .setParameter("commentId", commentId)
                .getSingleResult();

        comment.setPart("join");
    }

    @Override
    public void updateComments(Long forumId, String userId){
        List<Comment> resultList = em.createQuery("select i from Comment i where i.forumId=:forumId and i.host.userId=:userId", Comment.class)
                .setParameter("forumId", forumId)
                .setParameter("userId", userId)
                .getResultList();

        for (Comment comment : resultList) {
            comment.setPart("join");
        }
    }

    @Override
    public Page<LtForum> searchLtForumPage(LtForumSearchCond ltForumSearchCond, Pageable pageable){
        List<LtForum> content = query
                .select(ltForum)
                .from(ltForum)
                .where(likeSubject(ltForumSearchCond.getSubject()),likeHost(ltForumSearchCond.getHost()),
                        likeContent(ltForumSearchCond.getContent()),likeState(ltForumSearchCond.getState()),
                        likeCategory(ltForumSearchCond.getCategory()))
                .orderBy(ltForum.forumId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = query
                .select(ltForum.count())
                .from(ltForum)
                .where(likeSubject(ltForumSearchCond.getSubject()),likeHost(ltForumSearchCond.getHost()),
                        likeContent(ltForumSearchCond.getContent()),likeState(ltForumSearchCond.getState()),
                        likeCategory(ltForumSearchCond.getCategory()))
                .orderBy(ltForum.forumId.desc())
                .fetchOne();
        return new PageImpl<>(content,pageable,count);
    }

    @Override
    public List<LtForum> indexLtForum(){
        List<LtForum> indexLtForum = query.select(ltForum)
                .from(ltForum)
                .orderBy(ltForum.forumId.desc())
                .limit(12)
                .fetch();

        return indexLtForum;
    }


    private BooleanExpression likeSubject(String subject){
        if(StringUtils.hasText(subject)){
            return ltForum.subject.like("%" + subject + "%");
        }
        return null;
    }

    private BooleanExpression likeCategory(Category category){
        if(category != null){
            log.info("repository error");
            return ltForum.category.eq(category);
        }
        else{
            return null;
        }
    }
    private BooleanExpression likeHost(String host){
        if(StringUtils.hasText(host)){
            return ltForum.host.userId.like("%" + host + "%");
        }
        return null;
    }
    private BooleanExpression likeContent(String content){
        if(StringUtils.hasText(content)){
            return ltForum.content.like("%" + content + "%");
        }
        return null;
    }

    private BooleanExpression likeState(String state){
       /* if(state.equals("ing")){
            return ltForum.state.eq(state);
        }else{
            return ltForum.state.eq(state);
        }*/
        if(StringUtils.hasText(state)){
            return ltForum.state.eq(state);
        }
        else{
            return null;
        }
    }
}
