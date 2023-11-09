package system.gathering.repository.club;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import system.gathering.object.LtForum;
import system.gathering.object.club.Club;
import system.gathering.object.club.ClubParticipant;

import java.util.Optional;

public interface ClubRepository2 extends JpaRepository<Club,Long> {

    @Override
    Page<Club> findAll(Pageable pageable);

    @Override
    Optional<Club> findById(Long clubId);

}
