package learning.business;

public class Calculator {

    public int addTwoInteger(int numberOne, int numberTwo) {
        try {
            // Attendre 2 secondes
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return numberOne + numberTwo;
    }

    public int substractTwoInteger(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    public int multiplyTwoInteger(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }
}
