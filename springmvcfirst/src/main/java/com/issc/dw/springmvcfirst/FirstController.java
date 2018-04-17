package com.issc.dw.springmvcfirst;

import com.issc.dw.dao.Userdao;
import com.issc.dw.model.User;
import com.issc.dw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class FirstController {
    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(String name){
        String st=userService.Login(name);
        return st;
    }

    @RequestMapping("/page")
    public ModelAndView page(int page){
        Page<User> list;
        list=userService.findPageUser(page,4);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("page");
        return modelAndView;
    }

    @RequestMapping("/say")
    @ResponseBody
    public String user(String name){
        return "Hello"+name;
    }
    @RequestMapping("/says")
    @ResponseBody
    public String user(@Validated User password, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "test";
    }
}
