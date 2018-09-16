package com.trvqd.store.dao.daoImp;

import java.sql.SQLException;

import com.trvqd.store.dao.UserDao;
import com.trvqd.store.domain.User;
import com.trvqd.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;



public class UserDaoImp implements UserDao {


	@Override
	public void userRegist(User user) throws SQLException {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
        runner.update(sql,params);
	}
}
