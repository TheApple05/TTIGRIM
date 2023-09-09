package com.agent.ttigrinminecraft.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity; // Added this import
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT; // Added this import
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VotWHandler {

    private static final int MAX_STRING_LENGTH = 65535; // 16-bit length

    public static void initializeResourcesForEntity(Entity entity) {
        VotWAPI api;
        if (entity instanceof PlayerEntity) {
            api = new VotWAPI(100, 50, 200);
            api.addSkill(validateSkillID("SKILL_ID_1"));
            api.addSkill(validateSkillID("SKILL_ID_2"));
        } else if (entity instanceof MonsterEntity) {
            api = new VotWAPI(50, 25, 100);
        } else {
            return;
        }

        deriveStatsFromMagicules(entity, api);
    }

    public static void deriveStatsFromMagicules(Entity entity, VotWAPI api) {
        double baseStrengthRatio;
        double magicules = api.getMagicules();

        if (entity instanceof PlayerEntity) {
            baseStrengthRatio = 0.1;
        } else if (entity instanceof MonsterEntity) {
            baseStrengthRatio = 0.05;
        } else {
            return;
        }

        double derivedStrength = magicules * baseStrengthRatio;
        int roundedStrength = (int) Math.round(derivedStrength); // Rounding to whole number

        // Use `roundedStrength` for setting the strength of the entity
    }

    public static void updateResourcesForEntity(Entity entity) {
        // Logic to update resources based on conditions
    }

    private static String validateSkillID(String skillID) {
        if (skillID.length() > MAX_STRING_LENGTH) {
            throw new IllegalArgumentException("Skill ID is too long!");
        }
        return skillID;
    }

    @SubscribeEvent
    public void onEntitySpawn(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();

        // Check if the entity is a Player, a Monster (hostile mob), or a Passive mob
        if (entity instanceof PlayerEntity || entity instanceof CreatureEntity) {
            initializeResourcesForEntity(entity);

            CompoundNBT nbt = entity.getPersistentData();
            VotWAPI api = getVotWAPIForEntity(entity);
            nbt.put("VotWData", api.toNBT());
        }
    }

    public VotWAPI getVotWAPIForEntity(Entity entity) {
        CompoundNBT nbt = entity.getPersistentData();
        if(nbt.contains("VotWData")) {
            CompoundNBT votwData = nbt.getCompound("VotWData");
            VotWAPI api = new VotWAPI(0, 0, 0);  // Initialize with dummy values
            api.fromNBT(votwData);
            return api;
        }
        return null;  // Or throw an exception if this is unexpected
    }

    // ... other helper methods or logic ...
}
