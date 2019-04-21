/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.isysoi.controller.action;

import by.isysoi.exception.ActionException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ilya Sysoi
 */
public interface Action {

    String getPattern();

    void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException;

}
