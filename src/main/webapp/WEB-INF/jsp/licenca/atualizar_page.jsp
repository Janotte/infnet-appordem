<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/header.jspf"%>

<main class="container col-11 col-md-6" id="form-container">
    <div id="top" class="row gx-5 ms-3">
        <h2 class="page-header">${pageTitle}</h2>
    </div> <!-- /#top -->
    <div id="form" class="row gx-5">
        <form:form action="${formAction}" method="POST" modelAttribute="licenca">
            <fieldset>
                <div class="form-floating mb-3">
                   <form:input path="id" type="text" class="form-control" id="id" name="id" readOnly="readOnly"/>
                   <form:label path="id" for="id" class="form-label">Id</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="nome" type="text" class="form-control" id="nome" name="nome" placeholder="Informe seu nome"/>
                   <form:label path="nome" for="nome" class="form-label">Nome</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="custoCompra" type="text" class="form-control" name="custoCompra" placeholder="Informe o custo de compra"/>
                   <form:label path="custoCompra" for="custoCompra" class="form-label">Custo de Compra</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="precoVenda" type="text" class="form-control" name="precoVenda" placeholder="Informe o preco de venda"/>
                   <form:label path="precoVenda" for="precoVenda" class="form-label">Preço de Venda</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="quantidadeDispositivos" type="text" class="form-control" name="quantidadeDispositivos" placeholder="Informe a quantidade de dispositivos"/>
                   <form:label path="quantidadeDispositivos" for="quantidadeDispositivos" class="form-label">Quantidade de dispositivos</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="validade" type="text" class="form-control" name="validade" placeholder="Informe a validade"/>
                   <form:label path="validade" for="validade" class="form-label">Validade</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="fabricante" type="text" class="form-control" name="fabricante" placeholder="Informe o fabricante"/>
                   <form:label path="fabricante" for="fabricante" class="form-label">Fabricante</form:label>
                </div>
            </fieldset>
             <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">${pageTitle}</button>
                <a href="/licencas" class="btn btn-secondary">Cancelar</a>
            </div>
        </form:form>
    </div> <!-- /#form -->
</main> <!-- /#main -->

<%@ include file="../common/footer.jspf"%>