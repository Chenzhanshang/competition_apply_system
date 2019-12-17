package com.nnxy.competition.entity;

import java.util.List;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:10
 * Email 642125256@qq.com
 */
public class Team {
    private String teamId;

    private User captain;

    private String teamName;

    private Integer teamState;

    private Integer teamHeadcount;

    private List<User> users;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public User getCaptain() {
        return captain;
    }

    public void setCaptain(User captain) {
        this.captain = captain;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
    }

    public Integer getTeamState() {
        return teamState;
    }

    public void setTeamState(Integer teamState) {
        this.teamState = teamState;
    }

    public Integer getTeamHeadcount() {
        return teamHeadcount;
    }

    public void setTeamHeadcount(Integer teamHeadcount) {
        this.teamHeadcount = teamHeadcount;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", captain=" + captain +
                ", teamName='" + teamName + '\'' +
                ", teamState=" + teamState +
                ", teamHeadcount=" + teamHeadcount +
                ", users=" + users +
                '}';
    }
}