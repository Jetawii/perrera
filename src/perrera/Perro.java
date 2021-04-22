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
public class Perro extends Mascota implements Tarifable{
    // ATRIBUTOS
    private int clase_p;
    
    // CONSTANTE
    private final int CUOTA_PERRO = 25;
    
    // CONSTRUCTOR 
    public Perro() {
        super();
        this.clase_p = 0;
    }
    public Perro(int clase_p, Propietario dueno, String identificador) {
        super(dueno, identificador);
        this.clase_p = clase_p;
    }
    
    // MÉTODO GET && SET
    // GET
    public int getClase() {
        return clase_p;
    }
    // SET
    public void setClase(int clase) {
        this.clase_p = clase;
    }
    
    // MÉTODO COMPROBAR CLASE 
    public static boolean validarClase (int numero) {
        boolean validado = false;
        // COMPROBAMOS QUE EL VALOR INTRODUCIO POR TECLADO 
        // ES UN NÚMERO DEL 1 AL 4. 
        if (numero>=1 && numero<=4) {
            validado = true;
        }
        return validado;
    }
    
    // MÉTODO CALCULAR CUOTA
    @Override
    public int calcularCuota () {
        return super.calcularCuota()+(this.clase_p*CUOTA_PERRO);
    }

    // MÉTODO MOSTRAR MASCOTA
    @Override
    public void mostrarMascota () {
        super.mostrarMascota();
        System.out.println("Clase del perro: " +this.clase_p+". Cuota: "+calcularCuota());
    }
}
