package com.example.controlle;

import com.example.dao.DeptRepository;
import com.example.model.Dept;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by hp on 2018/4/2.
 */
@RestController
// 如果要返回jsp页面，就要用Controller标签
//@Controller
public class DemoController {

    @Autowired
    private UserService userService;
    @Autowired
    private DeptRepository deptRepository;

    @GetMapping(value = "/hello")
    public ArrayList<String> hello(){
        ArrayList<String> list = new ArrayList<>();
        list.add("sdf");
        list.add("were");
        list.add("ddd");
        System.out.println("hello");
        return list;
    }


    @GetMapping(value="/{id}")
    public User id(@PathVariable int id) {
        return this.userService.findId(id);
    }
    @GetMapping(value="/add/{id}/{name}")
    public void add(@PathVariable int id,@PathVariable String name) {
        this.userService.save(id, name);
    }
    @GetMapping(value="/some/{id}")
    public List<Object[]> some(@PathVariable int id) {
        return this.userService.some(id);
    }
    @GetMapping(value="/someb/{id}")
    public User someb(@PathVariable int id) {
        return this.userService.someBean(id);
    }
    @GetMapping(value="/page/{pageNo}/{size}")
    public Page<User> page(@PathVariable int pageNo,@PathVariable int size){
        return userService.allPageable(pageNo, size);
    }

    @GetMapping(path = "/dept/{id}")
    public Set<User> dept(@PathVariable int id){
        Dept d = deptRepository.findById(id);
        return d.getUsers();
    }
}