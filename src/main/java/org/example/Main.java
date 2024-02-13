package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Kirill",
                "analyst",
                40000,
                "+79208342551",
                LocalDate.of(1997, 7, 3));
        Employee employee2 = new Employee("Ivan",
                "engineer",
                80000,
                "+79208654551",
                LocalDate.of(1975, 7, 3));
        Employee employee3 = new Employee("George",
                "teamlead",
                100000,
                "+7920823551",
                LocalDate.of(1983, 7, 3));
        Employee employee4 = new Employee("Max",
                "seo",
                100000,
                "+792456551",
                LocalDate.of(1970, 7, 3));
        Employee employee5 = new Employee("John",
                "manager",
                40000,
                "+79208069551",
                LocalDate.of(2000, 7, 3));
//        System.out.println(employee1);
//        employee1.printInfo();

        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1,employee2, employee3, employee4, employee5));

        salaryUpForEmp(employees, 45, 19999);

        // Создаем экземпляр руководителя
        Manager manager = new Manager("Alex", "manager", 120000, "+79208069551", LocalDate.of(1985, 5, 15));

        // Добавляем руководителя в общий список сотрудников
        employees.add(manager);

        // Повышаем зарплату всем сотрудникам (кроме руководителей)
        salaryUpForEmp(employees, 45, 19999);

        // Повышаем зарплату всем сотрудникам (включая руководителя)
        Manager.salaryUpForEmployees(employees, 15000);

        for (Employee employee: employees) {
            employee.printInfo();
        }
        System.out.println(getAverageSalaryAge(employees));
    }

    // средний возраст и сред зп
    public static String getAverageSalaryAge (List<Employee> employees) {
        StringBuilder builder = new StringBuilder();
        double avgSalary = employees.stream().mapToDouble(x->x.getSalary().doubleValue()).average().orElseThrow();
        double avgAge = employees.stream().mapToDouble(x-> (double) x.getAge()).average().orElseThrow();

        return String.format("Avg salary: %s, Avg age: %s", avgSalary, avgAge);
    }

    public static AverageResponseDTO averageResponseDTO(List <Employee> employees) {
        return AverageResponseDTO.builder()
                .avgAge(employees.stream().mapToDouble(x-> (double) x.getAge()).average().orElseThrow())
                .avgSalary(employees.stream().mapToDouble(x->x.getSalary().doubleValue()).average().orElseThrow())
                .build();
    }

    public static void salaryUpForEmp(List<Employee> employees, int forOver45, double bonusValue) {
        for (Employee empl : employees) {
            if (empl.getAge() > forOver45 && !(empl instanceof Manager)) {
                empl.salaryUp(bonusValue);
            }
        }
    }
}
