/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.isysoi.controller.command;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ilya Sysoi
 */
public interface Command {
    String getPattern();
    
    void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException ;
   
    default void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
           throws ServletException, IOException{
       doGet(request, response, servletContext);
   }
}
