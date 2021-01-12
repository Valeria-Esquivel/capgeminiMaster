package com.capgemini.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clientes")

public class Cliente {

        @Id
        //@GeneratedValue(strategy = GenerationType.IDENTITY)
        //@Column(name="id")
        private Integer idCliente;
        private String nombre;
        private String apellidos;
        private Integer celular;
        private String direccion;
        @Column(name="correo_electronico")
        private String correoElectronico;

        //relacion de tablas de uno a muchos:

        @OneToMany(mappedBy = "cliente")
        private List<Compra> compras;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
