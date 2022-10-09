<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
    <head>
        <%@ include file="../_includes/head.jsp"%>
        <title>${pageTitle}</title>
    </head>
    <body>
        <div class="container-fluid">
            <%@ include file="../_includes/navbar.jsp"%>
            <main class="container-flex col-12">
                <div id="list" class="row">
                    <div class="col-md-6">
                        <h1 class="ms-3">${projeto.nome}</h1>
                    </div>
                    <div class="col-md-6">
                        <div class="col-12">
                            <span class="ms-3">Aluno: </span>
                            <span class="ms-3">${projeto.autor}</span>
                        </div>
                        <div class="col-12">
                            <span class="ms-3">Disciplina: </span>
                            <span class="ms-3">${projeto.disciplina}</span>
                        </div>
                        <div class="col-12">
                            <span class="ms-3">Projeto: </span>
                            <span class="ms-3">${projeto.descricao}</span>
                        </div>
                    </div>
                </div>
                <hr />
                <div id="top" class="row">
                    <c:forEach var="classe" items="${projeto.classes}">
                        <h2>Classe: ${classe.nome}</h2>
                        <div class="table-responsive col-md-12">
                            <table
                                class="table table-striped"
                                cellspacing="0"
                                cellpadding="0"
                            >
                                <thead>
                                    <tr>
                                        <th style="width: 20%" scope="col">
                                            Atributo
                                        </th>
                                        <th style="width: 20%" scope="col">
                                            Tipo
                                        </th>
                                        <th style="width: 60%" scope="col">
                                            Descrição
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach
                                        var="atributo"
                                        items="${classe.atributos}"
                                    >
                                        <tr>
                                            <td>${atributo.nome}</td>
                                            <td>${atributo.tipo}</td>
                                            <td colspan="2">
                                                ${atributo.descricao}
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:forEach>
                </div>
                <hr />

                <!-- /#list -->
            </main>
        </div>
        <%@ include file="../_includes/footer.jsp"%>
    </body>
</html>
