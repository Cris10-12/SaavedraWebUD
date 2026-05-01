package co.edu.udistrital.Modelo;

// Autor: Cristian David Peña Saavedra

import java.io.Serializable;

public class AspiranteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String identificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String programaAcademico;

    public AspiranteDTO() {
    }

    public AspiranteDTO(String identificacion, String nombres, String apellidos,
                        String correo, String telefono, String programaAcademico) {
        this.identificacion   = identificacion;
        this.nombres          = nombres;
        this.apellidos        = apellidos;
        this.correo           = correo;
        this.telefono         = telefono;
        this.programaAcademico = programaAcademico;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public String toString() {
        return "AspiranteDTO [identificacion=" + identificacion
                + ", nombres=" + nombres
                + ", apellidos=" + apellidos
                + ", correo=" + correo
                + ", telefono=" + telefono
                + ", programaAcademico=" + programaAcademico + "]";
    }
}