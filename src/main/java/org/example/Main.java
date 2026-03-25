package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        )) {
            String sql = "DELETE FROM empleado WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 10);

            int filasActualizadas = preparedStatement.executeUpdate(); //Número de filas afectadas
            System.out.println("Empleado eliminado. Filas afectadas: " + filasActualizadas);

        }catch (SQLException e){
            System.out.println("Error --> "+e.getMessage());
        }
    }
}
