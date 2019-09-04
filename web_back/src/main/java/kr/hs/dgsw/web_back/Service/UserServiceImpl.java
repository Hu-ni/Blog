package kr.hs.dgsw.web_back.Service;

import kr.hs.dgsw.web_back.Domain.User;
import kr.hs.dgsw.web_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository ur;

    @Override
    public User findUser(String id) {
        return ur.findById(id).orElse(null);
    }

    @Override
    public User addNewUser(User u) {
        if (ur.findById(u.getId()).isPresent()) return null;
        else return ur.save(u);
    }

    @Override
    public User updateUser(String id, User u) {
        return ur.findById(u.getId())
                .map(user -> {
                    user.setId(Optional.ofNullable(u.getId()).orElse(user.getId()));
                    user.setPassword(Optional.ofNullable(u.getPassword()).orElse(user.getPassword()));
                    user.setName(Optional.ofNullable(u.getName()).orElse(user.getName()));
                    user.setGender(Optional.ofNullable(u.getGender()).orElse(user.getGender()));
                    user.setAge(Optional.ofNullable(u.getAge()).orElse(user.getAge()));
                    user.setProfile(Optional.ofNullable(u.getProfile()).orElse(user.getProfile()));

                    return ur.save(user);
                }).orElse(null);
    }

    @Override
    public boolean deleteUser(Long id) {
        try{
            ur.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
