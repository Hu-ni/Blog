package kr.hs.dgsw.web_back.Controller;

import kr.hs.dgsw.web_back.Domain.Bulletin;
import kr.hs.dgsw.web_back.Service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BulletinController {
    @Autowired
    BulletinService bs;

    @GetMapping("/bulletin/list")
    public List<Bulletin> getList(){
        return bs.getList();
    }

    @GetMapping("/bulletin/find/{title}")
    public Bulletin findByTitle(@PathVariable String title){
        return bs.findByTitle(title);
    }

    @PostMapping("/bulletin/add")
    public Bulletin addNewBulletin(@RequestBody Bulletin b){
        return bs.addNewBulletin(b);
    }

    @PutMapping("/bulletin/update/{seq}")
    public Bulletin update(@PathVariable Long seq, @RequestBody Bulletin b){
        return bs.update(seq, b);
    }

    @DeleteMapping("/bulletin/delete/{seq}")
    public boolean delete(@PathVariable Long seq){
        return bs.delete(seq);
    }
}
