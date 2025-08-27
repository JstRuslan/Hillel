package HW16;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomNumber(int min, int max){
        return new Random().nextInt(max-min+1)+min;
    }
}
