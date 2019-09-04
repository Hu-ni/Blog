package kr.hs.dgsw.web_back.Service;

import kr.hs.dgsw.web_back.Domain.Bulletin;
import kr.hs.dgsw.web_back.Domain.User;
import kr.hs.dgsw.web_back.Repository.BulletinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BulletinServiceImpl implements BulletinService {
    @Autowired
    private BulletinRepository br;

    @Override
    public List<Bulletin> getList() {
        return br.findAll();
    }

    @Override
    public Bulletin findByTitle(String title) {
        return br.findByTitle(title).orElse(null);
    }

    @Override
    public Bulletin addNewBulletin(Bulletin b) {
        if(br.findByTitle(b.getTitle()).isPresent())    return null;
        else return br.save(b);
    }

    @Override
    public Bulletin update(Long seq, Bulletin b) {
        return br.findById(seq)
                .map(bulletin -> {
                    bulletin.setTitle(Optional.ofNullable(b.getTitle()).orElse(bulletin.getTitle()));
                    bulletin.setContent(Optional.ofNullable(b.getContent()).orElse(bulletin.getContent()));
                    bulletin.setRcnum(Optional.ofNullable(b.getRcnum()).orElse(bulletin.getRcnum()));
                    bulletin.setViews(Optional.ofNullable(b.getViews()).orElse(bulletin.getViews()));

                    return br.save(bulletin);
                }).orElse(null);
    }

    @Override
    public boolean delete(Long seq) {
        try{
            br.deleteById(seq);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
