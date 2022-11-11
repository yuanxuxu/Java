package designpatterns.creational.factory.simplefactory.polyoverswitch.poly;

public class EmployeeFactory {
    public static Employee create(EmployeeType employeeType) throws Exception {
        switch (employeeType) {
            case DEVELOPER:
                return new Developer();
            case MANAGER:
                return new Manager();
            default:
                throw new Exception("Invalid employee type");
        }
    }
}
