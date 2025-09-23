package HW21;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ArrayUtils {

    @Author(name = "John", lastName = "Doe")
    @MethodInfo(methodName = "Method Info", returnType = "int", description = "Returns the maximum value in the given array.")
    public static int findMaxValue(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Author(name = "John", lastName = "Doe")
    @MethodInfo(methodName = "Contains value", returnType = "boolean", description = "Returns \"TRUE\" if array contains search value.")
    public static boolean containsValue(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Method[] methods = ArrayUtils.class.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println("Method name: " + methodInfo.methodName());
                System.out.println("Return type: " + methodInfo.returnType());
                System.out.println("Description: " + methodInfo.description());

            }
            if (method.isAnnotationPresent(Author.class)) {
                Author author = method.getAnnotation(Author.class);
                System.out.println("Author: " + author.name() + " " + author.lastName());
                System.out.println("-------------------------");

            }
        }
    }
}
