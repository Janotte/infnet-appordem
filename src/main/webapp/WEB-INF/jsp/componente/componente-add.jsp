<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<main class="container col-11 col-md-6" id="form-container">
    <div id="top" class="row gx-5 ms-3">
        <h2 class="page-header">Adicionar Componente</h2>
    </div> <!-- /#top -->
    <div id="form" class="row gx-5">
        <form>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="ncm" name="ncm" placeholder="Informe o NCM">
                <label for="ncm" class="form-label">Informe o NCM</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="nome" name="nome" placeholder="Informe seu nome">
                <label for="nome" class="form-label">Informe seu nome</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="valor-compra" name="valor-compra" placeholder="Informe o valor de compra">
                <label for="valor-compra" class="form-label">Informe o valor de compra</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="valor-frete" name="valor-frete" placeholder="Informe o valor do frete">
                <label for="valor-frete" class="form-label">Informe o valor do frete</label>
            </div>
        </form>
    </div> <!-- /#form -->
    <div id="actions" class="row gx-5">
         <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Salvar</button>
            <a href="/componentes" class="btn btn-secondary">Cancelar</a>
        </div>
    </div> <!-- /#actions -->
</main> <!-- /#main -->

<%@ include file="../common/footer.jspf"%>