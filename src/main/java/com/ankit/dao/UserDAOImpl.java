package com.ankit.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ankit.bo.UserBO;

@Repository("empDAO")
public class UserDAOImpl implements UserDAO {
	private static final String AUTH_USER_QUERY="SELECT COUNT(*) FROM LOGIN WHERE USERNAME=? AND PASSWORD=?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int validate(UserBO bo) {
		int count=0;
		count=jt.queryForObject(AUTH_USER_QUERY, Integer.class,bo.getUsername(),
															   bo.getPassword());
		return count;
	}

}
