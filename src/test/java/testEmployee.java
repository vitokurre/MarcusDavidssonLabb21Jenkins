import org.junit.jupiter.api.*;

public class testEmployee {
    Employee testObject1;
    Employee testObject2;
    Employee testObject3;


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
        testObject2 = new Employee("Jakob", "Nilsson", 23, 30500.00);
        testObject3 = new Employee("Anki", "Phan", 24, 30500.00);

    }


    @Test
    public void checkGetUniqueIDtest2() {

        int actual2 = testObject2.getUniqueID();

        int expected1 = actual2 - 1;
        int expected3 = actual2 + 1;


        int actual1 = testObject1.getUniqueID();
        int actual3 = testObject3.getUniqueID();

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected3, actual3);
    }

    @Test
    public void checkGetFirstNameTest() {

        String expected = "Marcus";

        String actual = testObject1.getFirstName();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkSetFirstNameTest() {

        String expected = "Bengt";

        testObject1.setFirstName(expected);

        String actual = testObject1.getFirstName();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkGetLastNameTest() {
        String expected = "Davidsson";

        String actual = testObject1.getLastName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkSetLastNameTest() {
        String expected = "Bengtsson";

        testObject1.setLastName(expected);

        String actual = testObject1.getLastName();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkGetAgeTest() {

        int expected = 33;

        int actual = testObject1.getAge();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkSetAgeTest() {

        int expected = 45;

        testObject1.setAge(45);

        int actual = testObject1.getAge();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void checkGetSalaryTest() {

        double expected = 30500.00;

        double actual = testObject1.getSalary();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkSetSalaryTest() {

        double expected = 60500.50;

        testObject1.setSalary(expected);

        double actual = testObject1.getSalary();

        Assertions.assertEquals(expected, actual);

    }


}
