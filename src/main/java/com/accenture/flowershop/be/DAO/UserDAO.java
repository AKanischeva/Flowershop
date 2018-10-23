package com.accenture.flowershop.be.DAO;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserDAO {

    User get(String username);

    User getByUsername(String username);

    @Transactional
    User getByUsernameAndPassword(String username, String password);

    @Transactional
    User create(User user);

    void update(User user);
}
