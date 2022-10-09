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
                <div class="row gx-5" id="form-container">
                    <form
                        action="${formAction}"
                        method="POST"
                        modelAttribute="cliente"
                    >
                        <fieldset>
                            <div class="form-floating mb-3">
                                <input
                                    path="nome"
                                    type="text"
                                    class="form-control"
                                    name="nome"
                                    placeholder="Nome"
                                />
                                <label path="nome" for="nome" class="form-label"
                                    >Nome</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    path="cpfCnpj"
                                    type="text"
                                    class="form-control"
                                    name="cpfCnpj"
                                    placeholder="CPF ou CNPJ"
                                />
                                <label
                                    path="cpfCnpj"
                                    for="cpfCnpj"
                                    class="form-label"
                                    >CPF ou CNPJ</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    path="celular"
                                    type="text"
                                    class="form-control"
                                    name="celular"
                                    placeholder="Celular"
                                />
                                <label
                                    path="celular"
                                    for="celular"
                                    class="form-label"
                                    >Celular</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    path="email"
                                    type="email"
                                    class="form-control"
                                    name="email"
                                    placeholder="E-mail"
                                />
                                <label
                                    path="email"
                                    for="email"
                                    class="form-label"
                                    >E-mail</label
                                >
                            </div>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <button
                                var="${validaForm}"
                                type="submit"
                                class="btn btn-primary"
                            >
                                ${pageTitle}
                            </button>
                            <a href="/clientes" class="btn btn-link"
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
