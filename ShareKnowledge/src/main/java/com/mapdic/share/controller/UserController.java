package com.mapdic.share.controller;

import com.google.common.base.Preconditions;
import com.mapdic.share.common.DoCookie;
import com.mapdic.share.model.User;
import com.mapdic.share.serviceimpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by liuyong on 2016/3/10.
 */
@Controller
public class UserController {
    @Resource
    private UserServiceImpl userServiceImpl;
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public ModelAndView getAllUser(HttpServletRequest request, PrintWriter out, HttpServletResponse response){
        List<User> users = userServiceImpl.getAllUser();
        System.out.println(request.getParameter("username"));
        String s = request.getParameter("username");
        ModelAndView modelAndView = new ModelAndView("getAllUser");
        modelAndView.addObject("username",s);
        DoCookie.addCookie(response, users.get(0));
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public User userLogin(User user, HttpServletResponse response){
        Preconditions.checkArgument(user != null, "用户为空");
        User usr = userServiceImpl.login(user);
        if (user != null){
            DoCookie.addCookie(response, usr);
            return usr;
        }
        return null;
    }
}
