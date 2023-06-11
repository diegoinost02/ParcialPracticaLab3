package org.example.Repositorios;

import java.util.ArrayList;
/**
 * Interfaz para un CRUD de repositorios.
 *
 * @param <T> el tipo de objeto que se almacena en el repositorio.
 */
public interface IRepository <T>{
    void cargar();
    void guardar();
    ArrayList<T> listar();
    void agregar(T...objeto);
    void eliminar(T objeto);
    void modificar(T objeto);
}
