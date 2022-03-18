import jdk.nashorn.internal.objects.annotations.Where;

import java.util.ArrayList;

public class EmployeeSystem {

    ArrayList<Employee> employees = new ArrayList<Employee>();


    public ArrayList<Employee> GetEmployeeList() {
        return employees;
    }

    public void addEmployee(Employee testObject) {
        employees.add(testObject);
    }

    public void removeEmployee(Employee testObject) {
        employees.remove(testObject);
    }

    public double getEmployeeSalary(int objectID) {

        int ID = objectID;
        double salary = 0;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getUniqueID() == objectID) {
                salary = employees.get(i).getSalary();
            }
        }

        return salary;
    }

    public void raiseEmployeeSalary(int ID, double raiseSalaryByPercent) { //gör om till void, kalla på getSalary i testet

        int employeeID = ID;
        double percent = raiseSalaryByPercent;

        double salary = getEmployeeSalary(ID);

        if ((percent > 1) && (percent <= 2)) {
            salary = salary * percent;


            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getUniqueID() == ID) {
                    employees.get(i).setSalary(salary);
                }
            }

        }
        if ((percent <= 1) || (percent > 2)) {

            System.out.println("Can't lower a salary or give a raise above 100%. Please try again");
        }
    }

    public void raiseAllEmployeesSalary(double raiseSalaryByPercent) {

        double raisePercent = raiseSalaryByPercent;
        int ID;


        for (int i = 0; i < employees.size(); i++) {

            ID = employees.get(i).getUniqueID();
            raiseEmployeeSalary(ID, raisePercent);

        }

    }
}

