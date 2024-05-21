/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lasalle.services.controller;

import org.lasalle.services.model.Categoria;
import org.lasalle.services.controller.ControllerUsusario;

/**
 *
 * @author angel
 */
public class Main {
    public static void main(String[] args) {
//        Categoria c = new Categoria(0,"Sin conexion a internet", "TI", 1);
//        ControllerCategoria cc = new ControllerCategoria();
//        cc.saveCategoria(c);
//        System.out.println("Registro realizado");
        
        ControllerUsusario cu = new ControllerUsusario();
        cu.validarLista("carlin", "root");
        
        System.out.println("dhgh");
    }
}
