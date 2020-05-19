package com.uca.capas.app.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(schema = "public", name = "estudiante")
public class Estudiante {
    @Id
    @Column(name = "c_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(name = "nombre")
    @NotNull (message="El campo no puede estar vacio")
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    private String nombre;
    
    @Column(name = "apellido")
    @NotEmpty(message = "El campo Apellido no debe estar vacio")
    private String apellido;
    
    @Column(name = "carne")
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    private String carne;
    
    @Column(name = "carrera")
    @NotEmpty(message = "El campo carrera no debe estar vacio")
    private String carrera;
    
    public Estudiante(){}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
