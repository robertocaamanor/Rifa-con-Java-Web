<%-- 
    Document   : ejercicio01
    Created on : 22-abr-2016, 17:16:37
    Author     : Particular
--%>

<%! int cantidadNumeros = 40; %>
<%! int cantidadNumerosVendidos = 0; %>    
<%! int numerosPorFila = 10; %>
<%! String[] listadoNumeros = new String[cantidadNumeros]; %>
<%! 
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
%>
<%
    String sNumero = request.getParameter("numero");
    int numero = 0;
    String mensaje = "";
    String nombre = "";
    
    try{
        numero = Integer.parseInt(sNumero);    
        
    }catch(Exception e){
        mensaje = "Debe ingresar un numero entero";
    }
    
    
    if(cantidadNumerosVendidos == cantidadNumeros){
        mensaje = buscarGanador(numero);
    } else {
        nombre = request.getParameter("nombre");
        mensaje = venderNumero(numero, nombre);
    }
    if(sNumero == null) sNumero = "";
    if(nombre == null) nombre = "";
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RIFA!</title>
    </head>
    <body>
        <h1>RIFA</h1>
        <table width="600">
            <tr height="60">
                <% for(int i=0; i<cantidadNumeros; i++){ %>
                <% if(listadoNumeros[i] == null) { %>
                <th bgcolor="#9b59b6" width="10%"><%= (i+1) %></th>
                <% } else { %>
                <th bgcolor="#F22613" width="10%">X</th>
                <% } %>
                <% if(i%numerosPorFila == (numerosPorFila-1)) { %>
            </tr><tr height="60">
                <% } %>
                <% } %>
            </tr>
        </table>
            <br><br>
            <h2><%= mensaje %></h2>
            <form method="POST" action="">
                    
                    <% if(cantidadNumerosVendidos == cantidadNumeros) { %>
                        <fieldset>
                            <legend>Buscar ganador  </legend>
                            <p>Numero <input type="text" name="numero" value="<%= sNumero %>"></p>
                            <p><input type="Submit" value="Buscar ganador" name=""></p>
                        </fieldset>
                    <% } else { %>
                    <fieldset>
                        <legend>Venta de numeros</legend>
                        <p>Numero <input type="text" name="numero" value="<%= sNumero %>"></p>
                        <p>Nombre <input type="text" name="nombre" value="<%= nombre %>"></p>
                        <p><input type="Submit" value="Vender numero" name=""></p>
                    </fieldset>
                    <% } %>
                
            </form>
    </body>
</html>
