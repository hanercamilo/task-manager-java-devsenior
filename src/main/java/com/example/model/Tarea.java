package com.example.model;


public class Tarea {

    private int id;
    private String descripcion;
    private boolean completada;

    public Tarea() {
    }

    public Tarea(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tarea tarea = (Tarea) o;
        return id == tarea.id;
    }

    //Utilizado para mostrar las tareas en consola
    @Override
    public String toString() {
        return "Tarea [ " +
                "id = " + id +
                ", descripción = '" + descripcion + '\'' +
                ", completada = " + completada +
                " ]";
    }
}
