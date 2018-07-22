package com.solopov.hillel.uquiz.service;

import com.solopov.hillel.uquiz.dao.UserDAO;
import com.solopov.hillel.uquiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;


    public boolean addAccount(User user) {
        if (!isRegistered(user)) {
            userDAO.save(user);
            return true;
        }
        return false;
    }

    public boolean isRegistered(String login, String pass) {
        User currentUser = userDAO.findUserByLoginLike(login);
        if (currentUser != null && pass.equals(currentUser.getPassword())) return true;
        return false;
    }

    public boolean isRegistered(User user) {
        User currentUser = userDAO.findUserByLoginLike(user.getLogin());
        if (currentUser != null && user.getPassword().equals(currentUser.getPassword())) return true;
        return false;
    }

    public User getByLogin(String login) {
        return userDAO.findUserByLoginLike(login);
    }

    public User getByID(int id) {
        return userDAO.findById(id).get();
    }

    public List<User> getAllUsers() {
        return (List<User>) userDAO.findAll();
    }

    public boolean update(User user) {
        if (!isRegistered(user)) return false;
        userDAO.save(user);
        return true;
    }
}
