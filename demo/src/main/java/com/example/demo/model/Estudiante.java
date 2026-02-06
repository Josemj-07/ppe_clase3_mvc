package com.example.demo.model;

import lombok.Getter;

public class Estudiante {
    private final @Getter  long id;
    private final  @Getter String nombre;
    private  @Getter String carrera;

    public Estudiante(long id, String nombre, String carrera) {
        if(id < 0 || nombre == null) {
            throw new IllegalArgumentException("No se han ingresado suficientes parámetros");
        }

        this.carrera = carrera;
        this.nombre = nombre;
        this.id = id;
    }

    public Estudiante setCarrera(String nuevaCarrera) {
        if(nuevaCarrera == null) {
            throw new IllegalArgumentException("No se ha ingresado una nueva carrera");
        }
        this.carrera = nuevaCarrera;
        return this;
    }

}