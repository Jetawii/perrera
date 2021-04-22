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
public abstract class Mascota implements Tarifable, Serializable  {
    
    // ATRIBUTOS
    Propietario dueno;
    private String identificador;
    
    // CONSTANTES
    private int CUOTA_BASE = 350;
    private String ABECEDARIO="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    
    // CONSTRUCTOR
    // CONSTRUCTOR VACÍO
    public Mascota() {
        dueno = new Propietario();
        this.identificador = "";
    }
    // CONSTRUCTOR CON LA INFO
    public Mascota(Propietario dueno, String identificador) {
        this.dueno = dueno;
        this.identificador = identificador;
    }
    
    // MÉTODOS GET && SET
    // GET
    public Propietario getDueno() {
        return dueno;
    }

    public String getIdentificador() {
        return identificador;
    }

    // SET
    public void setDueno(Propietario dueno) {
        this.dueno = dueno;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    // MÉTODO CALCULAR CUOTA
    @Override
    public int calcularCuota () {
        return CUOTA_BASE;
    }
    
    // MÉTODO MOSTRAR MASCOTA
    public void mostrarMascota () {
        System.out.println("Propietario. Nombre: " +this.dueno.getNombre()+". Apellidos: "+this.dueno.getApellidos()+". DNI: "+this.dueno.getDni());
        System.out.println("Identificador: " +this.identificador);
    }
    
    // MÉTODO VALIDAR IDENTIFICADOR
    public static boolean validarIdentificador (String identificador) {
        boolean validado = false;
        // Hacemos una expresión regular 
        if (identificador.matches("^\\d{5}-[A-Z]{2,6}")) {
            validado = true;
        }
        return validado;
    }

}
