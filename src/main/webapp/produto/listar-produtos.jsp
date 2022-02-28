<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Produtos</title>
    </head>
    <body>
        <center>
            <h1>Produtos</h1>
            <form action="listar" method="POST">
                <div>
                    <label for="nome">Pesquisar produto:</label>
                    <input type="text" name="nome" id="nome">
                    <input type="submit" value="Pesquisar">
                </div>
            </form>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Lista de Produtos</h2></caption>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Categoria</th>
                </tr>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td><c:out value="${produto.codigo}" /></td>
                        <td><c:out value="${produto.nome}" /></td>
                        <td><c:out value="${produto.preco}" /></td>
                        <td><c:out value="${produto.categoria.nome}" /></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/praticamysql/produto/inserir">Inserir Produto</a>&nbsp;&nbsp;&nbsp;
            <a href="/praticamysql">Voltar</a>
        </div>
    </body>
</html>