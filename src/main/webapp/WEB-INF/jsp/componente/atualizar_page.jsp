<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/header.jspf"%>

<header>
    <%@ include file="../common/navigation.jspf"%>
</header>

<main class="container col-11 col-md-6" id="form-container">
    <div id="top" class="row gx-5 ms-3">
        <h2 class="page-header">${pageTitle}</h2>
    </div> <!-- /#top -->
    <div id="form" class="row gx-5">
        <form:form action="${formAction}" method="POST" modelAttribute="componente">
            <fieldset>
                <div class="form-floating mb-3">
                    <form:input path="id" type="text" class="form-control" id="id" name="id" readOnly="readOnly"/>
                    <form:label path="id" for="id" class="form-label">Id</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="ncm" type="text" class="form-control" id="ncm" name="ncm" placeholder="Informe o NCM"/>
                    <form:label path="ncm" for="ncm" class="form-label">NCM</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="nome" type="text" class="form-control" id="nome" name="nome" placeholder="Informe seu nome"/>
                    <form:label path="nome" for="nome" class="form-label">Nome</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="valorCompra" type="text" class="form-control" name="valorFrete" placeholder="Valor de Compra"/>
                    <form:label path="valorCompra" for="valorCompra" class="form-label">Valor de Compra</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="valorFrete" class="form-control" type="text" min="0" name="valorFrete" placeholder="Valor do frete"/>
                    <form:label path="valorFrete" for="valorFrete" class="form-label">Valor do Frete</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="custoCompra" class="form-control" type="text" min="0" name="custoCompra" placeholder="Custo de compra"/>
                    <form:label path="custoCompra" for="custoCompra" class="form-label">Custo de Compra</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:input path="precoVenda" class="form-control" type="text" min="0" name="precoVenda" placeholder="Preço de venda"/>
                    <form:label path="precoVenda" for="precoVenda" class="form-label">Preço de venda</form:label>
                </div>
            </fieldset>
             <div class="d-flex justify-content-center">
                <input type="submit" class="btn btn-primary" value=${pageTitle}>
                <a href="/componentes" class="btn btn-link">Cancelar</a>
            </div>
        </form:form>
    </div> <!-- /#form -->
</main> <!-- /#main -->

<%@ include file="../common/footer.jspf"%>