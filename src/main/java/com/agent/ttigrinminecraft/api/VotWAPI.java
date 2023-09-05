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

    // ... [Previous methods for health, armor, and magicules] ...

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
