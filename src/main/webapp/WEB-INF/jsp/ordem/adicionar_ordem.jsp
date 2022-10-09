<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
    <head>
        <%@ include file="../_includes/head.jsp"%>
        <title>${pageTitle}</title>
    </head>
    <body>
        <c:set var="checkbtn" value=""> </c:set>
        <div class="container-fluid">
            <%@ include file="../_includes/navbar.jsp"%>
            <main class="container col-11 col-md-6" id="form-container">
                <div id="top" class="row gx-5 ms-3">
                    <h2 class="page-header">${pageTitle}</h2>
                </div>
                <!-- /#top -->
                <div id="form" class="row gx-5">
                    <form
                        action="${formAction}"
                        method="POST"
                        modelAttribute="ordem"
                    >
                        <fieldset>
                            <div class="row align-items-center gx-2">
                                <div class="form-floating col-md-6 mb-1">
                                    <select
                                        name="situacao"
                                        class="form-select"
                                        aria-label="Situação"
                                        required="required"
                                    >
                                        <option
                                            selected
                                            value="${ordem.situacao}"
                                        >
                                            Selecione o Situação
                                        </option>
                                        <option value="ABERTA">Aberta</option>
                                        <option value="ANALISE">Análise</option>
                                        <option value="CONCLUIDA">
                                            Concluída
                                        </option>
                                    </select>
                                    <label
                                        for="tipoAtendimento"
                                        class="form-label ms-3"
                                        >Situação</label
                                    >
                                </div>
                                <div class="form-floating col-md-6 mb-1">
                                    <select
                                        name="tipoAtendimento"
                                        class="form-select"
                                        aria-label="Tipo de Atendimento"
                                        required="required"
                                    >
                                        <option
                                            selected
                                            value="${ordem.tipoAtendimento}"
                                        >
                                            Selecione o tipo de Atendimento
                                        </option>
                                        <option value="INTERNO">Interno</option>
                                        <option value="REMOTO">Remoto</option>
                                        <option value="EXTERNO">Externo</option>
                                    </select>
                                    <label
                                        for="tipoAtendimento"
                                        class="form-label ms-3"
                                        >Tipo de Atendimento</label
                                    >
                                </div>
                            </div>
                            <div class="form-floating mb-1">
                                <c:if test="${not empty clienteList}">
                                    <select
                                        name="cliente"
                                        class="form-select form-floating mb-3"
                                        aria-label=".form-select-lg cliente"
                                        required="required"
                                    >
                                        <option selected>
                                            Selecione o cliente
                                        </option>
                                        <c:forEach
                                            var="cliente"
                                            items="${clienteList}"
                                        >
                                            <option value="${cliente.id}">
                                                ${cliente.nome}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <label for="clienteId" class="form-label"
                                        >Cliente</label
                                    >
                                </c:if>
                                <c:if test="${empty clienteList}">
                                    <c:set
                                        var="checkbtn"
                                        value="disabled"
                                    ></c:set>
                                    <select
                                        name="clienteId"
                                        id="clienteId"
                                        class="form-select form-floating mb-3"
                                        aria-label=".form-select-lg cliente"
                                    >
                                        <option selected>
                                            Não existe clientes cadastrados
                                        </option>
                                    </select>
                                    <label for="clienteId" class="form-label"
                                        >Cliente</label
                                    >
                                </c:if>
                            </div>
                            <div class="form-floating mb-1">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="equipamento"
                                    placeholder="Equipamento"
                                    value="${ordem.equipamento}"
                                    required="required"
                                />
                                <label for="equipamento" class="form-label"
                                    >Equipamento</label
                                >
                            </div>
                            <div class="form-floating mb-1">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="problema"
                                    placeholder="Problema"
                                    value="${ordem.problema}"
                                    required="required"
                                />
                                <label for="problema" class="form-label"
                                    >Problema</label
                                >
                            </div>
                            <div class="form-floating mb-1">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="solucao"
                                    value="${ordem.solucao}"
                                    placeholder="Solução"
                                />
                                <label for="solucao" class="form-label"
                                    >Solução</label
                                >
                            </div>
                            <div class="form-floating mb-1">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="observacao"
                                    value="${ordem.observacao}"
                                    placeholder="Observações"
                                />
                                <label for="observacao" class="form-label"
                                    >Observações</label
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
                                            <label for="produtos">
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
                            <c:if test="${empty produtoList}">
                                <c:set var="checkbtn" value="disabled"></c:set>
                                <div class="form-floating mb-1">
                                    <input
                                        type="text"
                                        class="form-control"
                                        name="produtos"
                                        value="Não existe produtos cadastrados"
                                        placeholder="Observações"
                                    />
                                    <label for="produtos" class="form-label"
                                        >Produtos</label
                                    >
                            </c:if>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <input
                                ${checkbtn}
                                type="submit"
                                class="btn btn-primary"
                                value="${pageTitle}"
                            />
                            <a href="/ordens" class="btn btn-link">Cancelar</a>
                        </div>
                    </form>
                </div>
                <!-- /#form -->
            </main>
        </div>
        <%@ include file="../_includes/footer.jsp"%>
    </body>
</html>
