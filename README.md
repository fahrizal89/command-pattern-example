# Command Pattern

Command Pattern is encapsulates request an an object, thereby letting you to parameterize other objects with different request and you can reuse them or implementation undo.

Client -> Invoker -> Receiver

For example we create HomeRobot App.

HomeRobot can manage furniture like a lamp, door, electric window etc. We can give command to some furniture and don't worry what is doing by furniture.

Create interface for implementaion in command
```
public interface Command {
    void execute();
    
    void undo();
}
```

Create object of furniture
```
public class Light {
    public void on(){
        System.out.println("Light is turn on");
    }

    public void off(){
        System.out.println("Light is turn off");
    }
}
```

Create commands of furniture with implements Command
```
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

public class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
```

```
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

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
        undoCommand = onCommands[slot];
    }

    public void offCommandWasPushed(int slot){
        if(onCommands[slot]==null){
            errorCommand();
            return;
        }
        offCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    private void errorCommand(){
        System.out.println("--command not exist--");
    }

    public void undoCommandWasPushed(){
        undoCommand.undo();
    }
}
```

```
public static void main(String[] args) {
    Light light = new Light();
    LightOnCommand lightOn = new LightOnCommand(light);
    LightOffCommand lightOff = new LightOffCommand(light);

    GarageDoor garageDoor = new GarageDoor();
    GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
    GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

    RemoteControl remoteControl = new RemoteControl();
    remoteControl.setCommand(0,lightOn,lightOff);
    remoteControl.setCommand(1,garageDoorUp, garageDoorDown);


    remoteControl.onCommandWasPushed(0);
    remoteControl.onCommandWasPushed(1);
    remoteControl.onCommandWasPushed(2);

    remoteControl.offCommandWasPushed(0);
    remoteControl.offCommandWasPushed(1);
    remoteControl.onCommandWasPushed(1);

    System.out.println("--undo--");
    remoteControl.undoCommandWasPushed();
}
```

# output
```
Light is turn on
Garage door is up
--command not exist--
Light is turn off
Garage door is down
Garage door is up
--undo--
Garage door is down
```
