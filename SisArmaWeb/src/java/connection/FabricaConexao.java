package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    /*private static final String URL = "jdbc:mysql://localhost:3306/reserva";
    private static final String USUARIO = "root";
    private static final String SENHA = "selva";
    private static Connection conexao;*/
    
    private static final String URL = "jdbc:mysql://10.79.12.224:3306/reserva";
    private static final String USUARIO = "sisarma";
    private static final String SENHA = "#Teixeira64@";
    private static Connection conexao;

    public static Connection conecta() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado com sucesso");
        } catch (ClassNotFoundException ex) {
            System.out.println("Drive não encontrado" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Login ou senha incorretos " + ex.getMessage());
        }
        return conexao;
    }

    public static void fecharConexao() {
        try {
            conexao.close();
            System.out.println("Conexão encerrada!");
        } catch (SQLException ex) {
            System.out.println("Não foi possível encerrar conexão" + ex.getMessage());
        }
    }

}
