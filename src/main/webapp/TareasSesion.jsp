<%@page import ="java.util.ArrayList"%>
<%@page import ="com.emergentes.clsTarea"%>
<%
    if(session.getAttribute("lista")==null)
    {
     ArrayList<clsTarea> aux= new ArrayList<clsTarea>();
     session.setAttribute("lista", aux);
    }
     ArrayList<clsTarea> lista= (ArrayList<clsTarea>)session.getAttribute("lista"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tarea</title>
    </head>
    <body style="background:burlywood">
        <h1 style="color:brown;text-align:center">TAREAS PENDIENTES</h1>
        <table >
        <form action="ServletTareaSesion" method="POST">
            <tr>
                <td style="font-size:25px">Id:</td>
                <td><input style="font-size:25px"  type="number" name="id" placeholder="id" required></td>
            </tr> 
            <tr>
                 <td style="font-size:25px" >Tarea: </td>
                <td><input style="font-size:25px" type="text" name="tarea" placeholder="Tarea" required></td>      
            </tr>
            <tr>
                <td><input style="font-size:25px" type="submit" value="Agendar Tarea" ></td> 
            </tr>
        </form>
           
       </table>
         <h2 style="font-size:25px;color:brown">Tareas a relizar</h2>
         <a href="ServletTareaSesion?op=nuevo" style="color:red;font-size:20px">Nuevo</a>
         <br>
         <br>
        <table border="1">
            <tr>
                <th style="font-size:20px;color:green">Id</th>
                <th style="font-size:20px;color:green">Tarea</th>
                <th style="font-size:20px;color:green">Completado</th>
                <th style="font-size:20px;color:green">Eliminar</th>
               
            </tr>
            <% if (lista!=null){
                for (clsTarea t:lista){
            
            %>
            <tr>
               <td style="font-size:20px;color:royalblue"><%=t.getId()%></td>
               <td style="font-size:20px;color:royalblue"><%=t.getTarea()%></td>
               <td ><input  type="checkbox"></td>
               <td ><a style="font-size:20px;color:royalblue" href="ServletTareaSesion?op=eliminar&id=<%=t.getId()%>">Eliminar</a></td>
            </tr>  
            <% 
             }
             }
            %>
        </table>
        <a href="index.jsp" style="color:red ;font-size:20px">Volver Menu</a>
    </body>
</html>
