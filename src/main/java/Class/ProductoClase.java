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
public class ProductoClase {

    private int id;
    private String nombre;
    private int precio_actual;
    private int existencia;
    private int nit_proveedor;
    private ArrayList<ProveedorClase> listaProveedores = new ArrayList<>();

    public ProductoClase() {
    }

    public ProductoClase(int id, String nombre, int precio_actual, int existencia) {
        this.id = id;
        this.nombre = nombre;
        this.precio_actual = precio_actual;
        this.existencia = existencia;
    }

    public ProductoClase(int id, String nombre, int precio_actual, int existencia, int nit_proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio_actual = precio_actual;
        this.existencia = existencia;
        this.nit_proveedor = nit_proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio_actual() {
        return precio_actual;
    }

    public void setPrecio_actual(int precio_actual) {
        this.precio_actual = precio_actual;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(int nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public ArrayList<ProveedorClase> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(ArrayList<ProveedorClase> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public void addProveedor(ProveedorClase proveedor) {
        this.listaProveedores.add(proveedor);
    }
}
