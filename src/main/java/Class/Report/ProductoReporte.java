/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Report;

/**
 *
 * @author manuel
 */
public class ProductoReporte {
    private String nombre;
    private int precio_actual;
    private String proveedor;
    private int nit;
    private int existencia;

    public ProductoReporte() {
    }

    public ProductoReporte(String nombre, int precio_actual, String proveedor, int nit, int existencia) {
        this.nombre = nombre;
        this.precio_actual = precio_actual;
        this.proveedor = proveedor;
        this.nit = nit;
        this.existencia = existencia;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
}
