/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.isysoi.controller.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ilya Sysoi
 */
public interface Action {

    String getPattern();

    void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException;

}
