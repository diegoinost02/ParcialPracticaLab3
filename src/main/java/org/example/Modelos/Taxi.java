package org.example.Modelos;

import java.io.Serializable;

public class Taxi extends Vehiculo implements Serializable {
    private int bajadaBandera;
    private int precioKilometro;

    public Taxi(String marca, String modelo, String tipoCombustible, String patente, int bajadaBandera, int precioKilometro) {
        super(marca, modelo, tipoCombustible, patente);
        this.bajadaBandera = bajadaBandera;
        this.precioKilometro = precioKilometro;
    }

    public Taxi() {
    }

    public int getBajadaBandera() {
        return bajadaBandera;
    }

    public void setBajadaBandera(int bajadaBandera) {
        this.bajadaBandera = bajadaBandera;
    }

    public int getPrecioKilometro() {
        return precioKilometro;
    }

    public void setPrecioKilometro(int precioKilometro) {
        this.precioKilometro = precioKilometro;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "precioKilometro=" + precioKilometro +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                ", patente='" + patente + '\'' +
                '}';
    }
}
