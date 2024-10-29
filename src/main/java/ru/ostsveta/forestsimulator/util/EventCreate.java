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

    private void eatBunnyEvent (Fox fox) {
        int energy = fox.getEnergy();
        int health = fox.getHealth();
        energy = energy - 9;
        if (energy <= 0) {
            energy = 0;
        }
        health = health + fox.getJawEnergyProduction() * 8;
        if (health > 100) {
            health = 100;
        }
        fox.setEnergy(energy);
        fox.setHealth(health);
        System.out.println("Охота на зайца прошла успешно! Большая добыча! - 9 энергии, + " + (fox.getJawEnergyProduction() * 8) + " здоровья.");
    }

    private void eatChickenEvent (Fox fox) {
        int energy = fox.getEnergy();
        int health = fox.getHealth();
        energy = energy - 10;
        if (energy <= 0) {
            energy = 0;
        }
        health = health + fox.getJawEnergyProduction() * 4;
        if (health > 100) {
            health = 100;
        }
        fox.setEnergy(energy);
        fox.setHealth(health);
        System.out.println("Недалеко замечена ферма. Удалось пробраться и украсть небольшую курицу! Время подкрепиться! - 10 энергии, + " + (fox.getJawEnergyProduction() * 4) + " здоровья.");
    }

    private void digsBurrowEvent (Fox fox) {
        int energy = fox.getEnergy();
        energy = energy - 15;
        if (energy <= 0) {
            energy = 0;
        }
        fox.setEnergy(energy);
        System.out.println("Лиса вырыла себе нору. - 15 энергии.");
    }

    private void runEvent (Fox fox) {
        int energy = fox.getEnergy();
        energy = energy - 7;
        if (energy <= 0) {
            energy = 0;
        }
        fox.setEnergy(energy);
        System.out.println("Почуяла врага! Пришлось много бегать, чтобы запутать след. - 7 энергии");
    }

    private void wolfAttackEvent (Fox fox) {
        int health = fox.getHealth();
        health = health - 20;
        if (health <= 0) {
            health = 0;
        }
        fox.setHealth(health);
        System.out.println("На лису напал волк! - 20 здоровья.");
    }


}
