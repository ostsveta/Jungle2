package ru.ostsveta.forestsimulator.model;

public class Fox {

    private int energy = 100;
    private int health = 100;
    private int jawEnergyProduction = 2;

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public int getJawEnergyProduction() {
        return this.jawEnergyProduction;
    }
}
