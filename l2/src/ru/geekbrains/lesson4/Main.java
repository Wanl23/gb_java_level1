package ru.geekbrains.lesson4;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args){
        //    4. Вывести в консоль при помощи методов из пункта 3 ФИО и возраст.
        Employee e1 = new Employee("Vasilii Vasilyevich Vasilyev", 40000, 1970);
        System.out.println("Name: " + e1.getFio() + ", age:" + e1.getAge());

        //    5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Employee[] employees = new Employee[] {new Employee("AAA", 30000, 1990),
                    new Employee("BBB", 35000, 1980),
                    new Employee("CCC", 40000, 1970),
                    new Employee("DDD", 45000, 1960),
                    new Employee("EEE", 50000, 1955)};


        for(int i = 0; i < employees.length; i++){
            if(employees[i].getAge() > 0){
                System.out.println("Name: " + employees[i].getFio() + ", salary: " + employees[i].getSalary() +
                        ", age:" + employees[i].getAge());
            }
        }

        //    6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
        System.out.println();
        Employee.increaseSalary();
        Employee[] employeesArr = Employee.getEmployeesArr();
        for(int i = 0; i < employeesArr.length; i++){
            if(employeesArr[i] != null) {
                System.out.println("Name: " + employeesArr[i].getFio() + ", salary: " + employeesArr[i].getSalary() +
                        ", age:" + employeesArr[i].getAge());
            }
        }

        //    7. ** Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст
        System.out.println();
        System.out.println("Average age: " + Employee.getAverageAge(employees));
        //и среднюю зарплату сотрудников, вывести результаты работы в консоль.
        System.out.println("Average salary: " + Employee.getAverageSalary(employees));


        //    8. *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
        // присваивался личный уникальный идентификационный порядковый номер
        System.out.println();
        for(int i = 0; i < employees.length; i++){
            System.out.println(employees[i].getId());
        }
    }
}
