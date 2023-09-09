package com.agent.ttigrinminecraft.api;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraftforge.common.util.Constants;

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

    public CompoundNBT toNBT() {
        CompoundNBT compound = new CompoundNBT();
        compound.putDouble("health", this.health);
        compound.putDouble("armor", this.armor);
        compound.putDouble("magicules", this.magicules);

        // Convert skillIDs to ListNBT
        ListNBT skillList = new ListNBT();
        for (String skill : skillIDs) {
            skillList.add(StringNBT.valueOf(skill));
        }
        compound.put("skillIDs", skillList);

        return compound;
    }

    public void fromNBT(CompoundNBT compound) {
        this.health = compound.getDouble("health");
        this.armor = compound.getDouble("armor");
        this.magicules = compound.getDouble("magicules");

        // Retrieve skillIDs from ListNBT
        ListNBT skillList = compound.getList("skillIDs", Constants.NBT.TAG_STRING);
        this.skillIDs.clear();
        for (int i = 0; i < skillList.size(); i++) {
            this.skillIDs.add(skillList.getString(i));
        }
    }
}
