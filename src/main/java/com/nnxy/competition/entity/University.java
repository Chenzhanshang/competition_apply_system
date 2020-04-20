package com.nnxy.competition.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:10
 * Email 642125256@qq.com
 */
public class University implements Serializable {
    private String universityId;

    private String universityName;

    private String universityCity;

    private List<College> colleges;

    @Override
    public String toString() {
        return "University{" +
                "universityId='" + universityId + '\'' +
                ", universityName='" + universityName + '\'' +
                ", universityCity='" + universityCity + '\'' +
                ", colleges=" + colleges +
                '}';
    }

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId == null ? null : universityId.trim();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName == null ? null : universityName.trim();
    }

    public String getUniversityCity() {
        return universityCity;
    }

    public void setUniversityCity(String universityCity) {
        this.universityCity = universityCity == null ? null : universityCity.trim();
    }
}