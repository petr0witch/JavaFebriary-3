package org.example;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
@Getter
@Setter
@AllArgsConstructor
//@EqualsAndHashCode
//@ToString

public class Employee {
    private String name;
    private String position;
    private BigDecimal salary;
    private String phone;
    private LocalDate date;

    // Прототип компаратора для сравнения дат
    public int compareDates(LocalDate otherDate) {
        return date.compareTo(otherDate);
    }

    public Employee(String name, String position, double salary, String phone, LocalDate date) {
        this.name = name;
        this.position = position;
        this.salary = BigDecimal.valueOf(salary);
        this.phone = phone;
        this.date = date;
    }

    public int getAge () {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(date, currentDate).getYears();
        return age;
    }

    @Override
    public String toString() {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(date, currentDate).getYears();
        return String.format("%s - %s, salary - %s, %d years, phone: %s", name, position, salary, this.getAge(), phone );
    }

    public void printInfo(){
        System.out.println(this);
    }
    public void salaryUp (double value){
        this.salary = salary.add(BigDecimal.valueOf(value));

    }
}