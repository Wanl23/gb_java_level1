package ru.geekbrains.lesson4;

    //    1. Создать класс "Сотрудник" с полями: ФИО,зарплата, возраст;
public class Employee {
    private String fio;
    private int salary;
    private int birthday;
    private int id;

    private int year = 2018;
    private static Employee[] employeesArr = new Employee[20];
    private static int index = 0;

    //    2. Конструктор класса должен заполнять эти поля при создании объекта;
    Employee(String fio, int salary, int birthday) {

    //    8. *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
    // присваивался личный уникальный идентификационный порядковый номер
        this.id = index++;
        this.fio = fio;
        this.salary = salary;
        this.birthday = birthday;
        employeesArr[id] = this;
    }

    //    3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getFio(){
        return fio;
    }

    public int getSalary(){
        return salary;
    }

    public int getAge() { return year - birthday; }

    public int getId() {
        return this.id;
    }

    public static Employee[] getEmployeesArr() { return employeesArr;}


    //    6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    public static void increaseSalary() {
        for(int i = 0; i < employeesArr.length; i++) {
            if (employeesArr[i] != null && employeesArr[i].getAge() > 45)
                employeesArr[i].salary += 5000;
        }
    }

    //    7. ** Написать методы (принимающие на вход массив сотрудников), вычисляющие средний возраст
    public static float getAverageAge(Employee[] employeesList){
        int averageAge = 0;

        for(int i = 0; i < employeesList.length; i++)
            averageAge += employeesList[i].getAge();

        return averageAge/(float)employeesList.length;
    }

    //    и среднюю зарплату сотрудников, вывести результаты работы в консоль.
    public static float getAverageSalary(Employee[] employeesList){
        int averageSalary = 0;

        for(int i = 0; i < employeesList.length; i++)
            averageSalary += employeesList[i].getSalary();

        return averageSalary/(float)employeesList.length;
    }
}

