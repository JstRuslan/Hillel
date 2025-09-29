import org.summer2025.ruslan.PasswordGenerator;

public class StartApp {

    public static void main(String[] args) {
        System.out.println(new PasswordGenerator().generatePassword(11));
    }
}
