package com.platzi.javatests.util;

public class PasswordUtil {

    //en el método enum se definen los niveles de seguridad de la contraseña
    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    //en el método assessPassword se evalúa la contraseña y se le asigna un nivel de seguridad
    public static SecurityLevel assessPassword(String password) {
        if(password.length() < 8) {
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z0-9]+")) {
            return SecurityLevel.MEDIUM;
        }

    return SecurityLevel.STRONG;
    }

}
