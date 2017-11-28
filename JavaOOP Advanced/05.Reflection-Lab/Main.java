import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Map<String, Method> getters = new TreeMap<>();
        Map<String, Method> setters = new TreeMap<>();

        Class reflClass = Reflection.class;
        Field[] reflClassFields = reflClass.getDeclaredFields();

        Arrays.sort(reflClassFields, Comparator.comparing(Field::getName));

        for (Field reflClassField : reflClassFields) {
            if (!Modifier.isPrivate(reflClassField.getModifiers())) {
                System.out.println(String.format("%s must be private!", reflClassField.getName()));
            }
        }

        Method[] reflClassMethods = reflClass.getDeclaredMethods();
        for (Method reflClassMethod : reflClassMethods) {
            if (isGetter(reflClassMethod)) {
                getters.putIfAbsent(reflClassMethod.getName(), reflClassMethod);
            }
            if (isSetter(reflClassMethod)) {
                setters.putIfAbsent(reflClassMethod.getName(), reflClassMethod);
            }
        }

        for (Map.Entry<String, Method> getter : getters.entrySet()) {
            // System.out.printf("%s will return %s%n",
            //         getter.getValue().getName(), getter.getValue().getReturnType());
            if (!Modifier.isPublic(getter.getValue().getModifiers())) {
                System.out.printf("%s have to be public!%n", getter.getValue().getName());
            }
        }

        for (Map.Entry<String, Method> setter : setters.entrySet()) {
            //System.out.printf("%s and will set field of %s%n",
            //        setter.getValue().getName(), setter.getValue().getParameterTypes()[0]);
            if (!Modifier.isPrivate(setter.getValue().getModifiers())) {
                System.out.printf("%s have to be private!%n", setter.getValue().getName());
            }
        }


        //System.out.println(reflClass);

        //Class reflClassSuperclass = reflClass.getSuperclass();
        //System.out.println(reflClassSuperclass);

        //Class[] reflClassInterfaces = reflClass.getInterfaces();
        //for (Class reflClassInterface : reflClassInterfaces) {
        //    System.out.println(reflClassInterface);
        //}

        //Reflection reflection = (Reflection) reflClass.newInstance();
        //System.out.println(reflection.toString());
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }
}
