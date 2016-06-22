<%-- 
    Document   : resultado
    Created on : 20/05/2016, 19:41:59
    Author     : Hallessandro
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="processamento.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Total da Compra</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <table class="table table-bordered table-hover">
            <tr class="success">
                <th>Produto</th>
                <th>Preço</th>
            </tr>
        <% 
        ArrayList<Produto>produtos = (ArrayList<Produto>) session.getAttribute("produtos");
        double total = 0;
        %>
        
        <% for (Produto p: produtos){ %>
        <tr>
            <td><%= p.getNome() %></td>
            <td><%= p.getPreco()%></td>
            <% total+= p.getPreco(); %>
        </tr>
        <% } %>
        <tr class="warning">
            <td>Total</td>
            <td><%= total %></td>
        </tr>
        </table>
    </body>
</html>
