package com.nnxy.competition.entity;

/**
 * @author CZS
 * CreateTime 2019/12/13 11:10
 * Email 642125256@qq.com
 */
public class Advise {
    private String adviseId;

    private String userId;

    private String adviseType;

    private Integer adviseState;

    private String adviseContent;

    private Long adviseDate;

    public String getAdviseId() {
        return adviseId;
    }

    public void setAdviseId(String adviseId) {
        this.adviseId = adviseId == null ? null : adviseId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAdviseType() {
        return adviseType;
    }

    public void setAdviseType(String adviseType) {
        this.adviseType = adviseType == null ? null : adviseType.trim();
    }

    public Integer getAdviseState() {
        return adviseState;
    }

    public void setAdviseState(Integer adviseState) {
        this.adviseState = adviseState;
    }

    public String getAdviseContent() {
        return adviseContent;
    }

    public void setAdviseContent(String adviseContent) {
        this.adviseContent = adviseContent == null ? null : adviseContent.trim();
    }

    public Long getAdviseDate() {
        return adviseDate;
    }

    public void setAdviseDate(Long adviseDate) {
        this.adviseDate = adviseDate;
    }

    @Override
    public String toString() {
        return "Advise{" +
                "adviseId='" + adviseId + '\'' +
                ", userId='" + userId + '\'' +
                ", adviseType='" + adviseType + '\'' +
                ", adviseState=" + adviseState +
                ", adviseContent='" + adviseContent + '\'' +
                ", adviseDate=" + adviseDate +
                '}';
    }
}