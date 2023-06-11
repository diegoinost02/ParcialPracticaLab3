package org.example.Modelos;

import java.io.Serializable;

public class Remis extends Vehiculo implements Serializable {
    private int tarifaCuadra;

    public Remis(String marca, String modelo, String tipoCombustible, String patente, int tarifaCuadra) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.patente = patente;
        this.tarifaCuadra = tarifaCuadra;
    }

    public Remis() {
    }

    public int getTarifaCuadra() {
        return tarifaCuadra;
    }

    public void setTarifaCuadra(int tarifaCuadra) {
        this.tarifaCuadra = tarifaCuadra;
    }

    @Override
    public String toString() {
        return "Remis{" +
                "tarifaCuadra=" + tarifaCuadra +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", patente='" + patente + '\'' +
                '}';
    }
}
