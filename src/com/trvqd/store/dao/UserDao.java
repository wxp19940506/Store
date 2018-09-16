package com.trvqd.store.dao;

import com.trvqd.store.domain.User;

import java.sql.SQLException;


public interface UserDao {

	void userRegist(User user) throws SQLException;
}
