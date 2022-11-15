package javabasic.concurrency.threadlocal;

public class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();

    class Service1 {
        public void process() {
            User user = new User();
            UserContextHolder.holder.set(user); // set
        }
    }

    class Service2 {
        public void process() {
            User user = UserContextHolder.holder.get(); // get
        }
    }

    class ServiceLast {
        public void process() {
            // Last service, user no longer required
            UserContextHolder.holder.remove();
        }
    }
}

class User {

}