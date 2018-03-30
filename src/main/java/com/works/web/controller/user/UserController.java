package com.works.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value="/usermessage",method = RequestMethod.POST)
    public void userMessage (){

    }

}
