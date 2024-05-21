package modelo.dao;

import conector.Conector;
import modelo.bean.Arma;
import modelo.bean.Caballero;
import modelo.bean.Escudo;

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
                    rs.getString("foto"),
                    null,
                    null
                );
                caballeros.add(caballero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conector.cerrarConexionBBDD();
        }
        
        return caballeros;
    }

    public Arma getArmaById(int armaId) {
        Arma arma = null;
        String query = "SELECT * FROM armas WHERE id = ?";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, armaId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    arma = new Arma(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("capacidad_danio"),
                        rs.getString("foto")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return arma;
    }

    public Escudo getEscudoById(int escudoId) {
        Escudo escudo = null;
        String query = "SELECT * FROM escudos WHERE id = ?";
        
        try (Connection conn = conector.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, escudoId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    escudo = new Escudo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("capacidad_defensa")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return escudo;
    }

    public ArrayList<Caballero> getAllCaballerosConArmaYEscudo() {
        ArrayList<Caballero> caballeros = getAllCaballeros();
        
        for (Caballero caballero : caballeros) {
            caballero.setArma(getArmaById(caballero.getId()));
            caballero.setEscudo(getEscudoById(caballero.getId()));
        }
        
        return caballeros;
    }
}
