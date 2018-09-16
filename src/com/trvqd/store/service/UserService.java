package com.trvqd.store.service;

import com.trvqd.store.domain.User;

import java.sql.SQLException;


public interface UserService {

	void userRegister(User user) throws SQLException;
}
