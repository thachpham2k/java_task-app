package com.web.service;

import com.web.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    UserDTO login(String ldap, String password);
}
