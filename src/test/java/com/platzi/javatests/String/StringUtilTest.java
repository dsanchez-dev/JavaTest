package com.platzi.javatests.String;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    //Método trim()
    //El método trim() de la clase String en Java se utiliza para eliminar los espacios iniciales y finales de una cadena.
    //Este método devuelve una nueva cadena que elimina los espacios iniciales y finales de la cadena original.
    public static boolean isEmpty(String str){
        return str == null || str.trim().isEmpty();
        //str.trim().isEmpty(); //sirve para quitar los espacios en blanco. La línea de código completa es: return str == null || str.trim().isEmpty();
        // str.trim().length() <= 0;  //sirve para quitar los espacios en blanco y contar la longitud de la cadena. La línea de código completa es: return str == null || str.trim().length() <= 0;
    }

    //1: Probar qie im string cualquiera no es vació
    @Test
    public void string_is_not_empty(){
        assertFalse(isEmpty("hola"));
    }

    //2: Probar que "" es un string vació
    @Test
    public void empty_string_is_empty(){
        assertTrue(isEmpty(""));
    }
    //3: Probar que null también es un string vació
    @Test
    public void null_is_empty(){
        assertTrue(isEmpty(null));
    }
    //4: Un string con espacios (" ") también se considera vacío (pista: puedes usar la función trim() de Java
    @Test
    public void string_with_spaces_is_empty(){
        assertTrue(isEmpty(" "));
    }
}