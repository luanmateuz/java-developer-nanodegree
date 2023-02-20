package com.example.demo.util;

import java.lang.reflect.Field;

public class InjectDependencies {

    public static void injectObjects(Object target, String fieldName, Object toInject) {

        boolean wasPrivate = false;

        try {
            final Field declaredField = target.getClass().getDeclaredField(fieldName);

            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
                wasPrivate = true;
            }

            declaredField.set(target, toInject);

            if (wasPrivate) {
                declaredField.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
