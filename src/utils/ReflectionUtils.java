package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void printClassInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("--- Reflection Info for: " + clazz.getSimpleName() + " ---");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName() + " | Type: " + field.getType().getSimpleName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }
        System.out.println("-------------------------------------------");
    }
}