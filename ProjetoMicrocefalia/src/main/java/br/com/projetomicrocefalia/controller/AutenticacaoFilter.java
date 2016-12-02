/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetomicrocefalia.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gilberto
 */
@WebFilter(filterName = "AutenticacaoFilter", urlPatterns = {"/*"})
public class AutenticacaoFilter implements Filter {

    public AutenticacaoFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String url = httpServletRequest.getRequestURI();
        HttpSession session = httpServletRequest.getSession();

        if (session.getAttribute("usuLogado") != null
                || url.contains("login.jsp")
                || url.contains("autenticador.do")
                || url.contains("cadastrousuario.jsp")
                || url.contains("usuariocontroller.do")
                || url.contains("rest")
                || url.contains(".css")
                || url.contains(".js")) {
            System.out.println("Passou!!!");
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect("login.jsp");
        }

    }

    @Override
    public void destroy() {

    }

}
