package org.example.Repositorios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Modelos.Taxi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Repositorio para gestionar los taxis, utilizando un archivo JSON como fuente de datos.
 */

public class TaxiRepo implements IRepository<Taxi>{
    private final File pathJson = new File("src/main/java/org/example/Archivos/taxis.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Taxi> taxis;

    public TaxiRepo() {
    }

    /**
     * Lee el archivo JSON de taxis y carga los datos en la lista de taxis.
     */
    @Override
    public void cargar(){
        try{
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class,Taxi.class);
            this.taxis = mapper.readValue(pathJson,collectionType);
        }catch (IOException e){
            this.taxis = new ArrayList<>();
        }
    }

    /**
     * Escribe los datos de la lista de taxis en un archivo JSON.
     */
    @Override
    public void guardar(){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(pathJson,this.taxis);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Retorna la lista de taxis cargada desde el archivo JSON.
     * @return la lista cargada desde el archivo JSON.
     */
    @Override
    public ArrayList<Taxi> listar(){
        cargar();
        return this.taxis;
    }

    /**
     * Agrega un taxi a la lista de taxis y escribe la lista actualizada en un archivo JSON.
     * @param taxi taxi a agregar a la lista de taxis.
     */
    @Override
    public void agregar(Taxi... taxi){
        cargar();
        this.taxis.addAll(Arrays.asList(taxi));
        guardar();
    }

    /**
     * Elimina un taxi de la lista de taxis y escribe la lista actualizada en un archivo JSON.
     * @param taxi taxi a eliminar de la lista de taxis.
     */
    @Override
    public void eliminar(Taxi taxi){
        cargar();
        this.taxis.remove(taxi);
        guardar();
    }

    /**
     * Modifica un taxi de la lista de taxis y escribe la lista actualizada en un archivo JSON.
     * @param taxi taxi a modificar de la lista de taxis.
     */
    @Override
    public void modificar(Taxi taxi){
        cargar();
        for (Taxi t : this.taxis){
            if(t.equals(taxi)){
                int index = taxis.indexOf(t);
                taxis.set(index,taxi);
                break;
            }
        }
        guardar();
    }

    /**
     * Verifica si el taxi existe en la lista de taxis.
     * @param taxi taxi a verificar.
     * @return retorna true si el taxi existe en la lista, retorna false en caso contrario.
     */
    public boolean existe(Taxi taxi){
        cargar();
        if(this.taxis.contains(taxi)){
            return true;
        }else{
            return false;
        }
    }
}
