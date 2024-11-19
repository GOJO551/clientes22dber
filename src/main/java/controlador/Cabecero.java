package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Cabecero extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //obtenemos el mpetodo que esta realizando la peticiov
        String metodoHttp=req.getMethod();
        //Obtenemos la Uri contextPath+servletPath
        String requestUri=req.getRequestURI();
        //obtenemos la URL completa
        String requestUrl=req.getRequestURL().toString();
        //Obtenemos el nombre del proyecto
        String contextPath=req.getContextPath();
        //Obtenemos el path del servlet
        String servletPath=req.getServletPath();
        PrintWriter out = resp.getWriter();
        //Creo la plantilla html
        out.print("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>Cabeceros</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Peticiones Http Request</h1>");
        out.println("<ul>");
        out.println("<li>Método: "+metodoHttp+"</li>");
        out.println("<li>Uri: "+requestUri+"</li>");
        out.println("<li>URL: "+requestUrl+"</li>");
        out.println("<li>ContextPath: "+contextPath+"</li>");
        out.println("<li>Servlet Path: "+servletPath+"</li>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}