package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Twitter {

    private static final Follower userA = text -> System.out.println(String.format("UserA follower received %s", text));

    public static void main(String[] args) {
        Followee followee = new Followee();

        followee.add(Follower.defaultFollower()); // default impl
        followee.add(userA); // static impl
        followee.add(new userB()); // class
        followee.add(new Follower() { // annoymouse class
            @Override
            public void receive(String text) {
                System.out.println(String.format("Annoymous follower received %s", text));
            }
        });

        followee.notifyObservers("I just broke up");
    }
}

interface Follower {
    public void receive(String text);

    static Follower defaultFollower() {
        return text -> System.out.println(String.format("Default follower received %s", text));
    }
}

class userB implements Follower {

    @Override
    public void receive(String text) {
        System.out.println(String.format("UserB follower received %s", text));
    }

}

class Followee {
    List<Follower> followers = new ArrayList<>();

    public void notifyObservers(String text) {
        for (Follower follower : followers) {
            follower.receive(text);
        }
    }

    public void add(Follower follower) {
        followers.add(follower);
    }

    public void remove(Follower follower) {
        followers.remove(follower);
    }
}
