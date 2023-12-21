package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
        return userDao.findAll();
    }

    @Override
    public User show(Long id) {

        return userDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

        userDao.deleteById(id);
    }

    @Override
    public void save(User user) {

        userDao.save(user);
    }

    @Override
    public User saveAndFlush(User user) {
        return userDao.saveAndFlush(user);
    }

}
