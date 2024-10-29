package ru.ostsveta.forestsimulator.util;

import ru.ostsveta.forestsimulator.model.Fox;

public class EventSimulator {

    // Лиса поспала. + 10 энергии
    // Лиса съела мышь. - 15 энергии; + (коэфф * 2 здоровья)
    // Лиса съела зайца. - 19 энергии; + (коэфф * 5 здоровья)
    // Лиса вырыла нору. - 27 энергии
    // Лиса путает следы (много бегает). - 25 энергии
    // Лиса встретила в лесу волка. - 25 здоровья
    // Лиса пробралась на ферму и украла курицу. - 17 энергии; + (коэфф * 3 здоровья)
    // Лису заметил охотник. - 20 здоровья
    // Лиса повалялась на солнышке в поле. + 3 энергии
    // Лиса отправилась на охоту, но безуспешно. - 18 энергии

    // если энергия = 0, то здоровье - 10

    public void activateSimulator(Fox fox) {
        Math.random();
        while (checkStatus(fox)) {
            int randomNumber = (int) (Math.random() * 100);
            if (randomNumber >= 0 && randomNumber < 5) {
                sleepEvent(fox);
            } else if (randomNumber >= 5 && randomNumber < 15) {
                eatMouseEvent(fox);
            } else if (randomNumber >= 15 && randomNumber < 25) {
                eatBunnyEvent(fox);
            } else if (randomNumber >= 25 && randomNumber < 35) {
                digsBurrowEvent(fox);
            } else if (randomNumber >= 35 && randomNumber < 50) {
                runEvent(fox);
            } else if (randomNumber >= 50 && randomNumber < 60) {
                wolfAttackEvent(fox);
            } else if (randomNumber >= 60 && randomNumber < 70) {
                eatChickenEvent(fox);
            } else if (randomNumber >= 70 && randomNumber < 80) {
                hunterAttackEvent(fox);
            } else if (randomNumber >= 80 && randomNumber < 90) {
                sunLyingEvent(fox);
            } else if (randomNumber >= 90 && randomNumber < 100) {
                badHuntEvent(fox);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("К сожалению, лисичка не справилась с этим испытанием судьбы и отправилась на облака. The end.");
    }

    private void sleepEvent(Fox fox) {
        int energy = fox.getEnergy();
        energy = energy + 10;
        if (energy > 100) {
            energy = 100;
        }
        fox.setEnergy(energy);
        checkEnergy(fox);
        System.out.println("Лиса поспала. + 10 энергии.");
    }

    private void eatMouseEvent(Fox fox) {
        int energy = fox.getEnergy();
        int health = fox.getHealth();
        energy = energy - 15;
        if (energy < 0) {
            energy = 0;
        }
        health = health + fox.getJawEnergyProduction() * 2;
        if (health > 100) {
            health = 100;
        }
        fox.setEnergy(energy);
        fox.setHealth(health);
        checkEnergy(fox);
        System.out.println("Лиса поймала полевую мышь! Довольно сытный перекус! - 15 энергии, + " + (fox.getJawEnergyProduction() * 2) + " здоровья.");
    }

    private void eatBunnyEvent(Fox fox) {
        int energy = fox.getEnergy();
        int health = fox.getHealth();
        energy = energy - 19;
        if (energy < 0) {
            energy = 0;
        }
        health = health + fox.getJawEnergyProduction() * 5;
        if (health > 100) {
            health = 100;
        }
        fox.setEnergy(energy);
        fox.setHealth(health);
        checkEnergy(fox);
        System.out.println("Охота на зайца прошла успешно! Большая добыча! - 19 энергии, + " + (fox.getJawEnergyProduction() * 5) + " здоровья.");
    }

    private void eatChickenEvent(Fox fox) {
        int energy = fox.getEnergy();
        int health = fox.getHealth();
        energy = energy - 17;
        if (energy < 0) {
            energy = 0;
        }
        health = health + fox.getJawEnergyProduction() * 3;
        if (health > 100) {
            health = 100;
        }
        fox.setEnergy(energy);
        fox.setHealth(health);
        checkEnergy(fox);
        System.out.println("Недалеко замечена ферма. Удалось пробраться и украсть небольшую курицу! Время подкрепиться! - 17 энергии, + " + (fox.getJawEnergyProduction() * 3) + " здоровья.");
    }

    private void digsBurrowEvent(Fox fox) {
        int energy = fox.getEnergy();
        energy = energy - 27;
        if (energy < 0) {
            energy = 0;
        }
        fox.setEnergy(energy);
        checkEnergy(fox);
        System.out.println("Лиса вырыла себе нору. - 27 энергии.");
    }

    private void runEvent(Fox fox) {
        int energy = fox.getEnergy();
        energy = energy - 25;
        if (energy < 0) {
            energy = 0;
        }
        fox.setEnergy(energy);
        checkEnergy(fox);
        System.out.println("Почуяла врага! Пришлось много бегать, чтобы запутать след. - 25 энергии");
    }

    private void wolfAttackEvent(Fox fox) {
        int health = fox.getHealth();
        health = health - 25;
        if (health < 0) {
            health = 0;
        }
        fox.setHealth(health);
        checkEnergy(fox);
        System.out.println("На лису напал волк! - 25 здоровья.");
    }

    private void hunterAttackEvent(Fox fox) {
        int health = fox.getHealth();
        health = health - 20;
        if (health < 0) {
            health = 0;
        }
        fox.setHealth(health);
        checkEnergy(fox);
        System.out.println("Лису заметил охотник и подстрелил ее! - 20 здоровья.");
    }

    private void sunLyingEvent(Fox fox) {
        int energy = fox.getEnergy();
        energy = energy + 3;
        if (energy > 100) {
            energy = 100;
        }
        fox.setEnergy(energy);
        checkEnergy(fox);
        System.out.println("Выглянуло солнце! Можно поваляться в поле и отдохнуть. + 3 энергии.");
    }

    private void badHuntEvent(Fox fox) {
        int energy = fox.getEnergy();
        energy = energy - 18;
        if (energy < 0) {
            energy = 0;
        }
        fox.setEnergy(energy);
        checkEnergy(fox);
        System.out.println("Лиса отправилась на охоту, но она оказалась безуспешной. - 18 энергии.");
    }

    private void checkEnergy(Fox fox) {
        if (fox.getEnergy() <= 0) {
            int healht = fox.getHealth();
            healht = healht - 10;
            if (healht < 0) {
                healht = 0;
            }
            fox.setHealth(healht);
        }
    }

    private boolean checkStatus(Fox fox) {
        System.out.println("hp: " + fox.getHealth() + ", energy: " + fox.getEnergy());
        if (fox.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
