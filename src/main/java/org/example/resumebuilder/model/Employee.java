package org.example.resumebuilder.model;

import java.util.List;

public class Employee {
    private String empId;
    private String firstName;
    private String lastName;
    private String callMe;
    private String experience;
    private String gender;
    private String fjLvl;
    private String primarySkill;
    private String certification;
    private String profilePhotoUrl;
    private String hobby;
    private List<SkillDetails> skillMatrix;

    public Employee() {
    }

    public Employee(String empId, String firstName, String lastName, String callMe, String experience, String gender, String fjLvl, String primarySkill, String certification, String profilePhotoUrl, String hobby) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.callMe = callMe;
        this.experience = experience;
        this.gender = gender;
        this.fjLvl = fjLvl;
        this.primarySkill = primarySkill;
        this.certification = certification;
        this.profilePhotoUrl = profilePhotoUrl;
        this.hobby = hobby;
    }

    public Employee(String empId, String firstName, String lastName, String callMe, String experience, String gender, String fjLvl, String primarySkill, String certification, String profilePhotoUrl, String hobby, List<SkillDetails> skillMatrix) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.callMe = callMe;
        this.experience = experience;
        this.gender = gender;
        this.fjLvl = fjLvl;
        this.primarySkill = primarySkill;
        this.certification = certification;
        this.profilePhotoUrl = profilePhotoUrl;
        this.hobby = hobby;
        this.skillMatrix = skillMatrix;
    }


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCallMe() {
        return callMe;
    }

    public void setCallMe(String callMe) {
        this.callMe = callMe;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFjLvl() {
        return fjLvl;
    }

    public void setFjLvl(String fjLvl) {
        this.fjLvl = fjLvl;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public List<SkillDetails> getSkillMatrix() {
        return skillMatrix;
    }

    public void setSkillMatrix(List<SkillDetails> skillMatrix) {
        this.skillMatrix = skillMatrix;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId='" + empId + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", callMe='" + callMe + '\'' + ", experience='" + experience + '\'' + ", gender='" + gender + '\'' + ", fjLvl='" + fjLvl + '\'' + ", primarySkill='" + primarySkill + '\'' + ", certification='" + certification + '\'' + ", profilePhotoUrl='" + profilePhotoUrl + '\'' + ", hobby='" + hobby + '\'' + ", skillMatrix=" + skillMatrix + '}';
    }
}
