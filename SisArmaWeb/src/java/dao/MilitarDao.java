/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Militar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.FabricaConexao;

/**
 *
 * @author ander
 */
public class MilitarDao {

    private final String GETLOGINSENHA = "SELECT login, senha FROM militar WHERE guerra = ? AND login=? AND senha=md5(?);";
    private final String GETMILITARBYLOGIN = "SELECT * FROM militar WHERE login=?";

    Connection con;
    PreparedStatement pstm;

    public boolean validarIdMilitarSenha(String login, String senha) {
        con = null;
        pstm = null;
        ResultSet rs = null;

        try {
            con = FabricaConexao.conecta();
            pstm = con.prepareStatement(GETLOGINSENHA);
            pstm.setString(1, login);
            pstm.setString(2, login);
            pstm.setString(3, senha);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
            FabricaConexao.fecharConexao();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());

        }
        return false;
    }

    public Militar getMilitar(String login) {
        con = null;
        pstm = null;
        ResultSet rs = null;
        Militar mil = new Militar();
        try {
            con = FabricaConexao.conecta();
            pstm = con.prepareStatement(GETMILITARBYLOGIN);
            pstm.setString(1, login);
            rs = pstm.executeQuery();
            while (rs.next()) {
                mil.setIdmilitar(rs.getString("idmilitar"));
                mil.setLogin(rs.getString("login"));
                mil.setSenha(rs.getString("senha"));

            }
            FabricaConexao.fecharConexao();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return mil;
    }

}
