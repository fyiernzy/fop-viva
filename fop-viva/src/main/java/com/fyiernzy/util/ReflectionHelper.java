package com.fyiernzy.util;

import com.fyiernzy.Solution;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionHelper {
    @SuppressWarnings("unchecked")
    public static Set<Solution> findImplementations(String packageName, Class<?> interfaceType) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends Solution>> implementations = reflections.getSubTypesOf((Class<Solution>) interfaceType);

        return implementations.stream()
                .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers())) // Exclude abstract classes
                .map(clazz -> {
                    try {
                        return clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to instantiate: " + clazz.getName(), e);
                    }
                })
                .collect(Collectors.toSet());
    }
}

