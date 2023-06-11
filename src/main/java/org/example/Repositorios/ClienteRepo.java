package org.example.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Modelos.Cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Repositorio para gestionar los clientes, utilizando un archivo JSON como fuente de datos.
 */

public class ClienteRepo implements IRepository<Cliente> {
    private final File pathJson = new File("src/main/java/org/example/Archivos/clientes.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Cliente> clientes;

    public ClienteRepo() {
    }
    /**
     * Lee el archivo JSON de clientes y carga los datos en la lista de clientes.
     */
    @Override
    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class,Cliente.class);
            this.clientes = mapper.readValue(pathJson,collectionType);
        }catch (IOException e){
            this.clientes = new ArrayList<>();
        }
    }
    /**
     * Escribe los datos de la lista de clientes en un archivo JSON.
     */
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(pathJson,this.clientes);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * Retorna la lista de clientes cargada desde el archivo JSON.
     * @return la lista cargada desde el archivo JSON.
     */
    @Override
    public ArrayList<Cliente> listar() {
        cargar();
        return this.clientes;
    }
    /**
     * Agrega un cliente a la lista de clientes y escribe la lista actualizada en un archivo JSON.
     * @param cliente cliente a agregar a la lista de clientes.
     */
    @Override
    public void agregar(Cliente... cliente) {
        cargar();
        this.clientes.addAll(Arrays.asList(cliente));
        guardar();
    }
    /**
     * Elimina un cliente de la lista de clientes y escribe la lista actualizada en un archivo JSON.
     * @param cliente cliente a eliminar de la lista de clientes.
     */
    @Override
    public void eliminar(Cliente cliente) {
        cargar();
        this.clientes.remove(cliente);
        guardar();
    }
    /**
     * Modifica un cliente de la lista de clientes y escribe la lista actualizada en un archivo JSON.
     * @param cliente cliente a modificar de la lista de clientes.
     */
    @Override
    public void modificar(Cliente cliente) {
        cargar();
        for (Cliente c : this.clientes){
            if(c.equals(cliente)){
                int index = clientes.indexOf(c);
                clientes.set(index,cliente);
                break;
            }
        }
        guardar();
    }
    /**
     * Verifica si el cliente existe en la lista de clientes.
     * @param cliente cliente a verificar.
     * @return retorna true si el cliente existe en la lista, retorna false en caso contrario.
     */
    public boolean existe(Cliente cliente){
        cargar();
        if(this.clientes.contains(cliente)){
            return true;
        }
        else{
            return false;
        }
    }
}
