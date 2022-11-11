package designpatterns.creational.factory.simplefactory.polyoverswitch.poly;

public class EmployMain {
    public static void main(String[] args) throws Exception {
        Employee employee1 = EmployeeFactory.create(EmployeeType.DEVELOPER);
        Employee employee2 = EmployeeFactory.create(EmployeeType.MANAGER);
        System.out.println(employee1.calculatePay());
    }
}