/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perrera;

import java.io.Serializable;

/**
 *
 * @author ycoz
 */
public class Propietario implements Serializable{

    // ATRIBUTOS
    private String nombre;
    private String apellidos;
    private String dni;

    // CONSTANTES 
    private static String POSIBLES_LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static int NUMEROS_DNI = 23;

    // CONSTRUCTORES 
    // CONSTRUCTOR VACÍO
    public Propietario() {
        this.nombre = "";
        this.apellidos = "";
        this.dni = "";
    }

    // CONSRUCTOR CON LA INFO 
    public Propietario(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    // MÉTODOS GET & SET
    // GET
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    // SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // MÉTODO VALIDAR DNI
    public static boolean validarDNI(String dni) {
        boolean validado = false;
        // Hacemos una expresión regular 
        if (dni.matches("^\\d{8}[A-Z]{1}")) {
            // Aislamos la letra del dni introducida por teclado
            String letra_dni = dni.substring(8);
            // Calculamos la letra que le correspondería en realidad. 
            String letra = "";
            String int_dni_String = dni.substring(0, 8);
            int int_dni = Integer.parseInt(int_dni_String);
            int resto = int_dni % NUMEROS_DNI;
            letra += POSIBLES_LETRAS.charAt(resto);
            // el String letra contiene la letra que nos correspondería
            // comprobamos si coinciden
            if (letra_dni.equalsIgnoreCase(letra)) {
                validado = true;
            }
        }
        return validado;
    }
    
    // MÉTODO PARA VALIDAR NOMBRE Y APELLIDO
    public static boolean validarNombre(String apellido) {
        boolean validado = false;
        // Hacemos una expresión regular 
        if (apellido.matches("[A-Z]{1}[a-z]{0,16}")) {
                validado = true;
        }
        return validado;
    }

}
