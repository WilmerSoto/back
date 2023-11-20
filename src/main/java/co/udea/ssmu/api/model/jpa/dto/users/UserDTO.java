package co.udea.ssmu.api.model.jpa.dto.users;

import co.udea.ssmu.api.model.jpa.dto.groups.GroupDTO;
import co.udea.ssmu.api.model.jpa.dto.userTypes.UserTypeDTO;

public class UserDTO {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String password;
    private String nroDocumento;
    private String rol;
    private String nroServicios;
    private GroupDTO grupo;
    private UserTypeDTO tipoUsuario;

    public GroupDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GroupDTO grupo) {
        this.grupo = grupo;
    }

    public UserTypeDTO getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UserTypeDTO tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNroServicios() {
        return nroServicios;
    }

    public void setNroServicios(String nroServicios) {
        this.nroServicios = nroServicios;
    }


}
