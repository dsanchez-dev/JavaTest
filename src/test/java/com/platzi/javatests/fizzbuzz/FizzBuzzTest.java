package com.platzi.javatests.fizzbuzz;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {
    // Test 1: Si el número es divisible por 3, debe retornar "Fizz"
    @Test
    public void if_number_is_divisible_between_3_return_fizz(){
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
    }

    // Test 2: Si el número es divisible por 5, debe retornar "Buzz"
    @Test
    public void if_number_is_divisible_between_5_return_buzz(){
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
    }

    // Test 3: Si el número es divisible por 3 y 5, debe retornar "FizzBuzz"
    @Test
    public void if_number_is_divisible_between_3_and_5_return_fizzbuzz(){
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }
    // Test 4: Si el número no es divisible por 3 ni por 5, debe retornar el mismo número
    @Test
    public void if_number_is_not_divisible_between_3_and_5_return_number(){
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }
}