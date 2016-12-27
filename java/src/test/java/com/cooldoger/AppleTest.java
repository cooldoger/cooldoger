package com.cooldoger;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'zjay' at '12/26/16 3:41 PM' with Gradle 3.0
 *
 * @author zjay, @date 12/26/16 3:41 PM
 */
public class AppleTest {
    @Test
    public void testApple() {
        Apple apple = new Apple(12, "green");
        assertEquals((int)apple.getWeight(), 12);
        assertTrue(apple.getColor().equals("green"));
    }

    List<Apple> inventory = Arrays.asList(
            new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(102, "red"),
            new Apple(83, "yellow"),
            new Apple(130, "red"));

    @Test
    public void testFilter() {
        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples);
    }

    private List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> res = new ArrayList<>();
        for (Apple ap : inventory) {
            if (p.test(ap)) {
                res.add(ap);
            }
        }
        return res;
    }

    @Test
    public void testRunnable() throws Exception {
        Runnable r = () -> System.out.println("Hi Jay");
        r.run();
    }

    private String processFile(Function<BufferedReader, String> p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            return p.apply(br);
        }
    }

    @Test
    public void testReadFile() throws IOException {
        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);
    }
}
