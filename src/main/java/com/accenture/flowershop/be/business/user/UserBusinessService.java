package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.entity.user.User;

public interface UserBusinessService {

    User login(String username, String password);

    User register(String username, String password, String fullName, String phone, String address);

    User updateUser(User user);
}
