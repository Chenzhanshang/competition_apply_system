package com.nnxy.competition.utils;

/**
 * @author :CZS
 * @date :2019/12/20 0:33
 * Email    :642125256@qq.com
 */
public class CompetitionNotificationVO {
    private String notificationId;

    private String competitionId;

    private String competitionName;

    private String notificationTitle;

    private String competitionContent;

    private String competitionSite;

    private String competitionType;

    private Integer competitionLevel;

    private String competitionTime;

    private String collegeId;

    private Integer notificationState;

    private Integer competitionState;

    private Integer competitionPeopleSum;

    public Integer getCompetitionPeopleSum() {
        return competitionPeopleSum;
    }

    public void setCompetitionPeopleSum(Integer competitionPeopleSum) {
        this.competitionPeopleSum = competitionPeopleSum;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getCompetitionState() {
        return competitionState;
    }

    public void setCompetitionState(Integer competitionState) {
        this.competitionState = competitionState;
    }

    public Integer getNotificationState() {
        return notificationState;
    }

    public void setNotificationState(Integer notificationState) {
        this.notificationState = notificationState;
    }

    public String getCompetitionTime() {
        return competitionTime;
    }

    public void setCompetitionTime(String competitionTime) {
        this.competitionTime = competitionTime;
    }


    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getCompetitionContent() {
        return competitionContent;
    }

    public void setCompetitionContent(String competitionContent) {
        this.competitionContent = competitionContent;
    }

    public String getCompetitionSite() {
        return competitionSite;
    }

    public void setCompetitionSite(String competitionSite) {
        this.competitionSite = competitionSite;
    }

    public String getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(String competitionType) {
        this.competitionType = competitionType;
    }

    public Integer getCompetitionLevel() {
        return competitionLevel;
    }

    public void setCompetitionLevel(Integer competitionLevel) {
        this.competitionLevel = competitionLevel;
    }

    @Override
    public String toString() {
        return "CompetitionNotificationVO{" +
                "notificationId='" + notificationId + '\'' +
                ", competitionId='" + competitionId + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", notificationTitle='" + notificationTitle + '\'' +
                ", competitionContent='" + competitionContent + '\'' +
                ", competitionSite='" + competitionSite + '\'' +
                ", competitionType='" + competitionType + '\'' +
                ", competitionLevel=" + competitionLevel +
                ", competitionTime='" + competitionTime + '\'' +
                ", collegeId='" + collegeId + '\'' +
                ", notificationState=" + notificationState +
                ", competitionState=" + competitionState +
                ", competitionPeopleSum=" + competitionPeopleSum +
                '}';
    }
}
