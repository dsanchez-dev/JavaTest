package com.platzi.javatests.fizzbuzz;

public class FizzBuzz {
    public static String fizzBuzz(int n){

        if(n%3==0 && n%5==0){ //si el numero es divisible por 3 y 5 retorna "FizzBuzz"
            return "FizzBuzz";
        }else if(n%3==0){//Si el numero es divisible por 3 retorna "Fizz"
            return "Fizz";
        } else if(n%5==0){ //si el numero es divisible por 5 retorna "Buzz"
            return "Buzz";
        }else{
            return String.valueOf(n); //si no es divisible por 3 ni por 5 retorna el mismo numero
        }
    }
}
