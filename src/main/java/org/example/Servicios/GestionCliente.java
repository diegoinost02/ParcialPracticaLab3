package org.example.Servicios;

import org.example.Modelos.Cliente;
import org.example.Repositorios.ClienteRepo;

import java.util.Scanner;
/**
 * Gestiona la lista de clientes utilizando los metodos de su clase repositorio
 */
public class GestionCliente {
    ClienteRepo clienteRepo = new ClienteRepo();
    public GestionCliente() {
    }

    /**
     * Muestra la lista de clientes.
     */
    public void listar() {
        clienteRepo.listar().forEach(System.out::println);
    }

    /**
     * Agrega un cliente a la lista de clientes.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public void agregar(Scanner scanner) {

        Cliente cliente = new Cliente();
        String seguir = "s";

        while (seguir.equalsIgnoreCase("s")) {

            System.out.println("Ingrese el nombre");
            cliente.setNombre(scanner.next());

            System.out.println("Ingrese el apellido");
            cliente.setApellido(scanner.next());

            System.out.println("Ingrese el telefono");
            cliente.setTelefono(scanner.next());

            System.out.println("Ingrese la direccion");
            cliente.setDireccion(scanner.next());

            if (clienteRepo.existe(cliente)) {
                System.out.println("Error al agregar, el numero de telefono que ingresaste no esta disponible");
            } else {
                clienteRepo.agregar(cliente);
                System.out.println("El nuevo cliente se ha agregado correctamente");
            }
            System.out.println("¿Desea agregar otro cliente? s/n");
            seguir = scanner.next();
        }
    }

    /**
     * Elimina un cliente de la lista de clientes.
     * @param scanner el escáner utilizado para leer la entrada del usuario.
     */
    public void eliminar(Scanner scanner) {

        Cliente cliente = new Cliente();
        String seguir = "s";

        while (seguir.equalsIgnoreCase("s")) {

            System.out.println("Ingrese el numero de telefono del cliente que desea eliminar");
            cliente.setTelefono(scanner.next());

            if (!clienteRepo.existe(cliente)) {
                System.out.println("Error al eliminar, el numero de telefono no pertenece a ningun cliente");
            } else {
                clienteRepo.eliminar(cliente);
                System.out.println("El cliente se ha eliminado correctamente");
            }
            System.out.println("¿Desea eliminar otro cliente? s/n");
            seguir = scanner.next();
        }
    }

    /*
    public void modificar() {
    }
     */
}
