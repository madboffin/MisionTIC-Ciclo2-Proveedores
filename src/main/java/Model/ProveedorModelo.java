/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Class.*;
import Class.Report.ProveedorReporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class ProveedorModelo {

    private Connection db_conn;

    public ProveedorModelo() {
        this.db_conn = new dbData().getConnection();
    }

    public boolean crear(ProveedorClase clsProveedor) {
        // retorna verdadero si se realiza el INSERT exitosamente
        try {
            String queryInsertProveedor = "INSERT INTO `reto3`.`tb_proveedor` "
                    + "(`nit`, `razon_social`, `telefono`, `correo_electronico`, `representante`, `sitio_web`) "
                    + "VALUES ( ?, ?, ?, ?, ?, ? );";
            PreparedStatement statementProveedor = this.db_conn.prepareStatement(queryInsertProveedor);
            statementProveedor.setInt(1, clsProveedor.getNit());
            statementProveedor.setString(2, clsProveedor.getRazon_social());
            statementProveedor.setString(3, clsProveedor.getTelefono());
            statementProveedor.setString(4, clsProveedor.getCorreo_electronico());
            statementProveedor.setString(5, clsProveedor.getRepresentante());
            statementProveedor.setString(6, clsProveedor.getSitio_web());

            String queryInsertDireccion = "INSERT INTO `reto3`.`tb_direccion` "
                    + "(`calle_carrera`, `numero`, `barrio`, `ciudad`, `nit_proveedor`) "
                    + "VALUES ( ?, ?, ?, ?, ? );";
            PreparedStatement statementDireccion = this.db_conn.prepareStatement(queryInsertDireccion);
            statementDireccion.setString(1, clsProveedor.getDireccion().get(0));
            statementDireccion.setString(2, clsProveedor.getDireccion().get(1));
            statementDireccion.setString(3, clsProveedor.getDireccion().get(2));
            statementDireccion.setString(4, clsProveedor.getDireccion().get(3));
            statementDireccion.setInt(5, clsProveedor.getNit());

            // para validar los datos ingresados a base de datos
//            System.out.println(statementProveedor);
//            System.out.println(statementDireccion);
            int rowsInserted1 = statementProveedor.executeUpdate();
            int rowsInserted2 = statementDireccion.executeUpdate();
            return (rowsInserted1 > 0 && rowsInserted2 > 0);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public ProveedorClase buscar(int nit) {
        try {
            String query = ""
                    + "SELECT * FROM reto3.tb_proveedor AS p "
                    + "INNER JOIN tb_direccion AS d ON p.nit = d.nit_proveedor "
                    + "WHERE p.nit = ?;";
            PreparedStatement statement = this.db_conn.prepareStatement(query);
            statement.setInt(1, nit);
            ResultSet resultProv = statement.executeQuery();
//            System.out.println(statement);

            // definiendo las variables que se van a usar para crear la clase proveedor
            String razon_social, telefono, correo_electronico, representante, sitio_web;
            ArrayList<String> direccion = new ArrayList<>();

            // iteranto las filas, pero este metodo solo toma la primera
            while (resultProv.next()) {
                direccion.add(resultProv.getString("calle_carrera"));
                direccion.add(resultProv.getString("numero"));
                direccion.add(resultProv.getString("barrio"));
                direccion.add(resultProv.getString("ciudad"));

                nit = resultProv.getInt("nit");
                razon_social = resultProv.getString("razon_social");
                telefono = resultProv.getString("telefono");
                correo_electronico = resultProv.getString("correo_electronico");
                representante = resultProv.getString("representante");
                sitio_web = resultProv.getString("sitio_web");
                resultProv.getInt("nit_proveedor");

                ProveedorClase clsProveedor = new ProveedorClase(nit, razon_social,
                        telefono, correo_electronico, representante, sitio_web, direccion);
                return clsProveedor;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int editar(ProveedorClase clsProveedor) {

        // 1 si no se encuentra
        // 2 si hay error al actualizar los datos
        // 3 si se actualiza correctamente
        try {
            String queryProveedor = ""
                    + "UPDATE reto3.tb_proveedor "
                    + "SET razon_social = ?, telefono = ?, correo_electronico = ?, representante = ?, sitio_web = ? "
                    + "WHERE nit = ? ;";
            PreparedStatement statementProveedor = this.db_conn.prepareStatement(queryProveedor);
            statementProveedor.setString(1, clsProveedor.getRazon_social());
            statementProveedor.setString(2, clsProveedor.getTelefono());
            statementProveedor.setString(3, clsProveedor.getCorreo_electronico());
            statementProveedor.setString(4, clsProveedor.getRepresentante());
            statementProveedor.setString(5, clsProveedor.getSitio_web());
            statementProveedor.setInt(6, clsProveedor.getNit());

            String queryDireccion = ""
                    + "UPDATE reto3.tb_direccion "
                    + "SET calle_carrera = ?, numero = ?, barrio = ?, ciudad = ? "
                    + "WHERE nit_proveedor = ? ;";
            PreparedStatement statementDireccion = this.db_conn.prepareStatement(queryDireccion);

            statementDireccion.setString(1, clsProveedor.getDireccion().get(0));
            statementDireccion.setString(2, clsProveedor.getDireccion().get(1));
            statementDireccion.setString(3, clsProveedor.getDireccion().get(2));
            statementDireccion.setString(4, clsProveedor.getDireccion().get(3));
            statementDireccion.setInt(5, clsProveedor.getNit());

            int rowsUpdatedProveedor = statementProveedor.executeUpdate();
            int rowsUpdatedDireccion = statementDireccion.executeUpdate();

            if (rowsUpdatedProveedor > 0 && rowsUpdatedDireccion > 0) {
                return 3;
            } else {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 2;
        }
    }

    public int eliminar(int nit) throws SQLException {
        // retorna 
        // 1 si no se encuentra
        // 2 remocion correcta
        // 3 throws exception en caso de error
        try {
            String queryDeleteDireccion = "DELETE FROM `reto3`.`tb_direccion` "
                    + " WHERE `nit_proveedor` = ?;";
            PreparedStatement statementDireccion = this.db_conn.prepareStatement(queryDeleteDireccion);
            statementDireccion.setInt(1, nit);

            String queryDeleteProveedor = "DELETE FROM `reto3`.`tb_proveedor` "
                    + " WHERE `nit` = ?;";
            PreparedStatement statementProveedor = this.db_conn.prepareStatement(queryDeleteProveedor);
            statementProveedor.setInt(1, nit);

            // para validar los datos ingresados a base de datos
            int rowsDeleted2 = statementDireccion.executeUpdate();
            int rowsDeleted1 = statementProveedor.executeUpdate();

            if (rowsDeleted1 > 0 && rowsDeleted2 > 0) {
                return 2;
            } else {
                return 1;
            }

        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

//    public ArrayList<ProductoClase> obtenerProductos() {
//        try {
//            ArrayList<ProductoClase> lista_reporte
//            String query = "SELECT nit, razon_social, telefono, correo_electronico, representante, sitio_web "
//                    + " FROM reto3.tb_proveedor AS pv ";
//            PreparedStatement statement = this.db_conn.prepareStatement(query);
//            ResultSet result = statement.executeQuery();
//            while (result.next()) {
//
//                ProveedorClase temp = new ProveedorClase(
//                        result.getInt("nit"),
//                        result.getString("razon_social"),
//                        result.getString("telefono"),
//                        result.getString("correo_electronico"),
//                        result.getString("representante"),
//                        result.getString("sitio_web"));
//                
//                
//            }
//        } catch (SQLException e) {
//
//        }
//        return null;
//    }
    public ArrayList<ProveedorClase> obtenerLista() throws SQLException {
        try {
            ArrayList<ProveedorClase> lista_proveedores = new ArrayList<>();
            String query = "SELECT nit, razon_social, telefono, correo_electronico, representante, sitio_web "
                    + " FROM reto3.tb_proveedor AS pv ";
            PreparedStatement statement = this.db_conn.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ProveedorClase temp;
                temp = new ProveedorClase(
                        result.getInt("nit"),
                        result.getString("razon_social"),
                        result.getString("telefono"),
                        result.getString("correo_electronico"),
                        result.getString("representante"),
                        result.getString("sitio_web"));
                lista_proveedores.add(temp);
            }
            return lista_proveedores;

        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<ProveedorReporte> obtenerListadoProductos() throws SQLException {
        try {
            ArrayList<ProveedorReporte> lista_reporte = new ArrayList<>();
            String query = "SELECT razon_social, count(pd.id) AS cantidad FROM reto3.tb_proveedor AS pv\n "
                    + " INNER JOIN reto3.tb_proveedor_producto AS pp ON pp.tb_proveedor_nit = pv.nit\n "
                    + " INNER JOIN reto3.tb_producto AS pd ON pp.tb_producto_id = pd.id\n "
                    + " GROUP BY razon_social;";
            PreparedStatement statement = this.db_conn.prepareStatement(query);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ProveedorReporte temp;
                temp = new ProveedorReporte(
                        result.getString("razon_social"),
                        result.getInt("cantidad"));
                lista_reporte.add(temp);
            }
            return lista_reporte;

        } catch (SQLException e) {
            throw e;
        }
    }
}
