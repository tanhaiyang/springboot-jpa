package com.example.service;

import com.example.dao.DeptRepository;
import com.example.model.Dept;
import com.example.model.User;
import com.example.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hp on 2018/4/3.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeptRepository deptRepository;

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findId(int id) {
        return this.userRepository.findId(id);
    }

    public void save(int id ,String name) {
        this.userRepository.add(id, name);
    }

    public List<Object[]> some(int id){
        return userRepository.findSome(id);
    }

    public User someBean(int id){
        return userRepository.findSomeBean(id);
    }

    public Page<User> allPageable(int pageNo,int size){
        //注意：spring data jpa的分页直接传pageNo和pageSize，不用做其他处理。pageNo是从零开始的
        Pageable pageable = PageRequest.of((pageNo-1), size);
        System.out.println("pageNo = " + pageNo+"size: "+size);
        return userRepository.findAll(pageable);
    }


    public Dept findById(int id){
        return deptRepository.findById(id);
    }
}