package com.nnxy.competition.entity;

/**
 * 队伍申请
 *
 * @author :CZS
 * @date :2019/12/31 10:25
 * Email    :642125256@qq.com
 */
public class Apply {
    private String applyId;

    private Long applyTime;

    private String applyContent;

    private Long applyDisposeTime;

    private Integer applyState;

    private User user;

    private Team team;


    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public Long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyContent() {
        return applyContent;
    }

    public void setApplyContent(String applyContent) {
        this.applyContent = applyContent;
    }

    public Long getApplyDisposeTime() {
        return applyDisposeTime;
    }

    public void setApplyDisposeTime(Long applyDisposeTime) {
        this.applyDisposeTime = applyDisposeTime;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyId='" + applyId + '\'' +
                ", applyTime=" + applyTime +
                ", applyContent='" + applyContent + '\'' +
                ", applyDisposeTime=" + applyDisposeTime +
                ", applyState=" + applyState +
                ", user=" + user +
                ", team=" + team +
                '}';
    }
}
