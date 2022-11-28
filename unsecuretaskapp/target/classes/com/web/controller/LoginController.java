package com.web.controller;

import com.web.model.UserDTO;
import com.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;

//    @GetMapping()
//    public String saveStudent() {
//        return "login";
//    }

    @PostMapping()
    public String loginPost(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            Model model
    ) {
        UserDTO user = userService.login(username, password);

        model.addAttribute("user", user);

//        System.out.println(username + "---" + password);
        try {
            System.out.println(user.getId() + "-" + user.getLdap() + "-" + user.getFirstName() + "-" + user.getLastName());
        } catch (Exception e) {
            System.out.println("not found");
        }
        return "login";
    }

}
