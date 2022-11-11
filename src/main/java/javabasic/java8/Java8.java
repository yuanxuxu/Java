package javabasic.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8 {
    public static void main(String[] args) {
        int[] numbers = { 4, 1, 12 };
        int min = IntStream.of(numbers).min().getAsInt(); // max, average, count, sum
        System.out.println(min);

        IntStream.of(numbers).min().ifPresent(a -> System.out.println(a));
        // simple lambda replace with method reference

        IntStream.of(numbers).min().ifPresent(System.out::println);

        IntStream.of(numbers) // create stream
                .distinct() // process stream
                .sorted()
                .limit(2)
                .forEach(System.out::println); // consume stream

        Employee A = new Employee(2, "Amy");
        Employee B = new Employee(3, "Tom");
        List<Employee> employees = new ArrayList<>(Arrays.asList(A, B));
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(2)
                .map(Employee::getName)
                // .forEach(System.out::println);
                .collect(Collectors.toList());

        // parallel, only when more than 10000 element, measure first
        employees.stream()
                .parallel()
                .collect(Collectors.groupingBy(e -> e.name));

        Collections.sort(employees, (a, b) -> b.salary - a.salary);
    }

    static class Employee {
        int salary;
        String name;

        public Employee(int salary, String name) {
            this.name = name;
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }
    }
}
