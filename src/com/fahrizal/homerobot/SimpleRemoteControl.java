package com.fahrizal.homerobot;

import com.fahrizal.homerobot.commands.Command;

public class SimpleRemoteControl {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed(){
        command.execute();
    }
}
