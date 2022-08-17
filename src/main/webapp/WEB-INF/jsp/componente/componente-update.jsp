<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<main class="container col-11 col-md-6" id="form-container">
    <div class="row gx-5">
        <div id="top" class="col-md-12">
            <h2 class="page-header">Atualizar Componente</h2>
        </div>
        <div class="col-md-12">
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
                <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="custo-compra" name="custo-compra" placeholder="Informe o custo de compra">
                        <label for="custo-compra" class="form-label">Informe o custo de compra</label>
                    </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="preco-venda" name="preco-venda" placeholder="Informe o preço de venda">
                    <label for="valor-frete" class="form-label">Informe o preço de venda</label>
                </div>
            </form>
        </div>
    </div>
    <div id="actions" class="row gx-5">
         <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Salvar</button>
            <a href="/componentes" class="btn btn-secondary">Cancelar</a>
        </div>
    </div>
</main>

<%@ include file="../common/footer.jspf"%>