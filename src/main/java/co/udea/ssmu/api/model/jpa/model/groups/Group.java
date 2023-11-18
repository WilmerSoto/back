package co.udea.ssmu.api.model.jpa.model.groups;
import co.udea.ssmu.api.model.jpa.model.users.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "id_usuario_dueno")
    private Integer idUsuarioDueno;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "descripcion", length = 20)
    private String descripcion;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<User> user;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdUsuarioDueno() {
        return idUsuarioDueno;
    }

    public void setIdUsuarioDueno(Integer idUsuarioDueno) {
        this.idUsuarioDueno = idUsuarioDueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
