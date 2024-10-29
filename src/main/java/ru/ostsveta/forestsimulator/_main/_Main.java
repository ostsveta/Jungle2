package ru.ostsveta.forestsimulator._main;

import ru.ostsveta.forestsimulator.model.Fox;
import ru.ostsveta.forestsimulator.util.EventCreate;

public class _Main {

    public static void main(String[] args) {
        Fox fox = new Fox();
        EventCreate eventCreate = new EventCreate();
        eventCreate.activateSimulator(fox);
    }
}
