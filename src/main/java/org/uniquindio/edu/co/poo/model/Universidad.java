package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private String ubicacion;
    private ArrayList<Estudiante> listaEstudiantes;

    public Universidad(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaEstudiantes = new ArrayList<>();
    }

    // ✅ GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    // ✅ REGISTRAR ESTUDIANTE
    public String registrarEstudiante(String nombre, String identificacion) {
        if (buscarEstudiante(identificacion) != null) {
            return "❌ Error: El estudiante ya está registrado.";
        }
        listaEstudiantes.add(new Estudiante(nombre, identificacion));
        return "✅ Estudiante registrado con éxito.";
    }

    // ✅ BUSCAR ESTUDIANTE (Privado)
    private Estudiante buscarEstudiante(String identificacion) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getIdentificacion().equals(identificacion)) {
                return estudiante;
            }
        }
        return null;
    }

    // ✅ AGREGAR NOTA
    public String agregarNota(String identificacion, String nombreNota, double valorNota) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante == null) {
            return "❌ Error: Estudiante no encontrado.";
        }
        estudiante.agregarNota(new Nota(nombreNota, valorNota));
        return "✅ Nota agregada exitosamente.";
    }

    // ✅ ACTUALIZAR NOTA
    public String actualizarNota(String identificacion, String nombreNota, double nuevoValorNota) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante == null) {
            return "❌ Error: Estudiante no encontrado.";
        }
        if (estudiante.actualizarNota(nombreNota, nuevoValorNota)) {
            return "✅ Nota actualizada correctamente.";
        } else {
            return "❌ Error: La nota no fue encontrada.";
        }
    }

    // ✅ CALCULAR PROMEDIO DE UN ESTUDIANTE
    public String calcularPromedioEstudiante(String identificacion) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante == null) {
            return "❌ Error: Estudiante no encontrado.";
        }
        return "📊 El promedio de " + estudiante.getNombre() + " es: " + estudiante.calcularPromedio();
    }

    @Override
    public String toString() {
        return "🏫 Universidad{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }
}


