package HW14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataRepository {

    // Метод повертає список імен
    public List<String> getData() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Alice", "Bob", "Lucy", "Denis", "Tom");
        return list;
    }
}
