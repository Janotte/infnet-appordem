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
                <div id="form" class="row gx-5">
                    <form
                        action="${formAction}"
                        method="POST"
                        modelAttribute="componente"
                    >
                        <fieldset>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="id"
                                    name="id"
                                    readOnly="readOnly"
                                    value="${componente.id}"
                                />
                                <label for="id" class="form-label">Id</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="ncm"
                                    name="ncm"
                                    placeholder="Informe o NCM"
                                    value="${componente.ncm}"
                                />
                                <label for="ncm" class="form-label">NCM</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="nome"
                                    name="nome"
                                    placeholder="Informe seu nome"
                                    value="${componente.nome}"
                                />
                                <label for="nome" class="form-label"
                                    >Nome</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="valorCompra"
                                    placeholder="Valor de Compra"
                                    value="${componente.valorCompra}"
                                />
                                <label for="valorCompra" class="form-label"
                                    >Valor de Compra</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    class="form-control"
                                    type="text"
                                    min="0"
                                    name="valorFrete"
                                    placeholder="Valor do frete"
                                    value="${componente.valorFrete}"
                                />
                                <label for="valorFrete" class="form-label"
                                    >Valor do Frete</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    class="form-control"
                                    type="text"
                                    min="0"
                                    name="custoCompra"
                                    placeholder="Custo de compra"
                                    value="${componente.custoCompra}"
                                />
                                <label for="custoCompra" class="form-label"
                                    >Custo de Compra</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    class="form-control"
                                    type="text"
                                    min="0"
                                    name="precoVenda"
                                    placeholder="Preço de venda"
                                    value="${componente.precoVenda}"
                                />
                                <label for="precoVenda" class="form-label"
                                    >Preço de venda</label
                                >
                            </div>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <input
                                type="submit"
                                class="btn btn-primary"
                                value="${pageTitle}"
                            />
                            <a href="/componentes" class="btn btn-link"
                                >Cancelar</a
                            >
                        </div>
                    </form>
                </div>
                <!-- /#form -->
            </main>
            <!-- /#main -->
        </div>
        <%@ include file="../_includes/footer.jsp"%>
    </body>
</html>
