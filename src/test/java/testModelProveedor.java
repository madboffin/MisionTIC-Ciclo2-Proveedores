/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Model.*;
import Class.*;
import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author manuel
 */
public class testModelProveedor {

    ProveedorModelo mProveedor;

    public testModelProveedor() {
        mProveedor = new ProveedorModelo();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void conexionDB() {
        Connection conn = new dbData().getConnection();
        assertNotEquals(null, conn);
    }

    @Test
    public void editarProveedorOk() {

        // si se encuentra proveedor retorna 3
        ProveedorModelo mProveedor = new ProveedorModelo();
        ArrayList<String> direccion = new ArrayList<>();
        direccion.add("carrera 1");
        direccion.add("2");
        direccion.add("model");
        direccion.add("testia");
        ProveedorClase proveedor = new ProveedorClase(11111, "razon de prueba",
                "534363", "prueba@test.com", "pedro pruebas", "test.com", direccion);
        int result = mProveedor.editar(proveedor);
        assertEquals(3, result);
    }

    @Test
    public void editarProveedorError() {

        // un error deberia retornar 2
        // se pasa un proveedor vacio para generar el error
        ProveedorClase proveedor = new ProveedorClase();
        int result = mProveedor.editar(proveedor);
        assertEquals(2, result);
    }

    @Test
    public void editarProveedorNoExiste() {

        // no se encuentra proveedor retorna 1
        ProveedorModelo mProveedor = new ProveedorModelo();
        ArrayList<String> direccion = new ArrayList<>();
        direccion.add("carrera 1");
        direccion.add("2");
        direccion.add("model");
        direccion.add("testia");
        ProveedorClase proveedor = new ProveedorClase(6543476, "razon de prueba",
                "534363", "prueba@test.com", "pedro pruebas", "test.com", direccion);
        int result = mProveedor.editar(proveedor);
        assertEquals(1, result);
    }

    @Test
    public void eliminarProveedorOk() {

        // al eliminar correctamente se retorna 2
        // se agrega un registro dummie
        int nitDummie = 9999;
        ArrayList<String> direccion = new ArrayList<>();
        direccion.add("carrera 1");
        direccion.add("2");
        direccion.add("model");
        direccion.add("testia");
        ProveedorClase proveedor = new ProveedorClase(nitDummie, "", "", "", "", "", direccion);
        mProveedor.crear(proveedor);

        // se elimina 
        int result = 0;
        try {
            result = mProveedor.eliminar(nitDummie);
        } catch (SQLException ex) {
            Logger.getLogger(testModelProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(2, result);
    }

    @Test
    public void eliminarProveedorNoExiste() throws SQLException {

        // si no se encuentra el registro debe retornar 1
        // se pasa un proveedor vacio para generar el error
        int result = 0;
        try {
            result = mProveedor.eliminar(12399);
        } catch (SQLException ex) {
        }
        assertEquals(1, result);
    }

    @Test(expected = SQLException.class)
    public void eliminarProveedorError() throws SQLException {

        // si ocurre un error debe arrojar SQLException
        
        // no encuentro como generar el error
        assertEquals(SQLException.class, mProveedor.eliminar(2147483647));
    }
}
