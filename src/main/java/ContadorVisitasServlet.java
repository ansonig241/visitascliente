

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ContadorVisitasServlet"})
public class ContadorVisitasServlet extends HttpServlet {

 


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               int contador=0;
               String mensaje="";
       
       
       //obtener el arreglo de cookies del cliente
       Cookie[] cukis = request.getCookies();
        if (cukis!=null) {
            for (Cookie c: cukis) {
                if (c.getName().equals("visitas")) {
                    //antes de la asinacion se convierte un valor  en cadena
                    contador= Integer.parseInt(c.getValue());
                }
            }
            mensaje = "Gracias por Visitarnos Nuevamente";
        }else{
            mensaje = "Bienvenido a nuestro Pagina Web";
        }
        
        contador++;
        
        
        //antes de la asignacion se convierte cadena en valor
        Cookie c= new Cookie("visitas", Integer.toString(contador));
        
        c.setMaxAge(300);
        response.addCookie(c);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Visita</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+ mensaje +"</h1>");
        out.println("</body>");
        out.println("</html>");
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
