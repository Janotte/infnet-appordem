<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/header.jspf"%>

<main class="container-flex col-12">
    <div id="top" class="row d-flex align-items-baseline">
        <div class="col-md-3 ms-3">
            <h2>Clientes</h2>
        </div>
        <div class="col-md-5">
            <div class="input-group h2">
                <input name="data[search]" class="form-control" id="search" type="text"
                    placeholder="Pesquisar Clientes">
                <span class="input-group-btn ms-2">
                    <button class="btn btn-primary" type="submit">
                        <i class="bi bi-search"></i>
                    </button>
                </span>
            </div>
        </div>
        <div class="col-md-3">
            <a href="/cliente/adicionar" class="btn btn-primary">Novo Cliente</a>
        </div>
    </div> <!-- /#top -->
    <hr>
    <div id="list" class"row">
        <div class="table-responsive col-md-12">
            <table class="table table-striped" cellspacing="0" cellpadding="0">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF/CNPJ</th>
                        <th scope="col">Celular</th>
                        <th scope="col">E-mail</th>
                        <th scope="col" class="actions">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${clienteList}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.nome}</td>
                            <td>${item.cpfCnpj}</td>
                            <td>${item.celular}</td>
                            <td>${item.email}</td>
                            <td class="actions">
                                <a class="btn btn-info btn-sm" href="/cliente/${item.id}/atualizar"
                                    data-bs-toggle="tooltip" data-bs-placement="top" title="Editar">
                                    <i class="bi bi-check-circle text-light"></i>
                                </a>
                                <a class="btn btn-danger btn-sm" href="#"
                                   data-bs-toggle="modal" data-bs-target="#confirm-delete-modal" data-href="/cliente/${item.id}/excluir"
                                   data-bs-toggle="tooltip" data-bs-placement="top" title="Excluir">
                                   <i class="bi bi-trash text-light"></i>
                               </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div> <!-- /#list -->
    <div id="bottom" class="row">
        <%@ include file="../common/pagination.jspf"%>
    </div> <!-- /#bottom -->

</div> <!-- /#main -->

<%@ include file="../common/delete-modal.jspf"%>

<%@ include file="../common/footer.jspf"%>