package kr.hs.dgsw.web_back.Controller;

import kr.hs.dgsw.web_back.Domain.User;
import kr.hs.dgsw.web_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService us;

    @GetMapping("/user/find/{id}")
    public User findUser(@PathVariable String id){
        return us.findUser(id);
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User u) {
        return us.addNewUser(u);
    }

    @PutMapping("user/update/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User u) {
        return us.updateUser(id, u);
    }

    @DeleteMapping("/user/delete/{seq}")
    public boolean deleteUser(@PathVariable Long seq) {
        return us.deleteUser(seq);
    }
}
