package designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * In software engineering, the mediator pattern defines an object
 * that encapsulates how a set of objects interact.
 *
 * This pattern is considered to be a behavioral pattern
 * due to the way it can alter the program's running behavior.
 * */
public class MediatorDemo {

    public static void main(String[] args) {
        ApplicationMediator mediator = new ApplicationMediator();

        ConcreteColleague concreteColleague = new
                ConcreteColleague(mediator);
        MobileColleague mobileColleague = new
                MobileColleague(mediator);

        mediator.add(concreteColleague);
        mediator.add(mobileColleague);

        concreteColleague.send("Hello mobile");
        mobileColleague.send("Hello con");

    }

}

interface Mediator {
    void send(String message, Colleague colleague);
}

abstract class Colleague {
    private Mediator mediator;

    public Colleague(){}

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void receive(String message);
}

class ApplicationMediator implements Mediator {

    private List<Colleague> colleagues;

    public ApplicationMediator() {
        colleagues = new ArrayList<>();
    }

    public void add(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void send(String message, Colleague colleague) {
        for(Colleague c : colleagues) {
            if(!c.equals(colleague)) {
                colleague.receive(message);
            }
        }
    }
}

class ConcreteColleague extends Colleague {
    public ConcreteColleague() {
        super();
    }

    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        super.send(message);
    }

    @Override
    public Mediator getMediator() {
        return super.getMediator();
    }

    @Override
    public void receive(String message) {
        System.out.println("Colleague Received: " + message);
    }

}

class MobileColleague extends Colleague {
    public MobileColleague() {
        super();
    }

    public MobileColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        super.send(message);
    }

    @Override
    public Mediator getMediator() {
        return super.getMediator();
    }

    @Override
    public void receive(String message) {
        System.out.println("Mobile Received: " + message);
    }
}

