package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    List<User> listUsers();

    User show(Long id);

    void delete(Long id);

    void save(User user);

    User saveAndFlush(User user);

}
