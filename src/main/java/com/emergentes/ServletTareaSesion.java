
package com.emergentes;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletTareaSesion", urlPatterns = {"/ServletTareaSesion"})
public class ServletTareaSesion extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String op=request.getParameter("op");
      if(op.equals("nuevo")){
            //Obetner acceso en el objeto sesion
   HttpSession sesion=request.getSession();
   //Se elimina la sesion
   sesion.invalidate();
   //transfiere el control a TareasSesion.jsp;
   response.sendRedirect("TareasSesion.jsp");
   
      }
      if(op.equals("eliminar")){
          int indice=-1;
          int elimina=-1;
      int id=Integer.parseInt(request.getParameter("id"));
       //elimionar la tarea   
        HttpSession s=request.getSession();
        ArrayList<clsTarea> l=(ArrayList<clsTarea>)s.getAttribute("lista");
     for(clsTarea t:l){
             indice++;
       if(t.getId()==id){
           elimina=indice;
       }  
   
     }
      l.remove(elimina);
      response.sendRedirect("TareasSesion.jsp");
     
     
      }
        
        
 
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //Recupera las tareas pendientes enviado desde el formulario 
   int id=Integer.parseInt(request.getParameter("id"));
   String tarea=request.getParameter("tarea");
   //se Obttiene acceso a la sesion
   HttpSession sesion=request.getSession();
   //Se obtiene la lista que esta como atributo de session
   ArrayList<clsTarea> lista=(ArrayList<clsTarea>)sesion.getAttribute("lista");
    clsTarea t=new clsTarea();
    t.setId(id);
    t.setTarea(tarea);
   //A la coleccion se le adiciona la tarea
   
   lista.add(t);
   //redireccionamos a TareaSesion.jsp
   response.sendRedirect("TareasSesion.jsp");
        
        
        
    }

}
