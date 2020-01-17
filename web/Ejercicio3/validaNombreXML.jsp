<%-- 
    Document   : validaNombre
    Created on : 09-ene-2020, 11:25:38
    Author     : Alumno_2DAW
--%>

<%@page import="modelo.Bd"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<%
    Bd bd=new Bd();
    
    String nombre=request.getParameter("nombre");
    
    if(bd.compruebaNombre(nombre)){
        out.print("<respuesta><disponible>si</disponible></respuesta>");
    }else{
        out.print("<respuesta><disponible>no</disponible><alternativas>"
                + "<login>123"+nombre+"</login>"
                + "<login>"+nombre+"asd</login>"
                + "<login>"+nombre+"321</login>"
                + "<login>12"+nombre+"34</login>"
                + "</alternativas></respuesta>");
    }

%>
