<%-- 
    Document   : validaDatos
    Created on : 10-dic-2019, 14:29:27
    Author     : Alumno_2DAW
--%>

<%@page contentType="text/xml"%>
<%
    String fecha=request.getParameter("fecha_nacimiento");
    String cp=request.getParameter("codigo_postal");
    String telefono=request.getParameter("telefono");
    out.print("<respuesta><parametros>"
            + "<telefono>"+telefono+"</telefono>"
            + "<codigo_postal>"+cp+"</codigo_postal>"
            + "<fecha_nacimiento>"+fecha+"</fecha_nacimiento>"
            + "</parametros></respuesta>");
%>
