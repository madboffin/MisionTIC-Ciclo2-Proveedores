/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Class.ProveedorClase;
import Class.Report.ProveedorReporte;
import Model.ProveedorModelo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class ProveedorControlador {

    private ProveedorModelo modelProveedor;

    public ProveedorControlador() {
        this.modelProveedor = new ProveedorModelo();
    }

    public boolean crear(ProveedorClase clsProveedor) {
        return this.modelProveedor.crear(clsProveedor);
    }

    public ProveedorClase buscar(int nit) {
        ProveedorClase proveedor = this.modelProveedor.buscar(nit);
        return proveedor;
    }

    public int editar(ProveedorClase clsProveedor) {
        return this.modelProveedor.editar(clsProveedor);
    }

    public int eliminar(int nit) {
        try {
            return this.modelProveedor.eliminar(nit);
        } catch (SQLException e) {
            return 0;
        }
    }

    public ArrayList<ProveedorReporte> obtenerReporte() throws SQLException {
        try {
            return this.modelProveedor.obtenerListadoProductos();
        } catch (SQLException e) {
            throw e;
        }
    }
}
