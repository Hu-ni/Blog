package kr.hs.dgsw.web_back.Repository;

import kr.hs.dgsw.web_back.Domain.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BulletinRepository extends JpaRepository<Bulletin, Long> {
    Optional<Bulletin> findByTitle(String title);
}
