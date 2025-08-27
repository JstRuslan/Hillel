package HW16;

public class StringListProcessor {
   public static int countUppercase(String s) {
        return (int) s.chars()
                .filter(ch->Character.isUpperCase(ch))
                .count();
    }
}
