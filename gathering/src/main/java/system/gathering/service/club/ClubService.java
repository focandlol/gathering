package system.gathering.service.club;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import system.gathering.object.Chatting;
import system.gathering.object.User;
import system.gathering.object.club.*;
import system.gathering.repository.club.ClubRepository2;
import system.gathering.repository.club.ClubRp;
import system.gathering.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRp clubRp;
    private final UserRepository userRepository;

    public Club save(Club club){
        return clubRp.save(club);
    }

    public void out(Long clubId, User user){
        clubRp.out(clubId, user);
    };

    public void save(ClubParticipant clubParticipant){
        clubRp.save(clubParticipant);
    }

    public Notice save(Notice notice){
         return clubRp.save(notice);
    }

    public Album save(Album album){
        return clubRp.save(album);
    }

    public void deleteClub(Long clubId){
        clubRp.deleteClub(clubId);
    }

    public List<Club> findAll(){
        return clubRp.findAll();
    }

    public List<ClubParticipant> findAll(Long clubId){
        return clubRp.findAll(clubId);
    }

    public List<ClubParticipant> findJoinParticipant(Long clubId){
        return clubRp.findJoinParticipant(clubId);
    }

    public List<ClubParticipant> findJoinUser(User user){
        return clubRp.findJoinUser(user);
    }

    public Page<Club> findAll(Pageable pageable){
        return clubRp.findAll(pageable);
    }

    public void updateWhether(Long clubId, String userId){
       clubRp.updateWhether(clubId, userId);
    }

    public void updateClub(Long clubId, UpdateClub updateClub){
        clubRp.updateClub(clubId, updateClub);
    }

    public Optional<ClubParticipant> find(Long clubId,String userId){
        return clubRp.find(clubId, userId);
    }

    public Optional<Club> findById(Long clubId){
        return clubRp.findById(clubId);
    }

    public Page<Notice> findByClubId(Club club,Pageable pageable){
        return clubRp.findByClubId(club, pageable);
    }

    /*public Page<Album> findAlbumByClubId(Long clubId, Pageable pageable){
        return clubRp.findAlbumByClubId(clubId, pageable);
    }*/
    public Page<Club> searchClubPage(ClubSearchCond clubSearchCond, Pageable pageable){
        return clubRp.searchClubPage(clubSearchCond, pageable);
    }
    public Optional<Notice> findByNoticeId(Long noticeId){
        return clubRp.findByNoticeId(noticeId);
    }

    public void create(String a){
        String tableName = "club" + a;
        userRepository.create(tableName);
    }

    public List<Chatting> findChat(String a){
        return userRepository.findChat(a);
    }

    public Slice<Album> findAlbum(Club club, Pageable pageable, Long lastBoard){
        return clubRp.findAlbum(club,pageable,lastBoard);
    }
}
