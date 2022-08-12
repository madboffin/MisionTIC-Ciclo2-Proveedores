/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class ProveedorClase {

    private int nit;
    private String razon_social;
    private String telefono;
    private String correo_electronico;
    private String representante;
    private String sitio_web;
    private ArrayList<String> direccion = new ArrayList<>();
    private ArrayList<ProductoClase> listaProductos = new ArrayList<>();

    public ProveedorClase() {
    }

    public ProveedorClase(int nit, String razon_social, String telefono, String correo_electronico, String representante, String sitio_web) {
        this.nit = nit;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.representante = representante;
        this.sitio_web = sitio_web;
    }

    public ProveedorClase(int nit, String razon_social, String telefono, String correo_electronico, String representante, String sitio_web, ArrayList<String> direccion) {
        this.nit = nit;
        this.razon_social = razon_social;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.representante = representante;
        this.sitio_web = sitio_web;
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }

    public ArrayList<String> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<String> direccion) {
        this.direccion = direccion;
    }

    public ArrayList<ProductoClase> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<ProductoClase> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void addProducto(ProductoClase producto) {
        this.listaProductos.add(producto);
    }
}
