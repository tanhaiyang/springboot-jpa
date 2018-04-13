package com.example.demo;

import com.example.dao.DeptRepository;
import com.example.dao.UserRepository;
import com.example.model.Dept;
import com.example.model.User;
import com.example.model.UserAndDeptDTO;
import com.example.model.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01ApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DeptRepository deptRepository;
	@Test
	public void testAddDept() {
		int id = userRepository.saveDept("eee");
		System.out.println("id = " + id);
	}

	@Test
	public void testAddUser(){
		User u = new User();
		u.setName("user1");
		Dept d = new Dept();
		d.setName("hhh");
		deptRepository.save(d);
		u.setDept(d);
		userRepository.saveAndFlush(u);
	}

	@Test
	public void testQueryDTO(){
		List<UserDTO> us = userRepository.queryUserDTO();
		System.out.println("us = " + us.size());
		for (int i = 0; i < us.size(); i++) {
			UserDTO u = us.get(i);
			System.out.println("us[i] = " + u);
		}
	}

	@Test
	public void testUserAndDeptDTO(){
		List<UserAndDeptDTO> us = userRepository.queryUserAndDeptDTO();
		System.out.println("us = " + us.size());
		for (int i = 0; i < us.size(); i++) {
			UserAndDeptDTO u = us.get(i);
			System.out.println("us[i] = " + u.getUserName()+", "+u.getDeptName());
		}
	}

	@Test
	public void testGetOne(){
		User user = userRepository.findById(1);
		System.out.println("user = " + user);
	}

	@Test
	public void test2(){
		List<User> us = userRepository.findByName("user1");
		for (int i = 0; i < us.size(); i++) {
			User u = us.get(i);
			System.out.println("us[i] = " + u);
		}
	}


	@Test
	public void test03(){
		Dept dept = deptRepository.findById(1);
		User u1 = new User();
		u1.setName("u1");
		User u2 = new User();
		u2.setName("u2");
		User u3 = new User();
		u3.setName("u3");
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		Set<User> set = new HashSet<User>();
		set.add(u1);
		set.add(u2);
		set.add(u3);
		dept.setUsers(set);
		deptRepository.save(dept);
	}

	//could not initialize proxy - no Session
	@Test
	public void test04(){
		Dept dept = deptRepository.findById(1);
		for (User u: dept.getUsers()
				) {
			System.out.println("user: "+u);
		}
	}
}
