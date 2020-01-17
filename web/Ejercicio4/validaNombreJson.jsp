<%-- 
    Document   : validaNombre
    Created on : 09-ene-2020, 11:25:38
    Author     : Alumno_2DAW
--%>

<%@page import="modelo.Bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Bd bd=new Bd();
    
    String nombre=request.getParameter("nombre");
    
    if(bd.compruebaNombre(nombre)){
        out.print("{disponibilidad: 'si'}");
    }else{
        out.print("{disponibilidad: 'no', alternativas: ['123"+nombre+"','"+nombre+"asd','"+nombre+"321','12"+nombre+"34']}");
    }

%>
