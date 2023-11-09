package system.gathering.repository.forum;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import system.gathering.object.LtForum;

import java.util.List;

public interface ForumRepository2 extends JpaRepository<LtForum,Long> {


    //Page<LtForum> findAll(Pageable pageable);

    @Override
    Page<LtForum> findAll(Pageable pageable);
}
