<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/header.jspf"%>

<header>
    <%@ include file="../common/navigation.jspf"%>
</header>

<main class="container col-11 col-md-6" id="form-container">
    <div id="top" class="row gx-5 ms-3">
        <h2 class="page-header">${pageTitle}</h2>
    </div> <!-- /#top -->
    <div id="form" class="row gx-5">
        <form:form action="${formAction}" method="POST" modelAttribute="servico">
            <fieldset>
                <div class="form-floating mb-3">
                   <form:input path="id" type="text" class="form-control" name="id"/>
                   <form:label path="id" for="id" class="form-label">Id</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="nome" type="text" class="form-control" name="nome" placeholder="Nome"/>
                   <form:label path="nome" for="nome" class="form-label">Nome</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="custoCompra" type="text" class="form-control" name="custoCompra" placeholder="Custo de compra"/>
                   <form:label path="custoCompra" for="custoCompra" class="form-label">Custo de Compra</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="precoVenda" type="text" class="form-control" name="precoVenda" placeholder="Informe o preco de venda"/>
                   <form:label path="precoVenda" for="precoVenda" class="form-label">Preço de Venda</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="garantia" type="text" class="form-control" name="garantia" placeholder="Garantia"/>
                   <form:label path="garantia" for="garantia" class="form-label">Garantia</form:label>
                </div>
                <div class="form-floating mb-3">
                    <form:select path="tipoServico" class="form-select" aria-label="Tipo de Serviço">
                      <option selected>Selecione o tipo de serviço</option>
                        <form:option value="MANUTENCAO_SISTEMAS">Manutenção de sistemas</form:option>
                        <form:option value="MANUTENCAO_HARDWARE">Manutenção de hardware</form:option>
                        <form:option value="MANUTENCAO_INFRAESTRUTURA">Manutenção de infra estrutura</form:option>
                    </form:select>
                    <form:label path="tipoServico" for="tipoServico" class="form-label">Tipo de serviço</form:label>
                </div>
                <div class="form-floating mb-3">
                   <form:input path="classificacaoFiscal" type="text" class="form-control" name="classificacaoFiscal" placeholder="Classificação fiscal"/>
                   <form:label path="classificacaoFiscal" for="classificacaoFiscal" class="form-label">Classificação Fiscal</form:label>
                </div>
            </fieldset>
             <div class="d-flex justify-content-center">
                <input type="submit" class="btn btn-primary" value=${pageTitle}>
                <a href="/servicos" class="btn btn-link">Cancelar</a>
            </div>
        </form:form>
    </div> <!-- /#form -->
</main> <!-- /#main -->

<%@ include file="../common/footer.jspf"%>