<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Inserir Produto</title>
    </head>
    <body>
        <center>
            <h1>Inserir Produto</h1>
            <form action="inserir" method="POST">
                <div>
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" id="nome">
                </div>
                <div>
                    <label for="preco">Preço:</label>
                    <input type="text" name="preco" id="preco">
                </div>
                <div>
                    <label for="categoria">Categoria:</label>
                    <select name="categoria" id="categoria">
                        <option value="">Selecione...</option>
                        <c:forEach var="categoria" items="${categorias}">
                            <option value="${categoria.codigo}">${categoria.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" value="Inserir">
            </form>
            <a href="/praticamysql">Voltar</a>
        </center>
    </body>
</html>