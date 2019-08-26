package com.fahrizal.homerobot;

import com.fahrizal.homerobot.commands.GarageDoorDownCommand;
import com.fahrizal.homerobot.commands.GarageDoorUpCommand;
import com.fahrizal.homerobot.commands.LightOffCommand;
import com.fahrizal.homerobot.commands.LightOnCommand;
import com.fahrizal.homerobot.features.GarageDoor;
import com.fahrizal.homerobot.features.Light;

public class Main {

    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

//        SimpleRemoteControl robot = new SimpleRemoteControl();
//        robot.setCommand(lightOn);
//        robot.buttonWasPressed();

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0,lightOn,lightOff);
        remoteControl.setCommand(1,garageDoorUp, garageDoorDown);


        remoteControl.onCommandWasPushed(0);
        remoteControl.onCommandWasPushed(1);
        remoteControl.onCommandWasPushed(2);
        remoteControl.offCommandWasPushed(0);
        remoteControl.offCommandWasPushed(1);
    }
}
