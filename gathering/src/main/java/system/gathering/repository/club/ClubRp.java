package system.gathering.repository.club;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import system.gathering.object.User;
import system.gathering.object.club.*;

import java.util.List;
import java.util.Optional;

public interface ClubRp {

    public void out(Long clubId, User user);
    public Club save(Club club);

    public void save(ClubParticipant clubParticipant);

    public Notice save(Notice notice);

    public Album save(Album album);

    public void deleteClub(Long clubId);

    public List<Club> findAll();

    public Page<Club> findAll(Pageable pageable);

    public Page<Notice> findByClubId(Club club,Pageable pageable);

   // public Page<Album> findAlbumByClubId(Long clubId, Pageable pageable);

    public Page<Club> searchClubPage(ClubSearchCond clubSearchCond, Pageable pageable);

    public List<ClubParticipant> findAll(Long clubId);

    public List<ClubParticipant> findJoinParticipant(Long clubId);

    public List<ClubParticipant> findJoinUser(User user);

    public void updateWhether(Long clubId, String userId);

    public void updateClub(Long clubId, UpdateClub updateClub);
    public Optional<ClubParticipant> find(Long clubId,String userId);

    public Optional<Club> findById(Long clubId);

    public Optional<Notice> findByNoticeId(Long noticeId);

    public List<Club> indexClub();

    public Slice<Album> findAlbum(Club club, Pageable pageable, Long lastBoard);
}
