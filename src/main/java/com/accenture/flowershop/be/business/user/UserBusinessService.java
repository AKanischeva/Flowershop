package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.entity.user.User;

public interface UserBusinessService {

    User login(String username, String password);

    User register(String username, String email, String password, String fullName, String address);

    User updateUser(User user);
}
