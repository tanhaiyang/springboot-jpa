package com.example.dao;

import com.example.model.Dept;
import com.example.model.User;
import com.example.model.UserAndDeptDTO;
import com.example.model.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hp on 2018/4/3.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "INSERT into t_user(id,name) values(?1,?2)", nativeQuery = true)
    @Modifying
    public void add(int id,String name);
    @Query(value = "SELECT * from t_user where id=?1", nativeQuery = true)
    public User findId(int id);

    @Query(value="SELECT id,name from t_user", nativeQuery = true)
    public List<Object[]> findSome(int id);
    @Query(value="SELECT new com.example.model.User(id,name) from User where id=?1")
    public User findSomeBean(int id);

    public Page<User> findAll(Pageable pageable);

    @Query(value = "insert into t_dept(name) values(:name)", nativeQuery = true)
    @Modifying
    @Transactional  //别忘了事务(本来应该在service中配置事务的)
    public int saveDept(@Param("name") String name); //别忘了@Param("name")注解

    //通过DTO接收自定义查询的字段
    @Query(value = "select new com.example.model.UserDTO(u.id,u.name,d.id,d.name) from User u join Dept d on u.dept=d.id")
    public List<UserDTO> queryUserDTO();

    //通过自定义接口来接收查询字段
    @Query(value = "select u.id as userId,u.name as userName,d.id as deptId,d.name as deptName from User u join Dept d on u.dept=d.id")
    public List<UserAndDeptDTO> queryUserAndDeptDTO();

    public User findById(int id);

    public List<User> findByName(String name);
}


