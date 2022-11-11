package designpatterns.behavioral.state;

/**
 * The state pattern is a behavioral software design pattern that
 * allows an object to alter its behavior when its internal state
 * changes. This pattern is close to the concept of finite-state
 * machines. The state pattern can be interpreted as a strategy pattern,
 * which is able to switch a strategy through invocations of
 * methods defined in the pattern's interface.
 * */
public class StateDemo {

    public static void main(String[] args) {
        StateContext context = new StateContext();
        context.writeName("Monday");
        context.writeName("Tuesday");
        context.writeName("Wednesday");
        context.writeName("Thursday");
        context.writeName("Friday");
        context.writeName("Saturday");
        context.writeName("Sunday");
    }
}

interface State {
    void writeName(StateContext context, String name);
}

class LowerCaseState implements State {
    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toLowerCase());
        context.setState(new MultipleUpperCaseState());
    }
}

class MultipleUpperCaseState implements State {
    /* Counter local to this state */
    private int count = 0;

    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toUpperCase());
        /* Change state after StateMultipleUpperCase's writeName() gets invoked twice */
        if (++count > 1) {
            context.setState(new LowerCaseState());
        }
    }
}

class StateContext {
    private State state;

    public StateContext() {
        state = new LowerCaseState();
    }

    /**
     * Set the current state.
     * Normally only called by classes implementing the State interface.
     * @param newState the new state of this context
     */
    void setState(State newState) {
        state = newState;
    }

    public void writeName(String name) {
        state.writeName(this, name);
    }
}