package service;

import dao.UserDao;
import model.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();

    public boolean addUser(String name, String email, String phone, String password) {
        return userDao.createUser(new User(name, email, phone, password));
    }

    public List<User> listUsers() {
        return userDao.getAllUsers();
    }

    public User findUser(int id) {
        return userDao.getUserById(id);
    }

    public boolean modifyUser(int id, String name, String email, String phone, String password) {
        return userDao.updateUser(new User(id, name, email, phone, password));
    }

    public boolean removeUser(int id) {
        return userDao.deleteUser(id);
    }
}
