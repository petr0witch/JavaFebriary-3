package org.example;

import java.time.LocalDate;
import java.util.List;

public class Manager extends Employee {

    // Конструктор для класса Manager
    public Manager(String name, String position, double salary, String phone, LocalDate date) {
        super(name, position, salary, phone, date);
    }

    // Статический метод повышения зарплаты для всех сотрудников, кроме руководителей
    public static void salaryUpForEmployees(List<Employee> employees, double bonusValue) {
        for (Employee empl : employees) {
            if (!(empl instanceof Manager)) {
                empl.salaryUp(bonusValue);
            }
        }
    }
}
