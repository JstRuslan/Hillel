package HW16;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class RunApp {

    public static void main(String[] args) {

        /*Створіть функціональний інтерфейс MathOperation, який має один метод int operate(int a, int b).
        Використовуючи анонімний клас, створіть об'єкт інтерфейсу MathOperation, який виконує операцію додавання.
        */
        MathOperation addNumber = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        int result = addNumber.operate(7, 5);
        System.out.println(result);


        /*Створіть лямбда-вираз, який реалізує функціональний інтерфейс StringManipulator
        і перетворює вхідний рядок в верхній регістр.*/
        String str = "Створіть лямбда-вираз, який реалізує функціональний інтерфейс StringManipulator";
        StringManipulator toUpperCase = inStr -> inStr.toUpperCase();
        String resultStr = toUpperCase.strManipulate(str);
        System.out.println(resultStr);

        /*Створіть клас StringListProcessor, який має статичний метод int countUppercase(String s), що повертає кількість
        великих літер у рядку. Використайте посилання на методи, щоб передати метод countUppercase як аргумент функції
        Function<String, Integer>.*/
        Function<String, Integer> counter = StringListProcessor::countUppercase;
        System.out.println(counter.apply("Створіть клас StringListProcessor, який має статичний метод..."));

        /*Створіть клас RandomNumberGenerator, який має статичний метод int generateRandomNumber(int min, int max),
        що повертає випадкове ціле число в заданому діапазоні.
        Використайте інтерфейс Supplier<T> для створення постачальника, який буде генерувати
        випадкове число від 1 до 100.*/
        int min = 1;
        int max = 100;
        int randomNumberStatic = RandomNumberGenerator.generateRandomNumber(min, max);
        Supplier<Integer> randomNumberProvider = () -> new Random().nextInt(max - min + 1) + min;
        int randomNumberLambda = randomNumberProvider.get();
        System.out.println("Статичний метод int generateRandomNumber: " + randomNumberStatic);
        System.out.println("Інтерфейс Supplier<T> для створення постачальника: " + randomNumberLambda);

    }
}
