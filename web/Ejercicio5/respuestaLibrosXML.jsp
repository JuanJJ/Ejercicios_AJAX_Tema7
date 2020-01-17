<%-- 
    Document   : respuestaLibrosXML
    Created on : 16-ene-2020, 12:30:31
    Author     : Alumno_2DAW
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Libro"%>
<%@page import="modelo.Bd_Busqueda"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<%
    String libro=request.getParameter("libro");
    Bd_Busqueda bd=new Bd_Busqueda();
    List<Libro>listaLibros=bd.getLibros(libro);
    
    if(listaLibros.size()==0){
        out.print("<respuesta><encontrado>no</encontrado></respuesta>");
    } else if(listaLibros!=null){
        
        String texto="<respuesta>"
                + "<encontrado>si</encontrado>"
                + "<disponible>"
                + "<libros>";
        for(int i=0;i<listaLibros.size();i++){
            Libro lib=listaLibros.get(i);
            String titulo=lib.getTitulo();
            String autor=lib.getAutor();
            texto+="<titulo>"+titulo+"</titulo>"
                + "<autor>"+autor+"</autor>";
            
        }
        texto+="</libros></disponible></respuesta>";
        out.print(texto);
    }
    
%>
