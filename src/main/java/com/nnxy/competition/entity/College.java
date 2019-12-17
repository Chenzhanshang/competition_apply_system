package com.nnxy.competition.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:10
 * Email 642125256@qq.com
 */
public class College implements Serializable {
    private String collegeId;

    private University university;

    private String collegeName;

    private List<User> users;


    @Override
    public String toString() {
        return "College{" +
                "collegeId='" + collegeId + '\'' +
                ", university=" + university +
                ", collegeName='" + collegeName + '\'' +
                ", users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId == null ? null : collegeId.trim();
    }


    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }
}