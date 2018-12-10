package com.accenture.storage.be.business.user;

import com.accenture.storage.be.entity.user.User;

public interface UserBusinessService {

    User login(String username, String password);

    User register(String username, String password, String fullName);

    User updateUser(User user);

    User getInfo(String username);
}
