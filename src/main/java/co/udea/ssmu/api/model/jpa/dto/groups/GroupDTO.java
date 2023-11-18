package co.udea.ssmu.api.model.jpa.dto.groups;

import jakarta.persistence.Column;

public class GroupDTO {
    private Integer idGrupo;
    private Integer idUsuarioDueno;
    private String nombre;
    private String descripcion;

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
