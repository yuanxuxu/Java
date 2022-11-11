package designpatterns.creational.factory.simplefactory.polyoverswitch;

// switch
public class EmployeeSwitch {
    public EmployeeType employeeType;

    public int salary;
    public int commission;

    public EmployeeSwitch(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public int getPayAmount() throws Exception {
        switch (employeeType) {
            case DEVELOPER: return salary;
            case MANAGER: return salary + commission;
            default: throw new Exception("Unkown type.");
        }
    }
}

enum EmployeeType {
    DEVELOPER,
    MANAGER
}

/**
 public Money calculatePay(Employee e) throws InvalidEmployeeType {
    switch (e.type) {
        case COMMISSIONED: return calculateCommissionedPay(e);
        case HOURLY: return calculateHourlyPay(e);
        case SALARIED: return calculateSalariedPay(e);
        default: throw new InvalidEmployeeType(e.type);
    }
 }
 */