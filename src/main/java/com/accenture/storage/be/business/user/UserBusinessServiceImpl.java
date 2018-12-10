package com.accenture.storage.be.business.user;

import com.accenture.storage.be.DAO.UserDAO;
import com.accenture.storage.be.entity.user.User;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBusinessServiceImpl implements UserBusinessService {
    @Autowired
    UserDAO dao;

    @Override
    public User login(String username, String password) {
        return dao.getByUsernameAndPassword(username, password);
    }

    @Override
    public User register(@NotEmpty String username, @NotEmpty String password, String fullName) {
        try {
            if (dao.getByUsername(username) == null) {
                User u = new User(username, password, fullName);
                dao.create(u);
                return u;
            }
            //TODO normal catch
        } catch (Exception ex) {
            System.out.println("ERROR");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getInfo(String username) {
        return dao.getByUsername(username);
    }
}
