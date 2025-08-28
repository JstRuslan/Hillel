package HW16;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StringListProcessorTest {

    @Tag("fast")
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {
            "Створіть функціональний інтерфейс MathOperation",
            "Використовуючи анонімний клас, створіть об'єкт інтерфейсу MathOperation"
    })
    void countUppercaseCharParameterized(String str) {
        int result = StringListProcessor.countUppercase(str);
        System.out.println(result);

    }
}