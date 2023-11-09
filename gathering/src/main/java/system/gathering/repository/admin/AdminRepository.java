package system.gathering.repository.admin;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import system.gathering.object.*;
import system.gathering.object.club.Club;
import system.gathering.object.club.ClubSearchCond;

import java.util.List;

import static system.gathering.object.QFeedback.*;
import static system.gathering.object.QLtForum.ltForum;
import static system.gathering.object.QUser.*;
import static system.gathering.object.club.QClub.club;

@Slf4j
@Repository
@Transactional
public class AdminRepository implements AdminRp{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public AdminRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public Page<User> searchUser(UserSearchCond userSearchCond, Pageable pageable) {
        List<User> users = query
                .select(user)
                .from(user)
                .where(likeName(userSearchCond))
                .orderBy(user.userId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = query
                .select(user.count())
                .from(user)
                .where(likeName(userSearchCond))
                .orderBy(user.userId.desc())
                .fetchOne();

        return new PageImpl<>(users,pageable,count);
    }

    @Override
    public Page<Feedback> searchFeedback(FeedSearchCond feedSearchCond, Pageable pageable){
        List<Feedback> feedbacks = query
                .select(feedback)
                .from(feedback)
                .where(likeState(feedSearchCond))
                .orderBy(feedback.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = query
                .select(feedback.count())
                .from(feedback)
                .where(likeState(feedSearchCond))
                .orderBy(feedback.id.desc())
                .fetchOne();

        return new PageImpl<>(feedbacks,pageable,count);
    }

    @Override
    public void userOut(String userId){
        User findUser = em.find(User.class, userId);
        em.remove(findUser);
    }

    @Override
    public void checkFeedback(Long id){
        Feedback findFeedback = em.find(Feedback.class, id);
        findFeedback.setChecking(Checking.CHECKED);
    }

    @Override
    public void downGrade(String defendant){
        User findUser = em.find(User.class, defendant);
        log.info("repository finduser = {}",findUser);
        /*Integer intGrade = Integer.valueOf(findUser.getGrade());
        log.info("intGrade = {}",intGrade);
        intGrade -= 1;
        String s = String.valueOf(intGrade);*/
        Long grade = findUser.getGrade();
        grade -= 1;
        findUser.setGrade(grade);
        log.info("finduser com");
    }

    private BooleanExpression likeName(UserSearchCond userSearchCond){
        String name = userSearchCond.getUserId();
        if(StringUtils.hasText(name)){
            return user.userId.like("%" + name + "%");
        }
        return null;

    }

    private BooleanExpression likeState(FeedSearchCond feedSearchCond){
        Checking checking = feedSearchCond.getChecking();
        log.info("checking={}",checking);

        if(checking == null){
            return null;
        }
        else{
            return feedback.checking.eq(checking);
        }
    }
}
