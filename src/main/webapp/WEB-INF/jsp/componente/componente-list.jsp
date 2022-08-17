<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<main class="container-flex col-12">
    <div id="top" class="row d-flex align-items-baseline">
        <div class="col-md-3 ms-3">
            <h2>Componentes</h2>
        </div>
        <div class="col-md-5">
            <div class="input-group h2">
                <input name="data[search]" class="form-control" id="search" type="text"
                    placeholder="Pesquisar Componentes">
                <span class="input-group-btn ms-2">
                    <button class="btn btn-primary" type="submit">
                        <i class="bi bi-search"></i>
                    </button>
                </span>
            </div>
        </div>
        <div class="col-md-3">
            <a href="componente-add" class="btn btn-primary">Novo Componente</a>
        </div>
    </div> <!-- /#top -->
    <hr>
    <div id="list" class"row">
        <div class="table-responsive col-md-12">
            <table class="table table-striped" cellspacing="0" cellpadding="0">
                <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Preço de Venda</th>
                        <th scope="col" class="actions">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>00001</td>
                        <td>Nome do componente 1</td>
                        <td>R$ 100,00</td>
                        <td class="actions">
                            <a class="btn btn-success btn-xs" href="componente-view/1"
                                data-bs-toggle="tooltip" data-bs-placement="top" title="Visualizar">
                                <i class="bi bi-card-text"></i>
                            </a>
                            <a class="btn btn-warning btn-xs" href="componente-update/1"
                                data-bs-toggle="tooltip" data-bs-placement="top" title="Editar">
                                <i class="bi bi-check-circle text-light"></i>
                            </a>
                            <a class="btn btn-danger btn-xs" href="#"
                                data-bs-toggle="modal" data-bs-target="#delete-modal"
                                data-bs-toggle="tooltip" data-bs-placement="top" title="Excluir">
                                <i class="bi bi-trash text-light"></i>
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div> <!-- /#list -->
    <div id="bottom" class="row">
        <%@ include file="../common/pagination.jspf"%>
    </div> <!-- /#bottom -->

</div> <!-- /#main -->

<%@ include file="../common/footer.jspf"%>