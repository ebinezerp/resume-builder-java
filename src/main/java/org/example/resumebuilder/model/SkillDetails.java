package org.example.resumebuilder.model;

public class SkillDetails {
    private String skill;
    private String category;
    private String experience;

    public SkillDetails() {
    }

    public SkillDetails(String skill, String category, String experience) {
        this.skill = skill;
        this.category = category;
        this.experience = experience;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "SkillDetails{" + "skill='" + skill + '\'' + ", category='" + category + '\'' + ", experience='" + experience + '\'' + '}';
    }
}
