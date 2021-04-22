/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perrera;

// Importamos la clase de HashMap
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ycoz
 */
public class Perrera {

    public static void main(String[] args) {
        // Creamos el HashMap y lo llamamos mapa 
        HashMap<String, Mascota> mapa = new HashMap<String, Mascota>();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        leerFichero(mapa);
        do {
            System.out.println("1. Añadir mascota.");
            System.out.println("2. Visualizar listado de mascotas.");
            System.out.println("3. Eliminar mascota.");
            System.out.println("4. Modificar info del propietario de la mascota.");
            System.out.println("5. Modificar info de la mascota.");
            System.out.println("6. Calcular ingresos.");
            System.out.println("");
            System.out.println("7. Salir.");
            System.out.print("Elige una opción: ");
            String opcion = sc.next();
            switch (opcion) {
                case "1":
                    introducirMascotas(mapa);
                    // Método escribir fichero. 
                    escribirFichero(mapa);
                    break;
                case "2":
                    mostrarMascotas(mapa);
                    break;
                case "3":
                    eliminarMascotas(mapa);
                    break;
                case "4":
                    modificarPropietario(mapa);
                    break;
                case "5":
                    modificarMascota(mapa);
                    break;
                case "6":
                    calcularIngresos(mapa);
                    break;
                case "7":
                    salir = true;
                    System.out.println("Nos vemos pronto :)");
                    break;
                default:
                    System.out.println("Solo números del 1 al 4.");
            }
        } while (!salir);
    }

    public static void introducirMascotas(HashMap mapa) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        System.out.println("Introducir datos del propietario.");
        String nombre;
        String apellido;
        do {
            System.out.println("Nombre: ");
            nombre = sc.next();
            if (!Propietario.validarNombre(nombre)) {
                System.out.println("Fomato no válido. Debes escribir tú nombre con la primera letra en mayúsculas.");
            }
        } while (!Propietario.validarNombre(nombre));
        do {
            System.out.println("Apellido: ");
            apellido = sc.next();
            if (!Propietario.validarNombre(apellido)) {
                System.out.println("Fomato no válido. Debes escribir tú apellido con la primera letra en mayúsculas.");
            }
        } while (!Propietario.validarNombre(apellido));
        // PEDIR DNI
        // Condición: dni válido.
        String dni;
        do {
            System.out.println("Dni, debe ser de 8 dígitos y una letra mayúscula. ");
            dni = sc.next();
            if (!Propietario.validarDNI(dni)) {
                System.out.println("Fomato no válido.");
            }
        } while (!Propietario.validarDNI(dni));
        Propietario dueno = new Propietario(nombre, apellido, dni);
        System.out.println("¿Qué tipo de mascota quieres introducir?");
        do {
            System.out.println("1. Perro.");
            System.out.println("2. Gato.");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    // PEDIR IDENTIFICADOR
                    // Condición:IDENTIFICADOR VÁLIDO.
                    String identificador;
                    boolean existe = true;
                    do {
                        do {
                            System.out.println("Identificador, (5)números-(2-6)letras: ");
                            identificador = sc.next();
                            Mascota.validarIdentificador(identificador);
                            if (!Mascota.validarIdentificador(identificador)) {
                                System.out.println("El identificador sera valido si consta de 5 número, un guión y 2-6 letras mayúsculas.");
                            }
                        } while (!Mascota.validarIdentificador(identificador));
                        if (mapa.containsKey(identificador)) {
                            System.out.println("El identificador corresponde a otro propietario. Introduce otro.");
                        }
                    } while (mapa.containsKey(identificador));
                    // PEDIR CLASE 
                    // Condición: clase valida.
                    int clase_p;
                    do {
                        System.out.println("Clase de perro, número entero entre el 1 y el 4: ");
                        clase_p = sc.nextInt();
                        Perro.validarClase(clase_p);
                        if (!Perro.validarClase(clase_p)) {
                            System.out.println("La clase debe ser un valor entero entre el 1 y el 4.");
                        }
                    } while (!Perro.validarClase(clase_p));
                    Perro dog = new Perro(clase_p, dueno, identificador);
                    // Introducimos la clave y el valor, en este caso identificador y objeto. Mascota (perro ó gato).
                    mapa.put(identificador, dog);
                    escribirFichero(mapa);
                    salir = true;
                    break;
                case 2:
                    // PEDIR IDENTIFICADOR
                    // Condición:IDENTIFICADOR VÁLIDO.
                    do {
                        do {
                            System.out.println("Identificador, (5)números-(2-6)letras: ");
                            identificador = sc.next();
                            Mascota.validarIdentificador(identificador);
                            if (!Mascota.validarIdentificador(identificador)) {
                                System.out.println("El identificador sera valido si consta de 5 número, un guión y 2-6 letras mayúsculas.");
                            }
                        } while (!Mascota.validarIdentificador(identificador));
                        if (mapa.containsKey(identificador)) {
                            System.out.println("El identificador corresponde a otro propietario. Introduce otro.");
                        }
                    } while (mapa.containsKey(identificador));
                    // PEDIR CLASE 
                    // Condición: clase valida.
                    int clase_g;
                    do {
                        System.out.println("Clase de gato, número entero entre el 1 y el 3: ");
                        clase_g = sc.nextInt();
                        Perro.validarClase(clase_g);
                        if (!Perro.validarClase(clase_g)) {
                            System.out.println("La clase debe ser un valor entero entre el 1 y el 3.");
                        }
                    } while (!Perro.validarClase(clase_g));
                    Gato cat = new Gato(clase_g, dueno, identificador);
                    // INTRODUCIMOS LOS DATOS EN EL ARRAY 
                    mapa.put(identificador, cat);
                    escribirFichero(mapa);
                    salir = true;
                    break;
                default:
                    System.out.println("Valores del 1 al 2.");
            }
        } while (!salir);
    }

    public static void mostrarMascotas(HashMap<String, Mascota> mapa) {
        // Como nuestro mapa esta compuesto por un identificador vinculado a un objeto 
        // para poder mostrar ese objeto debemos recorrer todos los identificadores para acceder a su objeto
        // Es un for normal donde le dices donde empieza "identificador" y su objeto asociado.
        for (String identificador : mapa.keySet()) {
            mapa.get(identificador).mostrarMascota();
        }
    }

    public static void eliminarMascotas(HashMap<String, Mascota> mapa) {
        Scanner sc = new Scanner(System.in);
        boolean eliminado = false;
        for (String identificador : mapa.keySet()) {
            mapa.get(identificador).mostrarMascota();
        }
        do {
            System.out.println("¿Qué mascota deseas eliminar? Introduce su identificador.");
            String eliminar = sc.next();
            if (!mapa.containsKey(eliminar)) {
                System.out.println("No existe ningún propietario con ese identificador.");
                eliminado = true;
            }
            if (mapa.containsKey(eliminar)) {
                mapa.remove(eliminar);
                System.out.println("Eliminado.");
                eliminado = true;
            }
        } while (!eliminado);
    }

    public static void modificarPropietario(HashMap<String, Mascota> mapa) {
        Scanner sc = new Scanner(System.in);
        boolean modificado = false;
        boolean salir = false;
        System.out.println("Introduce el identificador del propietario que deseas modificar.");
        String propietario = sc.next();
        System.out.println("¿Qué deseas modificar?: ");
        do {
            System.out.println("1. Nombre.");
            System.out.println("2. Apellido.");
            System.out.println("3. DNI.");
            System.out.println("");
            System.out.println("4. Salir.");
            String opcion = sc.next();
            switch (opcion) {
                case "1":
                    String newName;
                    // Pedimos el número del identificador para identificarlo en el mapa.
                    do {
                        for (String identificador : mapa.keySet()) {
                            // Si el identificador introducido coincide con alguno de los que se encuentra en el mapa. 
                            if (mapa.get(identificador).getIdentificador().equalsIgnoreCase(propietario)) {
                                // Pedimos el nuevo nombre que vamos a utilizar.
                                // NO saldrás del bucle hasta que introduzcas un nombre válido.
                                do {
                                    System.out.println("Nuevo nombre: ");
                                    newName = sc.next();
                                    // Comprobamos que ese nombre introducido sea válido.
                                    if (!Propietario.validarNombre(newName)) {
                                        System.out.println("Fomato no válido. Debes escribir tú nombre con la primera letra en mayúsculas.");
                                    }
                                } while (!Propietario.validarNombre(newName));
                                // cuando ese nombre es correcto pasamos a introducirlo dentro del mapa.
                                mapa.get(identificador).getDueno().setNombre(newName);
                                modificado = true;
                            }
                        }
                        if (modificado == false) {
                            System.out.println("No se encontró ningún propietario con ese identificador.");
                            modificado = true;
                        }
                    } while (!modificado);
                    System.out.println("Su nombre se modificó correctamente.");
                    break;
                case "2":
                    String newApellido;
                    // Pedimos el número del identificador para identificarlo en el mapa.
                    do {
                        for (String identificador : mapa.keySet()) {
                            // Si el identificador introducido coincide con alguno de los que se encuentra en el mapa. 
                            if (mapa.get(identificador).getIdentificador().equalsIgnoreCase(propietario)) {
                                // Pedimos el nuevo apellido que vamos a utilizar.
                                // NO saldrás del bucle hasta que introduzcas un apellido válido.
                                do {
                                    System.out.println("Nuevo apellido: ");
                                    newApellido = sc.next();
                                    // Comprobamos que ese nombre introducido sea válido.
                                    if (!Propietario.validarNombre(newApellido)) {
                                        System.out.println("Fomato no válido. Debes escribir tú apellido con la primera letra en mayúsculas.");
                                    }
                                } while (!Propietario.validarNombre(newApellido));
                                // cuando ese apellido sea correcto pasamos a introducirlo dentro del mapa.
                                mapa.get(identificador).getDueno().setApellidos(newApellido);
                                modificado = true;
                            }
                        }
                        if (modificado == false) {
                            System.out.println("No se encontró ningún propietario con ese identificador.");
                            modificado = true;
                        }
                    } while (!modificado);
                    System.out.println("Su apellido se modificó correctamente.");
                    break;
                case "3":
                    String newDNI;
                    // Pedimos el número del identificador para identificarlo en el mapa.
                    do {
                        for (String identificador : mapa.keySet()) {
                            // Si el identificador introducido coincide con alguno de los que se encuentra en el mapa. 
                            if (mapa.get(identificador).getIdentificador().equalsIgnoreCase(propietario)) {
                                // Pedimos el nuevo DNI que vamos a utilizar.
                                // NO saldrás del bucle hasta que introduzcas un DNI válido.
                                do {
                                    System.out.println("Nuevo DNI: ");
                                    newDNI = sc.next();
                                    // Comprobamos que ese DNI introducido sea válido.
                                    if (!Propietario.validarDNI(newDNI)) {
                                        System.out.println("Fomato no válido. Debe ser de 8 dígitos y una letra mayúscula.");
                                    }
                                } while (!Propietario.validarDNI(newDNI));
                                // cuando ese DNI sea correcto pasamos a introducirlo dentro del mapa.
                                mapa.get(identificador).getDueno().setDni(newDNI);
                                modificado = true;
                            }
                            if (modificado == false) {
                                System.out.println("No se encontró ningún propietario con ese identificador.");
                                modificado = true;
                            }
                        }
                    } while (!modificado);
                    System.out.println("Su DNI se modificó correctamente.");
                    break;
                case "4":
                    salir = true;
                    System.out.println("Nos vemos pronto :)");
                    break;
                default:
                    System.out.println("Solo números del 1 al 4.");
            }

        } while (!salir);

    }

    public static void modificarMascota(HashMap<String, Mascota> mapa) {
        Scanner sc = new Scanner(System.in);
        boolean modificado = false;
        boolean salir = false;
        System.out.println("Introduce el identificador de la mascota que deseas modificar.");
        String propietario = sc.next();
        System.out.println("El identificador es único y no se puede modificar.");
        do {
            System.out.println("1. Clase.");
            System.out.println("");
            System.out.println("2. Salir.");
            String opcion = sc.next();
            switch (opcion) {
                case "1":
                    String newClase;
                    // Pedimos el número del identificador para identificarlo en el mapa.
                    do {
                        for (String identificador : mapa.keySet()) {
                            // Si el identificador introducido coincide con alguno de los que se encuentra en el mapa. 
                            if (mapa.get(identificador).getIdentificador().equalsIgnoreCase(propietario)) {
                                // Pedimos la nueva clase de la mascota 
                                // Debemos tener en cuenta que las clases de gatos y perros son diferentes.
                                // NO saldrás del bucle hasta que introduzcas una clase válida.
                                if (mapa.get(identificador) instanceof Perro) {
                                    // PEDIR CLASE 
                                    // Condición: clase valida.
                                    int clase_p;
                                    do {
                                        System.out.println("Clase de perro, número entero entre el 1 y el 4: ");
                                        clase_p = sc.nextInt();
                                        Perro.validarClase(clase_p);
                                        if (!Perro.validarClase(clase_p)) {
                                            System.out.println("La clase debe ser un valor entero entre el 1 y el 4.");
                                        }
                                    } while (!Perro.validarClase(clase_p));
                                    Perro dog = (Perro) mapa.get(identificador);
                                    dog.setClase(clase_p);
                                    mapa.put(identificador, dog);
                                    modificado = true;
                                }
                                if (mapa.get(identificador) instanceof Gato) {
                                    // PEDIR CLASE 
                                    // Condición: clase valida.
                                    int clase_g;
                                    do {
                                        System.out.println("Clase de gato, número entero entre el 1 y el 3: ");
                                        clase_g = sc.nextInt();
                                        Perro.validarClase(clase_g);
                                        if (!Perro.validarClase(clase_g)) {
                                            System.out.println("La clase debe ser un valor entero entre el 1 y el 3.");
                                        }
                                    } while (!Perro.validarClase(clase_g));
                                    Gato cat = (Gato) mapa.get(identificador);
                                    cat.setClase_g(clase_g);
                                    mapa.put(identificador, cat);
                                    modificado = true;
                                }
                            }
                        }
                    } while (!modificado);
                    System.out.println("Su nombre se modificó correctamente.");
                    break;
                case "2":
                    salir = true;
                    System.out.println("Nos vemos pronto :)");
                    break;
                default:
                    System.out.println("Solo números del 1 al 4.");
            }

        } while (!salir);

    }

    public static void calcularIngresos(HashMap<String, Mascota> mapa) {
        int i_perro = 0;
        int i_gato = 0;
        int i_total = 0;
        int cuota_p;
        int cuota_g;
        for (Mascota mascota : mapa.values()) {
            if (mascota instanceof Perro) {
                i_perro = i_perro + mascota.calcularCuota();
            }
            if (mascota instanceof Gato) {
                i_gato = i_gato + mascota.calcularCuota();
            }
            i_total = i_gato + i_perro;
        }
        System.out.println("Cuota total de los perro: " + i_perro);
        System.out.println("Cuota total de los gatos: " + i_gato);
        System.out.println("Cuota total: " + i_total);
    }

    public static void escribirFichero(HashMap<String, Mascota> mapa) {
        // Primero debemos leer el fichero antes de escribir nada en él.
        // Creamos un objeto fichero
        File fichero = new File("mascotas.info");
        ObjectOutputStream s = null;
        try {
            // FileOutputStream flujo de salida para escribir info sin procesar. 
            // Para escribir secuencias de caracteres use FileWriter. 
            FileOutputStream f = new FileOutputStream(fichero);
            // ObjectOutputStream los objetos se pueden leer. 
            s = new ObjectOutputStream(f);
            s.writeObject(mapa);
            // IOException es la clase base para excepciones 
            // que se producen usando archivos, directorios o secuencias. 
        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        } finally {
            // Cerramos el fichero se haya escrito la info o no. 
            try {
                s.close();
            } catch (IOException ex2) {
                System.out.println("Mensaje de la excepción: " + ex2.getMessage());
            }
        }
    }

    public static void leerFichero(HashMap<String, Mascota> mapa) {
        File fichero= new File ("mascotas.info");
        ObjectInputStream s = null;
        try{
            FileInputStream f = new FileInputStream(fichero);
            s = new ObjectInputStream(f);
            // Creas un mapa donde se archiva la información del fichero. 
            HashMap<String, Mascota> mapInFile=(HashMap<String,Mascota>)s.readObject();
            // Imprimir toda la info del mapa
            for (String identificador : mapInFile.keySet()) {
                    mapInFile.get(identificador).mostrarMascota();
            }
        }catch (IOException e){
            System.out.println("Mensaje de la excepción: " + e.getMessage());
        } catch (ClassNotFoundException ex){
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }finally {
            // Cerramos el fichero se haya escrito la info o no. 
            try {
                s.close();
            } catch (IOException ex2) {
                System.out.println("Mensaje de la excepción: " + ex2.getMessage());
            }
        }
    }
}
