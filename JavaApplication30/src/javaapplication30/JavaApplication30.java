package javaapplication30;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucia
 * @version 1.0
 */
public class JavaApplication30 {

    /**
     * @param args the command line arguments 
     * se crea el ArrayList de Personas
     */
   
    static ArrayList<Persona> personas = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        leerPersonas();
        if (numeroDePersonas() > 0) {
            //se muestran todas las personas introducidas
            System.out.println("\nPersonas introducidas: ");
            mostrar();
            //se muestra la persona de mayor edad
            System.out.println("\nPersona de mayor edad: ");
            System.out.println(personaMayorEdad());

            //se muestra el número de personas mayores de edad
            System.out.println("\nNúmero de personas mayores de edad : "
                    + personasMayoresDeEdad());
        }
    }

    /**
    * Método que lee los datos de cada persona y las añade al ArrayList personas
    
    */
    public static void leerPersonas() {

        String nombre, direccion, ciudad;
        Fecha fecha;
        Persona p;
        int codigoPostal, N, i, dia, mes, año;

        do {
            System.out.print("Número de personas? ");
            N = sc.nextInt();
        } while (N < 0);
        sc.nextLine();

        for (i = 1; i <= N; i++) {
            System.out.println("Persona " + i);
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
            do {
                System.out.println("Fecha de Nacimiento: ");
                System.out.print("Dia: ");
                dia = sc.nextInt();
                System.out.print("Mes: ");
                mes = sc.nextInt();
                System.out.print("Año: ");
                año = sc.nextInt();
                fecha = new Fecha(dia, mes, año);
            } while (!fecha.fechaCorrecta());

            sc.nextLine();
            System.out.print("Dirección: ");
            direccion = sc.nextLine();
            System.out.print("Codigo Postal: ");
            codigoPostal = sc.nextInt();
            sc.nextLine();
            System.out.print("Ciudad: ");
            ciudad = sc.nextLine();

            //se crea una nueva instancia de Persona
            p = new Persona();
            p.setNombre(nombre);
            p.setFechaNacimiento(fecha);
            p.setDireccion(direccion);
            p.setCodigoPostal(codigoPostal);
            p.setCiudad(ciudad);

            //se añade el objeto al array
            personas.add(p);
        }
    }

    /**
    * Método para mostrar todas las personas
    
    */
    public static void mostrar() {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i));
        }
    }

    /**
    * Devuelve el número de personas que contiene el array
    
    */
    public static int numeroDePersonas() {
        return personas.size();
    }

    /**
    * Devuelve la persona de mayor edad
    * En este método se utiliza el método esMayorQue() añadido a la clase Fecha
    * @return aux
    
    */
    public static Persona personaMayorEdad() {
        Persona aux = personas.get(0);
        for (int i = 1; i < personas.size(); i++) {
            if (personas.get(i).getFechaNacimiento().esMayorQue(aux.getFechaNacimiento())) {
                aux = personas.get(i);
            }
        }
        return aux;
    }


    /**
    * Calcula y devuelve el número de personas mayores de edad
    * return cont
    
    */
    public static int personasMayoresDeEdad() {
        int cont = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).esMayorDeEdad()) {
                cont++;
            }
        }
        return cont;
    }
}
