package org.example.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Modelos.Remis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Repositorio para gestionar los remises, utilizando un archivo JSON como fuente de datos.
 */

public class RemisRepo implements IRepository<Remis> {
    private final File pathJson = new File("src/main/java/org/example/Archivos/remises.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Remis> remises;

    public RemisRepo() {
    }
    /**
     * Lee el archivo JSON de remises y carga los datos en la lista de remises.
     */
    @Override
    public void cargar(){
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class,Remis.class);
            this.remises = mapper.readValue(pathJson,collectionType);
        }catch (IOException e){
            this.remises = new ArrayList<>();
        }
    }
    /**
     * Escribe los datos de la lista de remises en un archivo JSON.
     */
    @Override
    public void guardar(){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(pathJson,this.remises);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * Retorna la lista de remises cargada desde el archivo JSON.
     * @return la lista cargada desde el archivo JSON.
     */
    @Override
    public ArrayList<Remis> listar(){
        cargar();
        return this.remises;
    }
    /**
     * Agrega un remis a la lista de remises y escribe la lista actualizada en un archivo JSON.
     * @param remis remis a agregar a la lista de remises.
     */
    @Override
    public void agregar(Remis...remis){
        cargar();
        this.remises.addAll(Arrays.asList(remis));
        guardar();
    }
    /**
     * Elimina un remis de la lista de remises y escribe la lista actualizada en un archivo JSON.
     * @param remis remis a eliminar de la lista de remises.
     */
    @Override
    public void eliminar(Remis remis){
        cargar();
        this.remises.remove(remis);
        guardar();
    }
    /**
     * Modifica un remis de la lista de remises y escribe la lista actualizada en un archivo JSON.
     * @param remis remis a modificar de la lista de taxis.
     */
    @Override
    public void modificar(Remis remis){
        cargar();
        for (Remis r : this.remises){
            if(r.equals(remis)){
                int index = remises.indexOf(r);
                remises.set(index,remis);
                break;
            }
        }
        guardar();
    }
    /**
     * Verifica si el remis existe en la lista de remises
     * @param remis remis a verificar
     * @return retorna true si el remis existe en la lista, retorna false en caso contrario
     */
    public boolean existe(Remis remis){
        cargar();
        if(this.remises.contains(remis)){
            return true;
        }
        else{
            return false;
        }
    }
}
