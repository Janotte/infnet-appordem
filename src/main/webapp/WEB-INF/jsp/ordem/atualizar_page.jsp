<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/header.jspf"%>

<main class="container col-11 col-md-6 mb-50" id="form-container">
    <div id="top" class="row gx-5 ms-3">
        <h2 class="page-header">${pageTitle}</h2>
    </div> <!-- /#top -->
    <div id="form" class="row gx-5">
        <form:form action="${formAction}" method="POST" modelAttribute="ordem">
            <fieldset>
                <div class="row align-items-center gx-2">
                    <div class="form-floating col-md-2 mb-3">
                        <form:input path="id" type="text" class="form-control" name="id" readOnly="readOnly"/>
                        <form:label path="id" for="id" class="form-label ms-3" >Id</form:label>
                    </div>
                    <div class="form-floating col-md-4 mb-3">
                        <fmt:formatDate value="${ordem.dataAbertura}" pattern="dd/MM/yyyy HH:mm:ss" var="myDate" />
                        <input value="${myDate}" class="form-control" name="dataAbertura" readOnly="readOnly" />
                        <form:label path="dataAbertura" for="dataAbertura" class="form-label ms-3">Data de abertura</form:label>
                    </div>
                    <div class="form-floating col-md-3 mb-3">
                        <form:select path="situacao" class="form-select" aria-label="Situação">
                            <option selected>Selecione a situação</option>
                            <form:option value="ABERTA">Aberta</form:option>
                            <form:option value="ANALISE">Em análise</form:option>
                            <form:option value="CONCLUIDA">Concluída</form:option>
                        </form:select>
                        <form:label path="situacao" for="situacao" class="form-label ms-3">Situação</form:label>
                    </div>
                    <div class="form-floating col-md-3 mb-3">
                        <form:select path="tipoAtendimento" class="form-select" aria-label="Tipo de Atendimento">
                            <option selected>Selecione o tipo de Atendimento</option>
                            <form:option value="INTERNO">Interno</form:option>
                            <form:option value="REMOTO">Remoto</form:option>
                            <form:option value="EXTERNO">Concluída</form:option>
                        </form:select>
                        <form:label path="tipoAtendimento" for="tipoAtendimento" class="form-label ms-3">Tipo de Atendimento</form:label>
                    </div>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="cliente.nome" type="text" class="form-control" name="cliente" placeholder="Cliente"/>
                    <form:label path="cliente" for="cliente" class="form-label">Cliente</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="equipamento" type="text" class="form-control" name="equipamento" placeholder="Equipamento"/>
                    <form:label path="equipamento" for="equipamento" class="form-label">Equipamento</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="problema" type="text" class="form-control" name="problema" placeholder="Problema"/>
                    <form:label path="problema" for="problema" class="form-label">Problema</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="solucao" type="text" class="form-control" name="problema" placeholder="Solução"/>
                    <form:label path="solucao" for="solucao" class="form-label">Solução</form:label>
                </div>
                <table class="table table-striped" cellspacing="0" cellpadding="0">

                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Qt</th>
                                <th scope="col">Valor</th>
                                <th scope="col" class="actions">Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ordem.produtos}" var="item">
                               <tr>
                                   <td>${item.id}</td>
                                   <td>${item.nome}</td>
                                   <td>1</td>
                                   <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.precoVenda}" /></td>
                                   <td class="actions">
                                       <a class="btn btn-info btn-sm" href="/ordem/produtos/${item.id}/atualizar"
                                           data-bs-toggle="tooltip" data-bs-placement="top" title="Editar">
                                           <i class="bi bi-check-circle text-light"></i>
                                       </a>
                                       <a class="btn btn-danger btn-sm" href="#"
                                          data-bs-toggle="modal" data-bs-target="#confirm-delete-modal" data-href="/ordem/produtos/${item.id}/excluir"
                                          data-bs-toggle="tooltip" data-bs-placement="top" title="Excluir">
                                          <i class="bi bi-trash text-light"></i>
                                      </a>
                                   </td>
                               </tr>

                            </c:forEach>
                        </tbody>
                </table>
                <div class="form-floating mb-3">
                    <form:input path="observacao" type="text" class="form-control" name="observacao" placeholder="Observações"/>
                    <form:label path="observacao" for="observacao" class="form-label">Observações</form:label>
                </div>
            </fieldset>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">${pageTitle}</button>
                <a href="/ordens" class="btn btn-secondary">Cancelar</a>
            </div>
        </form:form>
    </div> <!-- /#form -->
</main> <!-- /#main -->

<%@ include file="../common/footer.jspf"%>