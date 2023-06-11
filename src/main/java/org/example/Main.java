package org.example;

import org.example.Servicios.GestionCliente;
import org.example.Servicios.GestionRemis;
import org.example.Servicios.GestionTaxi;

import java.util.Scanner;

/**
 * @author diegoinost_
 * @Version 1.0
 */
public class Main {
    /**
     * Método que inicia el programa.
     * Crea un objeto Scanner e invoca el menu principal, el scanner se cerrara al finalizar el programa.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuPrincipal(scanner);
        scanner.close();
    }

    /**
     * Muestra el menu principal.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public static void menuPrincipal(Scanner scanner) {
        String seguir = "s";
        int opcion = 0;

        while (seguir.equalsIgnoreCase("s")) {

            System.out.println("Ingrese lo que desea hacer:\n" +
                    "1: Ver menu clientes\n" +
                    "2: Ver menu remises\n" +
                    "3: Ver menu taxis\n" +
                    "4: Salir");
            try {
                opcion = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Caracter invalido, debe ingresar un numero");
                scanner.nextLine();
            }

            switch (opcion) {
                case 1:
                    menuClientes(scanner);
                    break;
                case 2:
                    menuRemises(scanner);
                    break;
                case 3:
                    menuTaxis(scanner);
                    break;
                case 4:
                    seguir = "n";
                    break;
                default:
                    System.out.println("el numero no es valido");
                    break;
            }

            if (!seguir.equalsIgnoreCase("n")) {
                System.out.println("¿Desea volver al menu? s/n");
                seguir = scanner.next();
            }
        }
    }

    /**
     * Muestra el menu de clientes.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public static void menuClientes(Scanner scanner) {

        GestionCliente gestionCliente = new GestionCliente();

        String seguir = "s";
        int opcion = 0;

        while (seguir.equalsIgnoreCase("s")) {

            System.out.println("Ingrese lo que desea hacer:\n" +
                    "1: Ver clientes\n" +
                    "2: Agregar cliente\n" +
                    "3: Eliminar cliente\n" +
                    "4: Volver");
            try {
                opcion = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Caracter invalido, debe ingresar un numero");
                scanner.nextLine();
            }
            switch (opcion) {
                case 1:
                    gestionCliente.listar();
                    break;
                case 2:
                    gestionCliente.agregar(scanner);
                    break;
                case 3:
                    gestionCliente.eliminar(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("El numero que ingreso no es valido");
                    break;
            }
        }
    }

    /**
     * Muestra el menu de remises.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public static void menuRemises(Scanner scanner) {

        GestionRemis gestionRemis = new GestionRemis();

        String seguir = "s";
        int opcion = 0;

        while (seguir.equalsIgnoreCase("s")) {

            System.out.println("Ingrese lo que desea hacer:\n" +
                    "1: Ver remises\n" +
                    "2: Agregar remis\n" +
                    "3: Eliminar remis\n" +
                    "4: Modificar remis\n" +
                    "5: Volver");
            try {
                opcion = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Caracter invalido, debe ingresar un numero");
                scanner.nextLine();
            }
            switch (opcion) {
                case 1:
                    gestionRemis.listar();
                    break;
                case 2:
                    gestionRemis.agregar(scanner);
                    break;
                case 3:
                    gestionRemis.eliminar(scanner);
                    break;
                case 4:
                    gestionRemis.modificar(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("El numero que ingreso no es valido");
                    break;
            }
        }
    }

    /**
     * Muestra el menu de taxis.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public static void menuTaxis(Scanner scanner) {

        GestionTaxi gestionTaxi = new GestionTaxi();

        String seguir = "s";
        int opcion = 0;

        while (seguir.equalsIgnoreCase("s")) {

            System.out.println("Ingrese lo que desea hacer:\n" +
                    "1: Ver taxis\n" +
                    "2: Agregar taxi\n" +
                    "3: Eliminar taxi\n" +
                    "4: Modificar taxi\n" +
                    "5: Volver");
            try {
                opcion = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Caracter invalido, debe ingresar un numero");
                scanner.nextLine();
            }
            switch (opcion) {
                case 1:
                    gestionTaxi.listar();
                    break;
                case 2:
                    gestionTaxi.agregar(scanner);
                    break;
                case 3:
                    gestionTaxi.eliminar(scanner);
                    break;
                case 4:
                    gestionTaxi.modificar(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("El numero que ingreso no es valido");
                    break;
            }
        }
    }
}