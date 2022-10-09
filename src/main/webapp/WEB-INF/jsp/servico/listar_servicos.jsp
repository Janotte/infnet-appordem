<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
                <div id="top" class="row d-flex align-items-baseline">
                    <div class="col-md-3 ms-3">
                        <h2>${pageTitle}</h2>
                    </div>
                    <div class="col-md-3">
                        <a href="/servico/adicionar" class="btn btn-primary"
                            >Novo Serviço</a
                        >
                    </div>
                </div>
                <!-- /#top -->
                <hr />
                <div id="alert" class="alert ${mensagem.tipo}" role="alert">
                    ${mensagem.texto}
                </div>
                <!-- /#alert -->
                <div id="list" class="row">
                    <div class="table-responsive col-md-12">
                        <table
                            class="table table-striped"
                            cellspacing="0"
                            cellpadding="0"
                        >
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Preço de Venda</th>
                                    <th scope="col" class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="servico" items="${servicoList}">
                                    <tr>
                                        <td>${servico.id}</td>
                                        <td>${servico.nome}</td>
                                        <td>
                                            <fmt:formatNumber
                                                type="number"
                                                minFractionDigits="2"
                                                maxFractionDigits="2"
                                                value="${servico.precoVenda}"
                                            />
                                        </td>
                                        <td class="actions">
                                            <a
                                                class="btn btn-info btn-sm"
                                                href="/servico/${servico.id}/atualizar"
                                                data-bs-toggle="tooltip"
                                                data-bs-placement="top"
                                                title="Editar"
                                            >
                                                <i
                                                    class="bi bi-check-circle text-light"
                                                ></i>
                                            </a>
                                            <a
                                                class="btn btn-danger btn-sm"
                                                href="#"
                                                data-bs-toggle="modal"
                                                data-bs-target="#confirm-delete-modal"
                                                data-href="/servico/${servico.id}/excluir"
                                                data-bs-toggle="tooltip"
                                                data-bs-placement="top"
                                                title="Excluir"
                                            >
                                                <i
                                                    class="bi bi-trash text-light"
                                                ></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /#list -->
            </main>
        </div>
        <%@ include file="../_includes/delete-modal.jsp"%>
        <%@ include file="../_includes/footer.jsp"%>
    </body>
</html>
