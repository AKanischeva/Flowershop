package com.accenture.flowershop.be.DAO;

import com.accenture.flowershop.be.entity.user.User;

public interface UserDAO {

    User getUserByID(String id);

    User getUserByName(String name);

    User getUserByPhone(String phone);

    boolean addUser(User user);

    boolean removeUser(User user);
}
