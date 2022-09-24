package Server;

import Utils.MySQLConnection;

import java.sql.*;

public class Dao {

    Connection conn; // Conexion a la BD
    PreparedStatement pste;
    CallableStatement cstn; // Llamadas a procedimientos
    ResultSet rs; // Cacha los registros de la BD

    public boolean save(String name, String lastname, String surname, String sex, String state, String date){
        boolean register = false;
        try{
            conn = new MySQLConnection().connect();
            String sql = "INSERT INTO person (name, lastname, surname, sex, state, date) VALUES (?, ?, ?, ?, ?, ?)";

            /*pste.close();
            conn.close();*/
            pste.setString(1, name);
            pste.setString(2, lastname);
            pste.setString(3, surname);
            pste.setString(4, sex);
            pste.setString(5, state);
            pste.setString(6, date);
            pste.execute(sql);
            register = true;

        }catch (SQLException e){
            System.out.println("Error en: " + e);
        }finally {
            closeConnection();
        }
        return register;
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pste != null){
                pste.close();
            }
            if(cstn != null){
                cstn.close();
            }
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
