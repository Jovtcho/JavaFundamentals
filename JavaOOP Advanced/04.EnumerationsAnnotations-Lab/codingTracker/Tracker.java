package codingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    @Author
    private void methodOne() {
        System.out.println("Test methodOne");
    }

    @Author(name = "Pecho")
    private String methodTwo() {
        return "Test methodTwo";
    }

    @Author(name = "Lesho")
    private void methodOneStr(String string) {
        System.out.println("Test methodOne");
    }

    @Author(name = "Pecho")
    private String methodTwoInt(int num) {
        return "Test methodTwoInt";
    }

    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> authors = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            Author authorAnnotation = method.getDeclaredAnnotation(Author.class);
            if (authorAnnotation != null) {
                String authorName = authorAnnotation.name();
                String methodName = method.getName();
                authors.putIfAbsent(authorName, new ArrayList<>());
                authors.get(authorName).add(methodName);
            }
        }

        for (Map.Entry<String, List<String>> authorMethods : authors.entrySet()) {
            System.out.printf("%s: %s%n",
                    authorMethods.getKey(), String.join(", ", authorMethods.getValue()));
        }
    }
}
