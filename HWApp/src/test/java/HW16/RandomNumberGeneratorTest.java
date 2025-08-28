package HW16;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import HW16.RandomNumberGenerator;

import static HW16.RandomNumberGenerator.generateRandomNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class RandomNumberGeneratorTest {

    @Tag("fast")
    @RepeatedTest(5)
    void generateRandomNumberTest() {
        int min = 1;
        int max = 100;

        int randomNumber = generateRandomNumber(min,max);

        assertThat(randomNumber).isBetween(min,max);
    }
}