package com.example.dao;

import com.example.model.Dept;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hp on 2018/4/12.
 */
public interface DeptRepository extends CrudRepository<Dept, Integer> {

    public Dept findById(int id);
}
