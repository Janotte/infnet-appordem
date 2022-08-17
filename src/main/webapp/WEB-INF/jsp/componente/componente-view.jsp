<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<main class="container col-11 col-md-6" id="form-container">
    <div class="row gx-5">
        <div id="top" class="col-md-12">
            <h2 class="page-header">Visualizar Componente</h2>
        </div>
        <div class="col-md-12">
            <div class="form-floating mb-3">
                <p><strong>Código</strong></p>
                <p>00001</p>
            </div>
            <div class="form-floating mb-3">
                <p><strong>NCM</strong></p>
                <p>1111.11.11</p>
            </div>
            <div class="form-floating mb-3">
                <p><strong>Nome</strong></p>
                <p>Nome do componente 1</p>
            </div>
            <div class="form-floating mb-3">
                <p><strong>Preço de Venda</strong></p>
                <p>100,00</p>
            </div>
            <div class="form-floating mb-3">
                <p><strong>Custo de Compra</strong></p>
                <p>50,00</p>
            </div>
           <div class="form-floating mb-3">
               <p><strong>Valor de Compra</strong></p>
               <p>45,00</p>
           </div>
           <div class="form-floating mb-3">
              <p><strong>Valor do Frete</strong></p>
              <p>5,00</p>
          </div>
        </div>
    </div>
    <hr/>
    <div id="actions" class="row gx-5">
         <div class="d-flex justify-content-center">
            <a href="/componente-update/1" class="btn btn-primary">Editar</a>
            <a href="/componentes" class="btn btn-secondary">Fechar</a>
            <a href="#" class="btn btn-danger btn-xs" data-bs-toggle="modal" data-bs-target="#delete-modal">Excluir</a>
        </div>
    </div>
</main>
<%@ include file="../common/delete-modal.jspf"%>

<%@ include file="../common/footer.jspf"%>