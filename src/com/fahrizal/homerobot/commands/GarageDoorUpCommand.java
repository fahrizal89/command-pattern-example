package com.fahrizal.homerobot.commands;

import com.fahrizal.homerobot.features.GarageDoor;

public class GarageDoorUpCommand implements Command{
    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }


    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
