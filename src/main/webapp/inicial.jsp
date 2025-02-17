<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Categorias</title>
    </head>
    <body>
        <center>
            <h1>Categorias de Despesas</h1>
            <h2>
                <a href="./categoria/inserir">Inserir Categoria</a>
                &nbsp;&nbsp;&nbsp;
                <a href="./produto/inserir">Inserir Produto</a>        	
            </h2>
        </center>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Lista de Categorias</h2></caption>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
                <c:forEach var="categoria" items="${listaCategoria}">
                    <tr>
                        <td><c:out value="${categoria.codigo}" /></td>
                        <td><c:out value="${categoria.nome}" /></td>
                        <td>
                            <a href="./categoria/editar?codigo=<c:out value='${categoria.codigo}' />">Editar</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="./categoria/excluir?codigo=<c:out value='${categoria.codigo}' />">Excluir</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="./produto/listar?categoria=<c:out value='${categoria.codigo}' />">Ver produtos</a>                  	
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>	
    </body>
</html>