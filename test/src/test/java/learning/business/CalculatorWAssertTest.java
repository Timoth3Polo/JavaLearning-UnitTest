package learning.business;

import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorWAssertTest {

    private static Instant startedAt;

    private Calculator calculatorUnderTest;

    @BeforeEach
    public void methodeAppeleeAvantChaqueTest() {
        System.out.println("Appel avant chaque test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void methodeAppeleeApresChaqueTest() {
        System.out.println("Appel après chaque test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public static void methodeAppeleeAvantTousLesTests() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();


    }

    @AfterAll
    public static void methodeAppeleeApresTousLesTests() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @Test
    public void should_return_12() {
        //Arrange
        Integer numberOne = 2;
        Integer numberTwo = 10;
        Calculator calculator = new Calculator();

        //Act
        int result = calculator.addTwoInteger(numberOne, numberTwo);

        //Assert
        assertThat(result).isEqualTo(12);
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void should_return_15() {
        //Arrange
        Integer numberOne = 5;
        Integer numberTwo = 10;

        //Act
        int result = calculatorUnderTest.addTwoInteger(numberOne, numberTwo);

        //Assert
        assertThat(result).isEqualTo(15);
    }
}
