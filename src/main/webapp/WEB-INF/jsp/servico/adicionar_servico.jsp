<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
    <head>
        <%@ include file="../_includes/head.jsp"%>
        <title>${pageTitle}</title>
    </head>
    <body>
        <div class="container-fluid">
            <%@ include file="../_includes/navbar.jsp"%>
            <main class="container col-11 col-md-6" id="form-container">
                <div id="top" class="row gx-5 ms-3">
                    <h2 class="page-header">${pageTitle}</h2>
                </div>
                <!-- /#top -->
                <div class="row gx-5" id="form-container">
                    <form
                        action="${formAction}"
                        method="POST"
                        modelAttribute="servico"
                    >
                        <fieldset>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="nome"
                                    name="nome"
                                    placeholder="Nome"
                                    value="${servico.nome}"
                                />
                                <label
                                    for="nome"
                                    class="form-label"
                                    >Nome</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="custoCompra"
                                    placeholder="Custo de compra"
                                    value="${servico.custoCompra}"
                                />
                                <label
                                    for="custoCompra"
                                    class="form-label"
                                    >Custo de Compra</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="garantia"
                                    placeholder="Garantia"
                                    value="${servico.garantia}"
                                />
                                <label
                                    for="garantia"
                                    class="form-label"
                                    >Garantia</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <select
                                    name="tipoServico"
                                    class="form-select"
                                    aria-label="Tipo de Serviço"
                                    
                                >
                                    <option selected value="${servico.tipoServico}">
                                        Selecione o tipo de serviço
                                    </option>
                                    <option value="MANUTENCAO_SISTEMAS"
                                        >Manutenção de sistemas</option
                                    >
                                    <option value="MANUTENCAO_HARDWARE"
                                        >Manutenção de hardware</option
                                    >
                                    <option
                                        value="MANUTENCAO_INFRAESTRUTURA"
                                        >Manutenção de infra
                                        estrutura</option
                                    >
                                </select>
                                <label
                                    for="tipoServico"
                                    class="form-label"
                                    >Tipo de serviço</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="classificacaoFiscal"
                                    placeholder="Classificação fiscal"
                                    value="${servico.classificacaoFiscal}"
                                />
                                <label
                                    for="classificacaoFiscal"
                                    class="form-label"
                                    >Classificação Fiscal</label
                                >
                            </div>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-primary">
                                ${pageTitle}
                            </button>
                            <a href="/servicos" class="btn btn-link"
                                >Cancelar</a
                            >
                        </div>
                    </form>
                </div>
                <!-- /#form -->
            </main>
        </div>
        <%@ include file="../_includes/footer.jsp"%>
    </body>
</html>
