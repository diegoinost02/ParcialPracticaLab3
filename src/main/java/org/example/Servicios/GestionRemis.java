package org.example.Servicios;

import org.example.Modelos.Remis;
import org.example.Repositorios.RemisRepo;

import java.util.Scanner;
/**
 * Gestiona la lista de remises utilizando los metodos de su clase repositorio.
 */
public class GestionRemis {
    RemisRepo remisRepo = new RemisRepo();
    public GestionRemis() {}

    /**
     * Muestra la lista de remises.
     */
    public void listar(){
        remisRepo.listar().forEach(System.out::println);
    }

    /**
     * Agrega un remis a la lista de remises.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public void agregar(Scanner scanner){

        Remis remis = new Remis();
        String seguir = "s";
        boolean entradaValida = false;

        while (seguir.equalsIgnoreCase("s")) {

            System.out.println("Ingrese la marca del vehiculo");
            remis.setMarca(scanner.next());

            System.out.println("Ingrese el modelo del vehiculo");
            remis.setModelo(scanner.next());

            System.out.println("Ingrese el tipo de combustible");
            remis.setTipoCombustible(scanner.next());

            System.out.println("Ingrese la petente");
            remis.setPatente(scanner.next());

            System.out.println("Ingrese la tarifa por cuadra");
            while (!entradaValida) {
                try {
                    remis.setTarifaCuadra(scanner.nextInt());
                    entradaValida = true;

                } catch (RuntimeException e) {
                    System.out.println("Error, usted debe ingresar un numero. Intentelo nuevamente");
                    scanner.nextLine();
                }
            }
            if (remisRepo.existe(remis)) {
                System.out.println("Error al agregar, la patente que ingresaste no esta disponible");
            } else {
                remisRepo.agregar(remis);
                System.out.println("El nuevo remis se ha agregado correctamente");
            }

            System.out.println("Desea agregar otro remis? s/n");
            seguir = scanner.next();
        }
    }

    /**
     * Elimina un remis de la lista de remises.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public void eliminar(Scanner scanner){

        Remis remis = new Remis();
        String seguir = "s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("Ingrese la patente del remis que desea eliminar");
            remis.setPatente(scanner.next());

            if(!remisRepo.existe(remis)){
                System.out.println("Error al eliminar, la patente que ingresaste no pertenece a ningun remis");
            }else{
                remisRepo.eliminar(remis);
                System.out.println("El remis se elimino correctamente");
            }

            System.out.println("¿Desea eliminar otro remis? s/n");
            seguir = scanner.next();
        }
    }

    /**
     * Modifica un remis de la lista de remises
     * @param scanner el escáner utilizado para leer la entrada del usuario
     */
    public void modificar(Scanner scanner){

        Remis remis = new Remis();
        String seguir = "s";
        boolean entradaValida = false;

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("Ingrese la patente del remis que desea modificar");
            remis.setPatente(scanner.next());

            if(!remisRepo.existe(remis)){

                System.out.println("Error, la patente que ingresaste no pertenece a ningun remis");
            }
            else{
                System.out.println("Ingrese la marca del vehiculo");
                remis.setMarca(scanner.next());

                System.out.println("Ingrese el modelo del vehiculo");
                remis.setModelo(scanner.next());

                System.out.println("Ingrese el tipo de combustible");
                remis.setTipoCombustible(scanner.next());

                System.out.println("Ingrese la tarifa por cuadra");
                while (!entradaValida) {
                    try {
                        remis.setTarifaCuadra(scanner.nextInt());
                        entradaValida = true;

                    } catch (RuntimeException e) {
                        System.out.println("Error, usted debe ingresar un numero. Intentelo nuevamente");
                        scanner.nextLine();
                    }
                }

                remisRepo.modificar(remis);
                System.out.println("El remis se modifico correctamente");
            }

            System.out.println("¿Desea modificar otro remis? s/n");
            seguir = scanner.next();
        }
    }
}
