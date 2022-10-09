<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
                                    path="ncm"
                                    type="text"
                                    class="form-control"
                                    id="ncm"
                                    name="ncm"
                                    placeholder="Informe o NCM"
                                />
                                <label path="ncm" for="ncm" class="form-label"
                                    >Informe o NCM</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    path="nome"
                                    type="text"
                                    class="form-control"
                                    id="nome"
                                    name="nome"
                                    placeholder="Informe seu nome"
                                />
                                <label path="nome" for="nome" class="form-label"
                                    >Informe seu nome</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    path="valorCompra"
                                    type="text"
                                    class="form-control"
                                    name="valorCompra"
                                    placeholder="Informe o valor de compra"
                                />
                                <label
                                    path="valorCompra"
                                    for="valorCompra"
                                    class="form-label"
                                    >Informe o valor de compra</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    path="valorFrete"
                                    type="text"
                                    class="form-control"
                                    name="valorFrete"
                                    placeholder="Informe o valor do frete"
                                />
                                <label
                                    path="valorFrete"
                                    for="valorFrete"
                                    class="form-label"
                                    >Informe o valor do frete</label
                                >
                            </div>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-primary">
                                ${pageTitle}
                            </button>
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
