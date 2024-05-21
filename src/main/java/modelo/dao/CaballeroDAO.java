package modelo.dao;

import conector.Conector;
import modelo.bean.Caballero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaballeroDAO {
    private Conector conector;

    public CaballeroDAO() {
        conector = new Conector();
    }

    public ArrayList<Caballero> getAllCaballeros() {
        ArrayList<Caballero> caballeros = new ArrayList<>();
        String query = "SELECT * FROM caballeros";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Caballero caballero = new Caballero(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("fuerza"),
                    rs.getInt("experiencia"),
                    rs.getString("foto"));
                caballeros.add(caballero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conector.cerrarConexionBBDD();
        }
        
        return caballeros;
    }
}
