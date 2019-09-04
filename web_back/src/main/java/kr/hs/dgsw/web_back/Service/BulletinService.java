package kr.hs.dgsw.web_back.Service;

import kr.hs.dgsw.web_back.Domain.Bulletin;

import java.util.List;

public interface BulletinService {
    List<Bulletin> getList();
    Bulletin findByTitle(String title);
    Bulletin addNewBulletin(Bulletin b);
    Bulletin update(Long seq, Bulletin b);
    boolean delete(Long seq);
}
