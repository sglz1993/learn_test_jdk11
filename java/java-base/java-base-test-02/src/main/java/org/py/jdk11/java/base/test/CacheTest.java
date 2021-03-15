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

    @Data
    static class Person {
        private String name = "lala";
    }

    @Data
    static class Man extends Person{
        private int age = 1;
    }

}
