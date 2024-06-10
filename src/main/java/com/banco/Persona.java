package com.banco;

public class Persona {
    // Atributos de la clase Persona
    private String nombre;
    private String apellidos;
    private String dni;

    // Constructor que inicializa los atributos de la clase Persona
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    // Métodos getter para obtener los atributos
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    // Método para devolver la información de la persona como una cadena
    @Override
    public String toString() {
        return nombre + " " + apellidos + " (DNI: " + dni + ")";
    }
}
