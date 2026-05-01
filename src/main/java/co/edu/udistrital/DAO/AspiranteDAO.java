package co.edu.udistrital.DAO;

// Autor: Cristian David Peña Saavedra

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.udistrital.Modelo.AspiranteDTO;

public class AspiranteDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final List<AspiranteDTO> ASPIRANTES = new ArrayList<>();

    public void guardarAspirante(AspiranteDTO aspirante) {
        ASPIRANTES.add(aspirante);
    }

    public List<AspiranteDTO> obtenerAspirantes() {
        return ASPIRANTES;
    }

    public boolean existeIdentificacion(String identificacion) {
        for (AspiranteDTO a : ASPIRANTES) {
            if (a.getIdentificacion().equalsIgnoreCase(identificacion.trim())) {
                return true;
            }
        }
        return false;
    }

    public int contarAspirantes() {
        return ASPIRANTES.size();
    }
}