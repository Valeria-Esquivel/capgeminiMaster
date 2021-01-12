package com.capgemini.market.persistence.entity;

import javax.persistence.*;

//le dice a java que es una clase que mapea con la base de datos Entity=tabla
@Entity
//le dice el nombre especifico que tiene la tabla en la bd
@Table(name="productos")
public class Producto {
    //le dice que es un id
    @Id
    //le dice que genere el valor del id en automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //le dice el nombre especifico de la columna en la BD (no es necesario para nombres iguales en java)
    @Column(name="id_producto")
    private Integer idProducto;
    private String nombre;
    @Column(name="id_categoria")
    private Integer idCategoria;
    @Column(name="codigo_barras")
    private String codigoBarras;
    @Column(name="precio_venta")
    private Double precioVenta;
    @Column(name="cantidad_stock")
    private Integer cantidadStock;
    private  Boolean estado;
    //conexion de relaciones:  hay que poner de donde viene la relacion y en la clase de la tabla con la que se relaciona hay que poner tambien la relacion
    @ManyToOne
    @JoinColumn(name="id_categoria",insertable = false,updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;

    }


}
