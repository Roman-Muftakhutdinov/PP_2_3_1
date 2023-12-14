package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    User show(long id);
    void delete(long id);
    void save(User user);
    void update(long id, User user);
}
