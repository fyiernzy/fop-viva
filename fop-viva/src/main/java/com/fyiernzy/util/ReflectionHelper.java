package com.fyiernzy.util;

import com.fyiernzy.Solution;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A utility class that provides reflection-based helper methods
 * for discovering and instantiating implementations of a specific interface.
 */
public class ReflectionHelper {

    /**
     * Finds all non-abstract implementations of a given interface in the specified package.
     * The method uses the Reflections library to scan the package for subclasses or implementations
     * of the specified interface.
     *
     * @param packageName   the name of the package to scan
     * @param interfaceType the interface or base class for which implementations should be discovered
     * @return a set of instantiated objects that implement the specified interface
     * @throws RuntimeException if any discovered implementation cannot be instantiated
     */
    @SuppressWarnings("unchecked")
    public static Set<Solution> findImplementations(String packageName, Class<?> interfaceType) {
        // Use Reflections to scan the specified package for subclasses/implementations
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends Solution>> implementations = reflections.getSubTypesOf((Class<Solution>) interfaceType);

        // Filter out abstract classes, instantiate remaining classes, and collect them into a set
        return implementations.stream()
                .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers())) // Exclude abstract classes
                .map(clazz -> {
                    try {
                        // Instantiate the class using its no-argument constructor
                        return clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        // Wrap any exception into a RuntimeException with a meaningful message
                        throw new RuntimeException("Failed to instantiate: " + clazz.getName(), e);
                    }
                })
                .collect(Collectors.toSet());
    }
}


