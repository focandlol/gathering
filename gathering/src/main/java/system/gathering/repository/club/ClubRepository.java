package system.gathering.repository.club;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import system.gathering.object.Chatting;
import system.gathering.object.LtForum;
import system.gathering.object.LtForumSearchCond;
import system.gathering.object.User;
import system.gathering.object.club.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static system.gathering.object.QChatting.chatting;
import static system.gathering.object.QLtForum.ltForum;
import static system.gathering.object.club.QAlbum.*;
import static system.gathering.object.club.QClub.*;
import static system.gathering.object.club.QClub.club;
import static system.gathering.object.club.QNotice.*;

@Repository
@Transactional
public class ClubRepository implements ClubRp{

    private final EntityManager em;
    private final ClubRepository2 clubRepository2;
    //private final NoticeRepository noticeRepository;
    //private final AlbumRepository albumRepository;
    private final JPAQueryFactory query;

     public ClubRepository(EntityManager em, ClubRepository2 clubRepository2) {
        this.em = em;
        this.clubRepository2 = clubRepository2;
        //this.noticeRepository = noticeRepository;
        //this.albumRepository = albumRepository;
        this.query = new JPAQueryFactory(em);
    }

    public void out(Long clubId, User user){
        em.createQuery("delete from ClubParticipant a where a.clubId = :clubId and a.user =:user")
                .setParameter("clubId", clubId)
                .setParameter("user",user)
                .executeUpdate();
        em.clear();
    }
    @Override
    public Club save(Club club) {
        em.persist(club);
        return club;
    }

    @Override
    public void save(ClubParticipant clubParticipant){
        em.persist(clubParticipant);
        //return clubParticipant;
    }

    @Override
    public Notice save(Notice notice){
        em.persist(notice);
        return notice;
    }

    @Override
    public Album save(Album album){
        em.persist(album);
        return album;
    }

    @Override
    public void deleteClub(Long clubId){
        Club club = em.find(Club.class, clubId);
        em.remove(club);
    }

    @Override
    public List<Club> findAll() {
        String jpql = "select i from Club i";
        TypedQuery<Club> query = em.createQuery(jpql, Club.class);
        return query.getResultList();
    }

    @Override
    public List<ClubParticipant> findAll(Long clubId){
       return em.createQuery("select i from ClubParticipant i where i.clubId= :clubId", ClubParticipant.class)
               .setParameter("clubId",clubId)
               .getResultList();

    }

    @Override
    public List<ClubParticipant> findJoinParticipant(Long clubId){
        return em.createQuery("select i from ClubParticipant i where i.clubId= :clubId and whether='join'", ClubParticipant.class)
                .setParameter("clubId",clubId)
                .getResultList();
    }

    @Override
    public List<ClubParticipant> findJoinUser(User user){
        return em.createQuery("select i from ClubParticipant i where i.user.userId= :userId and whether='join'", ClubParticipant.class)
                .setParameter("userId",user.getUserId())
                .getResultList();
    }
    @Override
    public Optional<ClubParticipant> find(Long clubId,String userId){
        Optional<ClubParticipant> first = em.createQuery("select i from ClubParticipant i where i.clubId= :clubId and i.user.userId= :userId",
                        ClubParticipant.class)
                .setParameter("clubId", clubId)
                .setParameter("userId", userId)
                .getResultList()
                .stream().findFirst();
        return first;
    }
    @Override
    public void updateWhether(Long clubId, String userId){
        ClubParticipant singleResult = em.createQuery("select i from ClubParticipant i where i.clubId= :clubId and i.user.userId= :userId",
                        ClubParticipant.class)
                .setParameter("clubId", clubId)
                .setParameter("userId", userId)
                .getSingleResult();

        singleResult.setWhether("join");

    }

    @Override
    public void updateClub(Long clubId, UpdateClub updateClub){
        Club club = em.createQuery("select i from Club i where i.clubId= :clubId", Club.class)
                .setParameter("clubId", clubId)
                .getSingleResult();

        club.setClubName(updateClub.getClubName());
        club.setIntro(updateClub.getIntro());
        club.setUploadFile(updateClub.getUploadFile());
        club.setStoreFile(updateClub.getStoreFile());

    }

    @Override
    public Page<Club> findAll(Pageable pageable){
        return clubRepository2.findAll(pageable);
    }

    @Override
    public Page<Notice> findByClubId(Club club,Pageable pageable){
       //return noticeRepository.findByClubId(clubId, pageable);
        List<Notice> fetch = query
                .select(notice)
                .from(notice)
                .where(notice.club.eq(club))
                .orderBy(notice.noticeId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = query
                .select(notice.count())
                .from(notice)
                .where(notice.club.eq(club))
                .orderBy(notice.noticeId.desc())
                .fetchOne();

        return new PageImpl<>(fetch,pageable,count);
    }

    /*@Override
    public Page<Album> findAlbumByClubId(Long clubId, Pageable pageable){
        return albumRepository.findAlbumByClubId(clubId, pageable);
    }*/


    @Override
    public Page<Club> searchClubPage(ClubSearchCond clubSearchCond, Pageable pageable) {
        List<Club> content = query
                .select(club)
                .from(club)
                .where(likeClubName(clubSearchCond.getClubName()),likeHost(clubSearchCond.getHost()))
                .orderBy(club.clubId.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = query
                .select(club.count())
                .from(club)
                .where(likeClubName(clubSearchCond.getClubName()),likeHost(clubSearchCond.getHost()))
                .orderBy(club.clubId.desc())
                .fetchOne();

        return new PageImpl<>(content,pageable,count);
    }

    @Override
    public Slice<Album> findAlbum(Club club, Pageable pageable, Long lastBoard){
        List<Album> result = query.select(album)
                .from(album)
                .where(eqClubId(club))
                .where(ltBoardId(lastBoard))
                .orderBy(album.albumId.desc())
                .limit(pageable.getPageSize())
                .fetch();

        Slice<Album> albums = checkLastPage(pageable, result);
        return albums;
    }

    @Override
    public  List<Club> indexClub(){
        List<Club> indexClub = query.select(club)
                .from(club)
                .orderBy(club.clubId.desc())
                .limit(12)
                .fetch();

        return indexClub;
    }


    @Override
    public Optional<Club> findById(Long clubId){
        return clubRepository2.findById(clubId);
    }

    @Override
    public Optional<Notice> findByNoticeId(Long noticeId) {
        return Optional.ofNullable(em.find(Notice.class, noticeId));
    }

    private BooleanExpression likeClubName(String clubName){
         if(StringUtils.hasText(clubName)){
             return club.clubName.like("%" + clubName + "%");
         }
         return null;
    }

    private Slice<Album> checkLastPage(Pageable pageable, List<Album> album){
         boolean hasNext = false;
         if(album.size() > pageable.getPageSize()){
             hasNext = true;
             album.remove(pageable.getPageSize());
         }
         return new SliceImpl<>(album,pageable,hasNext);
    }

    private BooleanExpression ltBoardId(Long boardId){
         return boardId != null ? album.albumId.lt(boardId) : null;
    }

    private BooleanExpression eqClubId(Club club){
         return album.club.eq(club);
    }

    private BooleanExpression likeHost(String host){
         if(StringUtils.hasText(host)){
             return club.host.userId.like("%" + host + "%");
         }
         return null;
    }
}
