package ru.ostsveta.forestsimulator.util;

import ru.ostsveta.forestsimulator.model.Fox;

public class EventCreate {

    // Лиса поспала. + 20 энергии
    // Лиса съела мышь. - 3 энергии; + (коэфф * 2 здоровья)
    // Лиса съела зайца. - 9 энергии; + (коэфф * 8 здоровья)
    // Лиса вырыла нору. - 15 энергии
    // Лиса путает следы (много бегает). - 7 энергии
    // Лиса встретила в лесу волка. - 20 здоровья
    // Лиса пробралась на ферму и украла курицу. - 10 энергии; + (коэфф * 4 здоровья)
    // Лису заметил охотник. - 15 здоровья
    // Лиса повалялась на солнышке в поле. + 15 энергии
    // Лиса отправилась на охоту, но безуспешно. - 12 энергии

    // если энергия = 0, то здоровье - 5

    private void sleepEvent (Fox fox) {
        int energy = fox.getEnergy();
        energy = energy + 20;
        if (energy > 100) {
            energy = 100;
        }
        fox.setEnergy(energy);
        System.out.println("Лиса поспала. + 20 энергии.");
    }

    private void eatMouseEvent (Fox fox) {
        int energy = fox.getEnergy();
        int health = fox.getHealth();
        energy = energy - 3;
        if (energy <= 0) {
            energy = 0;
        }
        health = health + fox.getJawEnergyProduction() * 2;
        if (health > 100) {
            health = 100;
        }
        fox.setEnergy(energy);
        fox.setHealth(health);
        System.out.println("Лиса поймала полевую мышь! Довольно сытный перекус! - 3 энергии, + " + (fox.getJawEnergyProduction() * 2) + " здоровья.");
    }

}
