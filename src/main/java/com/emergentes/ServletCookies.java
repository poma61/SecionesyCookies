package com.emergentes;

import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCookies", urlPatterns = {"/ServletCookies"})
public class ServletCookies extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   int cont=-1;
   Cookie[] c=request.getCookies();
   if(c!=null){
       for(Cookie co:c){
           
          if( co.getName().equals("visitas")){
            cont=Integer.parseInt(co.getValue());
          }
       }
       
   }     
    cont++;
Cookie c2=new Cookie("visitas",Integer.toString(cont));
//Estable el tiempo de la cookie en segundos 
c2.setMaxAge(10);
response.addCookie(c2);
 
response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.print("<html>");
out.print("<body style='background:burlywood'>");
if(cont==0)
{
out.print ("<h1 style='color:brown;background:yellowgreen;text-align:center'"
        + ">Bienvenido a nuestro sitio web</h1>");   
}else 
{
out.print ("<h1 style='color:brown;background:yellowgreen;text-align:center'>Gracias por visitarnos nuevamente</h1>"); 
}
out.print("</body>");
out.print("</html>");
  }//metodo doGEt


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       
    }

}
