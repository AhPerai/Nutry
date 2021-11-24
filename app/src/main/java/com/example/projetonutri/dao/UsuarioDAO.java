package com.example.projetonutri.dao;

import com.example.projetonutri.Model.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuarioDAO {

    private static Conexao con=new Conexao();

//        private static void createTable() {
//            Connection connection = Conexao.getConnection();
//            String createTable = "CREATE TABLE IF NOT EXISTS USUARIO"
//                    + "   (id serial PRIMARY KEY,"
//                    + "    nome  VARCHAR ( 255 )    NOT NULL,"
//                    + "    idade  VARCHAR ( 20 ) NOT NULL,"
//                    + "    genero VARCHAR ( 45 ) NOT NULL, "
//                    + "    email  VARCHAR ( 255 )   NOT NULL,"
//                    + "    senha  VARCHAR ( 255 )   NOT NULL)";
//
//            Statement stmt = null;
//            try {
//                stmt = connection.createStatement();
//                stmt.execute(createTable);
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }

    public void adicionarUsuario(Usuario usuario){

            String sql = String.format("INSERT INTO USUARIO (nome, idade, genero, email, senha) VALUES('%s', '%s', '%s', '%s', '%s');",
                    usuario.getNome(), usuario.getIdade(), usuario.getGenero(), usuario.getEmail(), usuario.getSenha());

            new Conexao().executa(sql);
        }
    }

//        public static boolean removerCliente(int id){
//            createTable();
//            Connection connection = Conexao.getConnection();
//            String sql = "DELETE FROM CLIENTE WHERE ID= ?";
//            PreparedStatement pstmt;
//
//            try {
//                pstmt = connection.prepareStatement(sql);
//                pstmt.setInt(1, id);
//                pstmt.execute();
//                return true;
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//                return false;
//            }
//        }
//
//        public static List<Cliente> listarClientes(){
//            createTable();
//            List<Cliente> lista = new ArrayList<Cliente>();
//            Connection connection = Conexao.getConnection();
//            String sql = "SELECT * FROM CLIENTE";
//            Statement stmt;
//
//            try {
//                stmt = connection.createStatement();
//                ResultSet resultado = stmt.executeQuery(sql);
//
//                while (resultado.next()) {
//
//                    int id = resultado.getInt("id");
//                    String nome = resultado.getString("nome");
//                    String telefone = resultado.getString("telefone");
//                    String email = resultado.getString("email");
//                    String senha = resultado.getString("senha");
//
//                    Cliente cliente = new Cliente(nome, telefone, email, senha, id);
//                    lista.add(cliente);
//                }
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//                return null;
//            }
//            return lista;
//        }
//
//        public static boolean atualizarCliente(Cliente cliente){
//            createTable();
//            Connection connection = Conexao.getConnection();
//            String sql = "UPDATE CLIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?, SENHA = ? WHERE ID = ?";
//            PreparedStatement pstmt;
//
//            try {
//                pstmt = connection.prepareStatement(sql);
//                pstmt.setString(1, cliente.getNome());
//                pstmt.setString(2, cliente.getEmail());
//                pstmt.setString(3, cliente.getTelefone());
//                pstmt.setString(4, cliente.getSenha());
//                pstmt.setInt(5, cliente.getId());
//                pstmt.execute();
//                return true;
//
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//                return false;
//            }
//        }
