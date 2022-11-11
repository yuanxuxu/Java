package designpatterns.behavioral.command;

import java.util.HashMap;

/**
 * 行为型模式(Behavioral Pattern)是对在不同的对象之间划分责任和算法的抽象化
 *
 * 命令模式: 将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化；
 * 对请求排队或者记录请求日志，以及支持可撤销的操作
 *
 * In object-oriented programming, the command pattern is a
 * behavioral design pattern in which an object is used to
 * encapsulate all information needed to perform an action
 * or trigger an event at a later time. This information
 * includes the method name, the object that owns the method
 * and values for the method parameters.
 * 
 * The Command Pattern encapsulates a request as an object, thereby letting you
 * parameterize other objects with different requests, queue or log requests,
 * and support undoable operations.
 *
 * https://stackoverflow.com/questions/32597736/why-should-i-use-the-command-design-pattern-while-i-can-easily-call-required-met
 *
 *
 * votes
 * 
 * The main motivation for using the Command pattern is that the executor of the
 * command does not need to know anything
 * at all about what the command is, what context information it needs on or
 * what it does.
 * All of that is encapsulated in the command.
 * 
 * o, in summary, the pattern encapsulates everything required to take an action
 * and allows the execution
 * of the action to occur completely independently of any of that context.
 *
 */
public class CommandExample {

    public static void main(String[] args) {
        // Receiver
        Light lamp = new Light();

        // ConcreteCommand
        Command switchOn = new SwitchOnCommand(lamp);

        // Invoker
        Switch mySwitch = new Switch();
        mySwitch.register("on", switchOn);
        // mySwitch.register("off", switchOff);

        mySwitch.execute("on");
        // mySwitch.execute("off");
        SwitchOffCommand switchOffCommand = new SwitchOffCommand(lamp::turnOff); // method reference
        switchOffCommand.execute();
    }

}

/** The Command interface */
interface Command {
    void execute();
}

/** The Invoker class */
class Switch {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalArgumentException("no command registered for " +
                    commandName);
        }
        command.execute();
    }
}

/** The Receiver class */
class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }

    public void turnOff() {
        System.out.println("The light is off");
    }
}

/** ConcreteCommand */
class SwitchOnCommand implements Command {
    private final Light light;

    public SwitchOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Functional style, accept an interface Command
class SwitchOffCommand {
    private final Command command;

    public SwitchOffCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

}
