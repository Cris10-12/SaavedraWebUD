package co.edu.udistrital.Controlador;

// Cristian David Peña Saavedra

import java.io.Serializable;
import java.util.List;

import co.edu.udistrital.DAO.AspiranteDAO;
import co.edu.udistrital.DAO.ProgramaDAO;
import co.edu.udistrital.Modelo.AspiranteDTO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named("aspiranteBean")      
@SessionScoped                   
public class AspiranteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AspiranteDTO aspirante = new AspiranteDTO();

    private AspiranteDAO aspiranteDAO = new AspiranteDAO();
    private ProgramaDAO  programaDAO  = new ProgramaDAO();

    public String registrarAspirante() {

        FacesContext ctx = FacesContext.getCurrentInstance();

        if (aspiranteDAO.existeIdentificacion(aspirante.getIdentificacion())) {
            ctx.addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "Error de registro",
                "Ya existe un aspirante con la identificación: " + aspirante.getIdentificacion()
            ));
            return null; 
        }

        String correo = aspirante.getCorreo();
        if (correo == null || !correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            ctx.addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "Correo inválido",
                "Por favor ingrese un correo electrónico válido."
            ));
            return null;
        }

        String telefono = aspirante.getTelefono();
        if (telefono == null || !telefono.matches("^[0-9]{7,15}$")) {
            ctx.addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "Teléfono inválido",
                "El teléfono debe contener entre 7 y 15 dígitos numéricos."
            ));
            return null;
        }

        aspiranteDAO.guardarAspirante(new AspiranteDTO(
            aspirante.getIdentificacion().trim(),
            aspirante.getNombres().trim(),
            aspirante.getApellidos().trim(),
            aspirante.getCorreo().trim(),
            aspirante.getTelefono().trim(),
            aspirante.getProgramaAcademico()
        ));

        ctx.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_INFO,
            "¡Registro exitoso!",
            "El aspirante " + aspirante.getNombres() + " fue registrado correctamente."
        ));

        limpiarFormulario();

        return "/listado.xhtml?faces-redirect=true";
    }

    public String limpiarFormulario() {
        aspirante = new AspiranteDTO();
        return null; 
    }

    public String irAFormulario() {
        limpiarFormulario(); 
        return "/index.xhtml?faces-redirect=true";
    }

    public List<AspiranteDTO> getAspirantes() {
        return aspiranteDAO.obtenerAspirantes();
    }

    public List<String> getProgramas() {
        return programaDAO.obtenerProgramas();
    }

    public int getTotalAspirantes() {
        return aspiranteDAO.contarAspirantes();
    }

    public AspiranteDTO getAspirante() {
        return aspirante;
    }

    public void setAspirante(AspiranteDTO aspirante) {
        this.aspirante = aspirante;
    }
}