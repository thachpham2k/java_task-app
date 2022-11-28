package com.web.service.impl;

import com.web.entities.User;
import com.web.model.UserDTO;
import com.web.repository.IUserRepository;
import com.web.service.IUserService;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserService implements IUserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    IUserRepository userRepository;

    class UserRowMapper implements RowMapper< UserDTO > {
        @Override
        public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDTO user = new UserDTO();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setLdap(rs.getString("ldap"));
            return user;
        }
    }

    @Override
    public UserDTO login(String ldap, String password) {
        String query = "select id, first_name, last_name, ldap from user where ldap='" + ldap + "' and password='" + password + "';";
        UserDTO user = new UserDTO();
        try {
            user = jdbcTemplate.query(query, new UserRowMapper()).get(0);
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
