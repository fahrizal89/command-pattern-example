package com.fahrizal.homerobot;

import com.fahrizal.homerobot.commands.Command;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onCommandWasPushed(int slot){
        if(onCommands[slot]==null){
            errorCommand();
            return;
        }
        onCommands[slot].execute();
    }

    public void offCommandWasPushed(int slot){
        if(onCommands[slot]==null){
            errorCommand();
            return;
        }
        offCommands[slot].execute();
    }

    private void errorCommand(){
        System.out.println("--command not exist--");
    }
}
