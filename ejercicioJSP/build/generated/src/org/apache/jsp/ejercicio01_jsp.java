package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ejercicio01_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int cantidadNumeros = 40; 
 int cantidadNumerosVendidos = 0; 
 int numerosPorFila = 10; 
 String[] listadoNumeros = new String[cantidadNumeros]; 
 
    private String venderNumero(int numero, String nombre){
        if(numero <= 0 || numero > cantidadNumeros) return "Numero fuera de rango";
        if(nombre.equals("")) return "Debe ingresar un nombre";
        
        int idx = numero-1;
        if(listadoNumeros[idx]==null){
            listadoNumeros[idx] = nombre;
            cantidadNumerosVendidos++;
            return "Venta exitosa";
        }else{
            return "Numero no disponible";
        }
    }
    private String buscarGanador(int numero){
        if(numero <= 0 || numero > cantidadNumeros) return "Numero fuera de rango";
        
        int idx = numero-1;
        return "GANADOR: " +listadoNumeros[idx];
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("    \n");
      out.write('\n');
      out.write('\n');
      out.write('\n');

    String sNumero = request.getParameter("numero");
    int numero = 0;
    String mensaje = "";
    String nombre = "";
    
    try{
        numero = Integer.parseInt(sNumero);
        
    }catch(Exception e){
        mensaje = "Debe ingresar un numero entero";
    }
    if(sNumero == null) sNumero = "";
    if(nombre == null) nombre = "";
    
    if(cantidadNumerosVendidos == cantidadNumeros){
        mensaje = buscarGanador(numero);
    } else {
        nombre = request.getParameter("nombre");
        mensaje = venderNumero(numero, nombre);
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>RIFA!</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>RIFA</h1>\n");
      out.write("        <table width=\"600\">\n");
      out.write("            <tr height=\"60\">\n");
      out.write("                ");
 for(int i=0; i<cantidadNumeros; i++){ 
      out.write("\n");
      out.write("                ");
 if(listadoNumeros[i] == null) { 
      out.write("\n");
      out.write("                <th bgcolor=\"#9b59b6\" width=\"10%\">");
      out.print( (i+1) );
      out.write("</th>\n");
      out.write("                ");
 } else { 
      out.write("\n");
      out.write("                <th bgcolor=\"#F22613\" width=\"10%\">X</th>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                ");
 if(i%numerosPorFila == (numerosPorFila-1)) { 
      out.write("\n");
      out.write("            </tr><tr height=\"60\">\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("            <br><br>\n");
      out.write("            <h2>");
      out.print( mensaje );
      out.write("</h2>\n");
      out.write("            <form method=\"POST\" action=\"\">\n");
      out.write("                    \n");
      out.write("                    ");
 if(cantidadNumerosVendidos == cantidadNumeros) { 
      out.write("\n");
      out.write("                        <fieldset>\n");
      out.write("                            <legend>Buscar ganador  </legend>\n");
      out.write("                            <p>Numero <input type=\"text\" name=\"numero\" value=\"");
      out.print( sNumero );
      out.write("\"></p>\n");
      out.write("                            <p><input type=\"Submit\" value=\"Buscar ganador\" name=\"\"></p>\n");
      out.write("                        </fieldset>\n");
      out.write("                    ");
 } else { 
      out.write("\n");
      out.write("                    <fieldset>\n");
      out.write("                        <legend>Venta de numeros</legend>\n");
      out.write("                        <p>Numero <input type=\"text\" name=\"numero\" value=\"");
      out.print( sNumero );
      out.write("\"></p>\n");
      out.write("                        <p>Nombre <input type=\"text\" name=\"nombre\" value=\"");
      out.print( nombre );
      out.write("\"></p>\n");
      out.write("                        <p><input type=\"Submit\" value=\"Vender numero\" name=\"\"></p>\n");
      out.write("                    </fieldset>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
