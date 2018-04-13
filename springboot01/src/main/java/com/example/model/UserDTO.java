package com.example.model;

import java.io.Serializable;

/**
 * Created by hp on 2018/4/12.
 */
public class UserDTO implements Serializable {

    private int userId;
    private String userName;
    private int deptId;
    private String deptName;

    public UserDTO() {
    }

    public UserDTO(int userId, String userName, int deptId, String deptName) {
        this.userId = userId;
        this.userName = userName;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
