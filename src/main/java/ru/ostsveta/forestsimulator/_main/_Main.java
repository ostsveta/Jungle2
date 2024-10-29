package ru.ostsveta.forestsimulator._main;

import ru.ostsveta.forestsimulator.model.Fox;
import ru.ostsveta.forestsimulator.util.EventSimulator;

public class _Main {

    public static void main(String[] args) {
        Fox fox = new Fox();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.activateSimulator(fox);
    }
}
