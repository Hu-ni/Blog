package kr.hs.dgsw.web_back.Service;

import kr.hs.dgsw.web_back.Domain.User;

public interface UserService {
    User findUser(String id);
    User addNewUser(User u);
    User updateUser(String id, User u);
    boolean deleteUser(Long id);
}
