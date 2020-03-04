package com.nnxy.competition.entity;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:10
 * Email 642125256@qq.com
 */
public class Advice {
    private String adviceId;

    private User user;

    private String adviceType;

    private Integer adviceState;

    private String adviceContent;

    private Long adviceDate;

    private Long disposeTime;

    public String getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(String adviceId) {
        this.adviceId = adviceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(String adviceType) {
        this.adviceType = adviceType;
    }

    public Integer getAdviceState() {
        return adviceState;
    }

    public void setAdviceState(Integer adviceState) {
        this.adviceState = adviceState;
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent;
    }

    public Long getAdviceDate() {
        return adviceDate;
    }

    public void setAdviceDate(Long adviceDate) {
        this.adviceDate = adviceDate;
    }

    public Long getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(Long disposeTime) {
        this.disposeTime = disposeTime;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "adviceId='" + adviceId + '\'' +
                ", user=" + user +
                ", adviceType='" + adviceType + '\'' +
                ", adviceState=" + adviceState +
                ", adviceContent='" + adviceContent + '\'' +
                ", adviceDate=" + adviceDate +
                ", disposeTime=" + disposeTime +
                '}';
    }
}