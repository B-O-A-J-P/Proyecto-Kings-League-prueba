package org.learning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:free";
        String username = "system";
        String password = "oracle";
        String p_hora_inicio = "12dfad:00";
        String p_ubicacion = "Some Location";
        int p_cod_split = 99;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            CallableStatement cstmt = conn.prepareCall("{call utilidades_calendario.generar_calendario(?, ?, ?)}");
            cstmt.setString(1, p_hora_inicio);
            cstmt.setString(2, p_ubicacion);
            cstmt.setInt(3, p_cod_split);
            cstmt.execute();

            // Procedure executed successfully
            System.out.println("Procedure executed successfully");
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            String errorMessage = e.getMessage();

            if (errorCode == 20001) {
                // Handle non_numeric exception
                System.out.println("non_numeric exception: " + errorMessage);
            } else if (errorCode == 20002) {
                // Handle jornada_ya_existente exception
                System.out.println("jornada_ya_existente exception: " + errorMessage);
            } else if (errorCode == 20003) {
                // Handle formato_no_conforme exception
                System.out.println("formato_no_conforme exception: " + errorMessage);
            } else {
                // Handle other exceptions or rethrow the SQLException
                System.out.println(e.getErrorCode());

                e.printStackTrace();
            }
        }
    }
}
