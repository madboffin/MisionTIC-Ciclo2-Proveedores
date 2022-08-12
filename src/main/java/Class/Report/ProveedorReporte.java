/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Report;

/**
 *
 * @author manuel
 */
public class ProveedorReporte {

    private String razon_social;
    private int cantidad;

    public ProveedorReporte() {
    }

    public ProveedorReporte(String razon_social, int cantidad) {
        this.razon_social = razon_social;
        this.cantidad = cantidad;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
