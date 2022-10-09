<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@page
import="java.text.DecimalFormat"%> <% DecimalFormat df = new
DecimalFormat("#.##"); request.setAttribute("df", df); %>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
    <head>
        <%@ include file="../_includes/head.jsp"%>
        <title>${pageTitle}</title>
    </head>
    <body>
        <div class="container-fluid">
            <%@ include file="../_includes/navbar.jsp"%>
            <main class="container col-11 col-md-6" id="form-container">
                <div id="top" class="row gx-5 ms-3">
                    <h2 class="page-header">${pageTitle}</h2>
                </div>
                <!-- /#top -->
                <div id="form" class="row gx-5">
                    <form:form
                        action="${formAction}"
                        method="POST"
                        modelAttribute="ordem"
                    >
                        <fieldset>
                            <div class="row align-items-center gx-2">
                                <div class="form-floating col-md-3 mb-1">
                                    <form:input
                                        path="id"
                                        type="text"
                                        class="form-control"
                                        name="id"
                                        readOnly="readOnly"
                                    />
                                    <form:label
                                        path="id"
                                        for="id"
                                        class="form-label ms-3"
                                        >Id</form:label
                                    >
                                </div>
                                <div class="form-floating col-md-3 mb-1">
                                    <fmt:formatDate
                                        value="${ordem.data}"
                                        pattern="dd/MM/yyyy HH:mm:ss"
                                        var="myDate"
                                    />
                                    <input
                                        value="${myDate}"
                                        class="form-control"
                                        name="data"
                                        readOnly="readOnly"
                                    />
                                    <form:label
                                        path="data"
                                        for="data"
                                        class="form-label ms-3"
                                        >Data</form:label
                                    >
                                </div>
                                <div class="form-floating col-md-3 mb-1">
                                    <form:select
                                        path="situacao"
                                        name="situacao"
                                        class="form-select"
                                        aria-label="Situação"
                                    >
                                        <option selected>
                                            Selecione a situação
                                        </option>
                                        <form:option value="ABERTA"
                                            >Aberta</form:option
                                        >
                                        <form:option value="ANALISE"
                                            >Em análise</form:option
                                        >
                                        <form:option value="CONCLUIDA"
                                            >Concluída</form:option
                                        >
                                    </form:select>
                                    <form:label
                                        path="situacao"
                                        for="situacao"
                                        class="form-label ms-3"
                                        >Situação</form:label
                                    >
                                </div>
                                <div class="form-floating col-md-3 mb-1">
                                    <form:select
                                        path="tipoAtendimento"
                                        class="form-select"
                                        aria-label="Tipo de Atendimento"
                                        required="required"
                                    >
                                        <option selected>
                                            Selecione o tipo de Atendimento
                                        </option>
                                        <form:option value="INTERNO"
                                            >Interno</form:option
                                        >
                                        <form:option value="REMOTO"
                                            >Remoto</form:option
                                        >
                                        <form:option value="EXTERNO"
                                            >Concluída</form:option
                                        >
                                    </form:select>
                                    <form:label
                                        path="tipoAtendimento"
                                        for="tipoAtendimento"
                                        class="form-label ms-3"
                                        >Tipo de Atendimento</form:label
                                    >
                                </div>
                            </div>
                            <div class="form-floating mb-1">
                                <form:select
                                    path="cliente.id"
                                    class="form-select form-floating mb-3"
                                    aria-label="Cliente"
                                    required="required"
                                >
                                    <option selected value="${cliente.id}">
                                        Selecione o cliente
                                    </option>
                                    <c:forEach
                                        var="cliente"
                                        items="${clienteList}"
                                    >
                                        <form:option value="${cliente.id}">
                                            ${cliente.nome}
                                        </form:option>
                                    </c:forEach>
                                </form:select>
                                <label
                                    path="clienteId"
                                    for="clienteId"
                                    class="form-label"
                                    >Cliente</label
                                >
                            </div>
                            <div class="form-floating mb-1">
                                <form:input
                                    type="text"
                                    class="form-control"
                                    path="equipamento"
                                    placeholder="Equipamento"
                                    required="required"
                                />
                                <form:label
                                    path="equipamento"
                                    for="equipamento"
                                    class="form-label"
                                    >Equipamento</form:label
                                >
                            </div>
                            <div class="form-floating mb-1">
                                <form:input
                                    type="text"
                                    class="form-control"
                                    path="problema"
                                    placeholder="Problema"
                                    required="required"
                                />
                                <form:label
                                    path="problema"
                                    for="problema"
                                    class="form-label"
                                    >Problema</form:label
                                >
                            </div>
                            <div class="form-floating mb-1">
                                <form:input
                                    type="text"
                                    class="form-control"
                                    path="solucao"
                                    placeholder="Solução"
                                />
                                <form:label
                                    path="solucao"
                                    for="solucao"
                                    class="form-label"
                                    >Solução</form:label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <form:input
                                    type="text"
                                    class="form-control"
                                    path="observacao"
                                    value="${ordem.observacao}"
                                    placeholder="Observações"
                                />
                                <form:label
                                    path="observacao"
                                    for="observacao"
                                    class="form-label"
                                    >Observações</form:label
                                >
                            </div>
                            <c:if test="${not empty produtoList}">
                                <label for="produtos" class="form-label"
                                    >Produtos</label
                                >
                                <div class="col-md-6 mb-1">
                                    <c:forEach
                                        var="produto"
                                        items="${produtoList}"
                                    >
                                        <div class="checkbox">
                                            <label>
                                                <input
                                                    type="checkbox"
                                                    name="produtos"
                                                    value="${produto.id}"
                                                />
                                                ${produto.nome}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <input
                                type="submit"
                                class="btn btn-primary"
                                value="${pageTitle}"
                            />
                            <a href="/ordens" class="btn btn-link">Cancelar</a>
                        </div>
                    </form:form>
                </div>
                <!-- /#form -->
            </main>
        </div>
        <%@ include file="../_includes/footer.jsp"%>
    </body>
</html>
