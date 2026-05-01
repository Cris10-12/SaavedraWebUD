package co.edu.udistrital.DAO;

// Autor: Cristian David Peña Saavedra

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProgramaDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final List<String> PROGRAMAS = new ArrayList<>();

    static {
        PROGRAMAS.add("Ingeniería de Sistemas");
        PROGRAMAS.add("Ingeniería Industrial");
        PROGRAMAS.add("Matemática");
        PROGRAMAS.add("Administración de Empresas");
        PROGRAMAS.add("Derecho");
        PROGRAMAS.add("Ingeniería Telemática");
    }

    public List<String> obtenerProgramas() {
        return PROGRAMAS;
    }
}