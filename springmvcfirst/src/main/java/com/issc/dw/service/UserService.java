package com.issc.dw.service;

import com.issc.dw.dao.Userdao;
import com.issc.dw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private Userdao userDao;
    public String Login(String name){
        User user=userDao.findByName(name);
        if(user!=null)
            return user.getName()+user.getId();
        else
            return "test";
    }
    public List<User> findAllUser(){
        return userDao.findAll();
    }
    public Page<User> findPageUser(int page,int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=new PageRequest(page,pageSize,sort);
        return userDao.findAll(pageable);
    }
}
