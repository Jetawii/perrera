/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perrera;

/**
 *
 * @author ycoz
 */
public class Gato extends Mascota implements Tarifable{
    
     // ATRIBUTOS
    private int clase_g;
    
    // CONSTANTE
    private final int CUOTA_GATO = 15;
    
    // CONTRUCTOR
    public Gato() {
        super();
        this.clase_g = 0;
    }
    public Gato(int clase_g, Propietario dueno, String identificador) {
        super(dueno, identificador);
        this.clase_g = clase_g;
    }
    // MÉTODO GET && SET
    // GET
    public int getClase_g() {
        return clase_g;
    }
    // SET
    public void setClase_g(int clase_g) {
        this.clase_g = clase_g;
    }
    
    
    // MÉTODO COMPROBAR CLASE 
    public static boolean validarClase (int numero) {
        boolean validado = false;
        // COMPROBAMOS QUE EL VALOR INTRODUCIO POR TECLADO 
        // ES UN NÚMERO DEL 1 AL 4. 
        if (numero<=3 && numero>=1) {
            validado = true;
        }
        return validado;
    }
    
    // MÉTODO CALCULAR CUOTA
    @Override
    public int calcularCuota () {
        return super.calcularCuota()+(this.clase_g*CUOTA_GATO);
    }
    
    // MÉTODO MOSTRAR MASCOTA
    @Override
    public void mostrarMascota () {
        super.mostrarMascota();
        System.out.println("Clase del gato: " +this.getClase_g()+"Cuota: "+calcularCuota());
    }
    
    
    
}
