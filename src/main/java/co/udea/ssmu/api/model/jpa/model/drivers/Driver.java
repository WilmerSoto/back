package co.udea.ssmu.api.model.jpa.model.drivers;

import co.udea.ssmu.api.model.jpa.model.vehicles.Vehicle;
import co.udea.ssmu.api.utils.common.StateDriverEnum;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conductor")
    private Integer idConductor;

    @Column(name = "rol", length = 10)
    private String rol;

    @Column(name = "nombre", length = 50)
    @NotNull
    private String nombre;

    @Column(name = "apellido", length = 50)
    @NotNull
    private String apellido;


    @Column(name = "celular", length = 15)
    private String celular;

    @Column(name = "email", length = 100, unique = true)
    @NotNull
    private String email;

    @Column(name = "cedula", length = 10)
    @NotNull
    private String cedula;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Direccion_Residencia", length = 120)
    private String direccionResidencia;

    @Column(name = "Contraseña", length = 70)
    @NotNull
    private String contraseña;

    @Column(name = "Fecha_Vencimiento_Licencia")
    private Date fechaVencimientoLicencia;

    @Column(name = "Genero", length = 1)
    private Character genero;

    @Column(name = "Estado_Actividad", length = 30)
    private String estadoActividad;

    @Column(name = "Calificacion")
    private Double calificacion;

    @Column(name = "Clasificacion", length = 45)
    private String clasificacion;

    @Column(name = "Strikes")
    private Integer strikes;

    @Column(name = "placa", length = 8, unique = true)
    @NotNull
    private String placa;

    @Column(name = "Marca", length = 25)
    private String marca;

    @Column(name = "Modelo", length = 25)
    private String modelo;

    @Column(name = "Descripcion", length = 245)
    private String descripcion;

    @Column(name = "Año")
    private Integer año;

    @Column(name = "Numero_Registro", length = 30)
    private String numeroRegistro;

    @Column(name = "Color", length = 20)
    private String color;

    @Column(name = "Fecha_Vencimiento_Tecno")
    private Date fechaVencimientoTecno;

    @Column(name = "Fecha_Vencimiento_Seguro")
    private Date fechaVencimientoSeguro;

    @Column(name = "Estado", length = 10)
    private String estado;

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaVencimientoLicencia() {
        return fechaVencimientoLicencia;
    }

    public void setFechaVencimientoLicencia(Date fechaVencimientoLicencia) {
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(String estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getStrikes() {
        return strikes;
    }

    public void setStrikes(Integer strikes) {
        this.strikes = strikes;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFechaVencimientoTecno() {
        return fechaVencimientoTecno;
    }

    public void setFechaVencimientoTecno(Date fechaVencimientoTecno) {
        this.fechaVencimientoTecno = fechaVencimientoTecno;
    }

    public Date getFechaVencimientoSeguro() {
        return fechaVencimientoSeguro;
    }

    public void setFechaVencimientoSeguro(Date fechaVencimientoSeguro) {
        this.fechaVencimientoSeguro = fechaVencimientoSeguro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
