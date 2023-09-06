package com.agent.ttigrinminecraft.api;

import java.util.ArrayList;
import java.util.List;

public class VotWAPI {

    // Resources
    private double health;
    private double armor;
    private double magicules;

    // Skill IDs for the entity
    private List<String> skillIDs;

    // Constructor
    public VotWAPI(double health, double armor, double magicules) {
        this.health = health;
        this.armor = armor;
        this.magicules = magicules;
        this.skillIDs = new ArrayList<>();
    }

    // Setters for resources
    public void setHealth(double health) {
        this.health = health;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public void setMagicules(double magicules) {
        this.magicules = magicules;
    }

    // Getters for resources (in case you need them later)
    public double getHealth() {
        return health;
    }

    public double getArmor() {
        return armor;
    }

    public double getMagicules() {
        return magicules;
    }

    // Skill management methods
    public List<String> getSkillIDs() {
        return skillIDs;
    }

    public void addSkill(String skillID) {
        if (!skillIDs.contains(skillID)) {
            skillIDs.add(skillID);
        }
    }

    public void removeSkill(String skillID) {
        skillIDs.remove(skillID);
    }

    public boolean hasSkill(String skillID) {
        return skillIDs.contains(skillID);
    }
}
