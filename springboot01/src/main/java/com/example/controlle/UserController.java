package com.example.controlle;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by hp on 2018/4/3.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="index")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/list")
    public String all(Model model){
        model.addAttribute("users",userService.findAll());
        return "list";
    }
}