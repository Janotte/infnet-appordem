<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<main class="container col-11 col-md-6" id="form-container">
    <div class="row gx-5">
        <div id="top" class="col-md-12">
            <h2 class="page-header">Visualizar Cliente</h2>
        </div>
        <div class="col-md-12">
            <div class="form-floating mb-3">
                <p><strong>Código</strong></p>
                <p>00001</p>
            </div>
            <div class="form-floating mb-3">
                <p><strong>Nome</strong></p>
                <p>Igor Cauê Aparício</p>
            </div>
            <div class="form-floating mb-3">
                <p><strong>CPF</strong></p>
                <p>111.111.111-11</p>
            </div>
            <div class="form-floating mb-3">
                <p><strong>Celular</strong></p>
                <p>(47) 98727-2303</p>
            </div>
           <div class="form-floating mb-3">
               <p><strong>E-mail</strong></p>
               <p>igorcaue@meudominio.com</p>
           </div>
        </div>
    </div>
    <hr/>
    <div id="actions" class="row gx-5">
         <div class="d-flex justify-content-center">
            <a href="/cliente-update/1" class="btn btn-primary">Editar</a>
            <a href="/clientes" class="btn btn-secondary">Fechar</a>
            <a href="#" class="btn btn-danger btn-xs" data-bs-toggle="modal" data-bs-target="#delete-modal">Excluir</a>
        </div>
    </div>
</main>
<%@ include file="../common/delete-modal.jspf"%>

<%@ include file="../common/footer.jspf"%>