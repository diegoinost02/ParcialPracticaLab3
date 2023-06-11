package org.example.Servicios;

import org.example.Modelos.Taxi;
import org.example.Repositorios.TaxiRepo;

import java.util.Scanner;
/**
 * Gestiona la lista de taxis utilizando los metodos de su clase repositorio.
 */
public class GestionTaxi {
    TaxiRepo taxiRepo = new TaxiRepo();

    public GestionTaxi(){}

    /**
     * Muestra la lista de los taxis.
     */
    public void listar(){
        taxiRepo.listar().forEach(System.out::println);
    }

    /**
     * Agrega un vehiculo a la lista de taxis.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public void agregar(Scanner scanner){

        Taxi taxi = new Taxi();
        String seguir = "s";
        boolean entradaValida = false;

        while(seguir.equalsIgnoreCase("s")){

            System.out.println("Ingrese la marca del vehiculo");
            taxi.setMarca(scanner.next());

            System.out.println("Ingrese el modelo del vehiculo");
            taxi.setModelo(scanner.next());

            System.out.println("Ingrese el tipo de combustible");
            taxi.setTipoCombustible(scanner.next());

            System.out.println("Ingrese la petente");
            taxi.setPatente(scanner.next());
            
            System.out.println("Ingrese el precio de la bajada de bandera");
            while (!entradaValida) {
                try {
                    taxi.setBajadaBandera(scanner.nextInt());
                    entradaValida = true;
                } catch (RuntimeException e) {
                    System.out.println("Error, usted debe ingresar un numero. Intentelo nuevamente");
                    scanner.nextLine();
                }
            }
            entradaValida = false;

            System.out.println("Ingrese el precio por kilometro");
            while (!entradaValida) {
                try {
                    taxi.setPrecioKilometro(scanner.nextInt());
                    entradaValida = true;
                } catch (RuntimeException e) {
                    System.out.println("Error, usted debe ingresar un numero. Intentelo nuevamente");
                    scanner.nextLine();
                }
            }

            if(taxiRepo.existe(taxi)){
                System.out.println("Error al agregar, la patente que ingresaste no esta disponible");
            }else{
                taxiRepo.agregar(taxi);
                System.out.println("El nuevo taxi se ha agregado correctamente");
            }

            System.out.println("¿Desea agregar otro taxi? s/n");
            seguir = scanner.next();
        }
    }

    /**
     * Elimina un taxi de la lista de taxis.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public void eliminar(Scanner scanner){

        Taxi taxi = new Taxi();
        String seguir = "s";

        while (seguir.equalsIgnoreCase("s")){
            System.out.println("Ingrese la patente del taxi que desea eliminar");
            taxi.setPatente(scanner.next());

            if(!taxiRepo.existe(taxi)){
                System.out.println("Error al eliminar, la patente que ingresaste no pertenece a ningun taxi");
            }else{
                taxiRepo.eliminar(taxi);
                System.out.println("El taxi se elimino correctamente");
            }

            System.out.println("¿Desea eliminar otro taxi? s/n");
            seguir = scanner.next();
        }
    }

    /**
     * Modifica un taxi de la lista de taxis.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public void modificar(Scanner scanner) {

        Taxi taxi = new Taxi();
        String seguir = "s";
        boolean entradaValida = false;

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("Ingrese la patente del taxi que desea modificar");
            taxi.setPatente(scanner.next());

            if(!taxiRepo.existe(taxi)){
                System.out.println("Error, la patente que ingresaste no pertenece a ningun taxi");
            }else{
                System.out.println("Ingrese la marca del vehiculo");
                taxi.setMarca(scanner.next());

                System.out.println("Ingrese el modelo del vehiculo");
                taxi.setModelo(scanner.next());

                System.out.println("Ingrese el tipo de combustible");
                taxi.setTipoCombustible(scanner.next());

                System.out.println("Ingrese el precio de la bajada de bandera");
                while (!entradaValida) {
                    try {
                        taxi.setBajadaBandera(scanner.nextInt());
                        entradaValida = true;
                    } catch (RuntimeException e) {
                        System.out.println("Error, usted debe ingresar un numero. Intentelo nuevamente");
                        scanner.nextLine();
                    }
                }
                entradaValida = false;

                System.out.println("Ingrese el precio por kilometro");
                while (!entradaValida) {
                    try {
                        taxi.setPrecioKilometro(scanner.nextInt());
                        entradaValida = true;
                    } catch (RuntimeException e) {
                        System.out.println("Error, usted debe ingresar un numero. Intentelo nuevamente");
                        scanner.nextLine();
                    }
                }

                taxiRepo.modificar(taxi);
                System.out.println("El taxi se modifico correctamente");
            }

            System.out.println("¿Desea modificar otro taxi? s/n");
            seguir = scanner.next();
        }
    }
}
