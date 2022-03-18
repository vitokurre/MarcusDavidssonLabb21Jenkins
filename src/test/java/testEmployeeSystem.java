import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class testEmployeeSystem {
    Employee testObject1;
    Employee testObject2;
    Employee testObject3;
    EmployeeSystem testObjectSystem;


    @BeforeAll
    public static void beforeAll() {
        System.out.println("Nu börjar testsviten för Labb 1 i TDD");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Nu avslutas testsviten");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test slut");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test start");

        testObject1 = new Employee("Marcus", "Davidsson", 33, 30500.00);
        testObject2 = new Employee("Jakob", "Nilsson", 23, 30000.00);
        testObject3 = new Employee("Anki", "Phan", 24, 40000.00);

        testObjectSystem = new EmployeeSystem();


    }

    @Test
    public void checkGetEmployeeListTest() {

        int expected = 0;
        ArrayList<Employee> employeesTest = new ArrayList<Employee>();

        employeesTest = testObjectSystem.GetEmployeeList();

        int actual = employeesTest.size();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkAddEmployeeTest() {

        int expected = 3;
        ArrayList<Employee> employeesTest = new ArrayList<Employee>();

        testObjectSystem.addEmployee(testObject1);
        testObjectSystem.addEmployee(testObject2);
        testObjectSystem.addEmployee(testObject3);

        employeesTest = testObjectSystem.GetEmployeeList();

        int actual = employeesTest.size();

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void checkRemoveEmployeeTest() {

        int expected = 2;

        ArrayList<Employee> employeesTest = new ArrayList<Employee>();

        testObjectSystem.addEmployee(testObject1);
        testObjectSystem.addEmployee(testObject2);
        testObjectSystem.addEmployee(testObject3);

        testObjectSystem.removeEmployee(testObject2);

        employeesTest = testObjectSystem.GetEmployeeList();

        int actual = employeesTest.size();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkGetEmployeeSalaryTest() {

        double actual = 30500.00;

        testObjectSystem.addEmployee(testObject1);

        int ID = testObject1.getUniqueID();

        double expected = testObjectSystem.getEmployeeSalary(ID);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkRaiseEmployeeSalaryTest() {

        double raiseSalaryByPercent = 1.02;
        double expected = 30500.00 * raiseSalaryByPercent;

        testObjectSystem.addEmployee(testObject1);
        int ID = testObject1.getUniqueID();

        testObjectSystem.raiseEmployeeSalary(ID, raiseSalaryByPercent);

        double actual = testObjectSystem.getEmployeeSalary(ID);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkRaiseEmployeeSalaryTest2() {

        double raiseSalaryByPercent = 1;
        double expected = 30500.00;

        testObjectSystem.addEmployee(testObject1);
        int ID = testObject1.getUniqueID();

        testObjectSystem.raiseEmployeeSalary(ID, raiseSalaryByPercent);

        double actual = testObjectSystem.getEmployeeSalary(ID);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkRaiseEmployeeSalaryTest3() {

        double raiseSalaryByPercent = 2.01;
        double expected = 30500.00;

        testObjectSystem.addEmployee(testObject1);
        int ID = testObject1.getUniqueID();

        testObjectSystem.raiseEmployeeSalary(ID, raiseSalaryByPercent);

        double actual = testObjectSystem.getEmployeeSalary(ID);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkRaiseAllEmployeeSalaryTest() {

        double raiseSalaryByPercent = 1.02;
        double expected1 = 30500.00 * raiseSalaryByPercent;
        double expected2 = 30000.00 * raiseSalaryByPercent;
        double expected3 = 40000.00 * raiseSalaryByPercent;

        int ID1 = testObject1.getUniqueID();
        int ID2 = testObject2.getUniqueID();
        int ID3 = testObject3.getUniqueID();

        testObjectSystem.addEmployee(testObject1);
        testObjectSystem.addEmployee(testObject2);
        testObjectSystem.addEmployee(testObject3);

        testObjectSystem.raiseAllEmployeesSalary(raiseSalaryByPercent);

        double actual1 = testObjectSystem.getEmployeeSalary(ID1);
        double actual2 = testObjectSystem.getEmployeeSalary(ID2);
        double actual3 = testObjectSystem.getEmployeeSalary(ID3);

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);

    }

    @Test
    public void checkRaiseAllEmployeeSalaryTest2() {

        double raiseSalaryByPercent = 1;
        double expected1 = 30500.00;
        double expected2 = 30000.00;
        double expected3 = 40000.00;

        int ID1 = testObject1.getUniqueID();
        int ID2 = testObject2.getUniqueID();
        int ID3 = testObject3.getUniqueID();

        testObjectSystem.addEmployee(testObject1);
        testObjectSystem.addEmployee(testObject2);
        testObjectSystem.addEmployee(testObject3);

        testObjectSystem.raiseAllEmployeesSalary(raiseSalaryByPercent);

        double actual1 = testObjectSystem.getEmployeeSalary(ID1);
        double actual2 = testObjectSystem.getEmployeeSalary(ID2);
        double actual3 = testObjectSystem.getEmployeeSalary(ID3);

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);

    }

    @Test
    public void checkRaiseAllEmployeeSalaryTest3() {

        double raiseSalaryByPercent = 2.01;
        double expected1 = 30500.00;
        double expected2 = 30000.00;
        double expected3 = 40000.00;

        int ID1 = testObject1.getUniqueID();
        int ID2 = testObject2.getUniqueID();
        int ID3 = testObject3.getUniqueID();

        testObjectSystem.addEmployee(testObject1);
        testObjectSystem.addEmployee(testObject2);
        testObjectSystem.addEmployee(testObject3);

        testObjectSystem.raiseAllEmployeesSalary(raiseSalaryByPercent);

        double actual1 = testObjectSystem.getEmployeeSalary(ID1);
        double actual2 = testObjectSystem.getEmployeeSalary(ID2);
        double actual3 = testObjectSystem.getEmployeeSalary(ID3);

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
        Assertions.assertEquals(expected3, actual3);

    }
}
