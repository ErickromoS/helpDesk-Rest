/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.controller;

import org.lasalle.services.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author angel
 */
public class ControllerUsusario {
    public Usuario validar(String username,String password){
        String query = "SELECT * FROM  usuario WHERE username = ? AND password = ?;";
        Usuario u = null;
        try{
            ConectionMysql connMysql = new ConectionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario")); 
                System.out.println(u);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return u;
        
        
    }
    
    public Usuario validarLista(String username,String password){
        List<Usuario> listUsers = new ArrayList<>();
        listUsers = getAll();
        
        try {
            for(int i = 0; i<=listUsers.size();i++){
            Usuario user = new Usuario();
            user = listUsers.get(i);           
            
            if(user.getUsername().equals(username)  && user.getPassword().equals(password)){
                  System.out.println("se encontro");  
           
                  return user;
                
            }
            
            
        }
            
        } catch (Exception e) {
            System.out.println("error"+ e);
        }
     return null;
    }
    public List<Usuario> getAll(){
     List<Usuario> listUsers = new ArrayList<>();
     String query = "SELECT * FROM usuario;";
        try {
            ConectionMysql connMysql = new ConectionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs =  pstm.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setToken(rs.getString("token"));
                //u.setLastConnection(rs.getString("lastConnection"));
                listUsers.add(u);
                
                
            }
            return listUsers;
            
        } catch (Exception e) {
            System.out.println("Error:" + e);
            return listUsers;
        }
    }
}
