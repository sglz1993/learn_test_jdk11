package org.py.jdk11.java.base.test;

import lombok.Data;
import org.junit.Test;
import org.py.common.cache.SingletonFunction;

public class CacheTest {

    @Test
    public void testCacheUtil() {
        SingletonFunction<Person, Person> function = SingletonFunction.of(p -> p);
        function.get(new Person());
        function.get(new Man());
    }

    @Test
    public void testPersionField() {
        Person p = new Man();
        System.out.println(p.name);
    }

    @Data
    static class Person {
        String name = "lala";
    }

    @Data
    static class Man extends Person {
        int age = 1;
        String name = "man";
    }

}
