package co.udea.ssmu.api.model.jpa.model.users;

import co.udea.ssmu.api.model.jpa.model.groups.Group;
import co.udea.ssmu.api.model.jpa.model.userTypes.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre", length = 50)
    @NotNull
    private String nombre;

    @Column(name = "apellido", length = 50)
    @NotNull
    private String apellido;

    @Column(name = "celular", length = 50)
    @NotNull
    private String celular;

    @Column(name = "email", unique = true, length = 50)
    @NotNull
    private String email;

    @Column(name = "password", length = 256)
    @NotNull
    private String password;

    @Column(name = "nro_documento", unique = true, length = 10)
    @NotNull
    private String nroDocumento;

    @Column(name = "rol", columnDefinition = "varchar(10) DEFAULT 'USUARIO'")
    private String rol;

    @Column(name = "nro_servicios", columnDefinition = "varchar(10) DEFAULT '0'")
    private String nroServicios;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_grupo", referencedColumnName = "id_grupo")
    private Group grupo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
    private UserType tipoUsuario;

    public Group getGrupo() {
        return grupo;
    }

    public void setGrupo(Group grupo) {
        this.grupo = grupo;
    }

    public UserType getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UserType tipoUsuario) {
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
