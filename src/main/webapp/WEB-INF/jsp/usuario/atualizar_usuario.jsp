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
                        modelAttribute="usuario"
                    >
                        <fieldset>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="id"
                                    name="id"
                                    value="${usuario.id}"
                                    readOnly="readOnly"
                                />
                                <label for="id" class="form-label">Id</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="nome"
                                    name="nome"
                                    placeholder="Informe seu Nome"
                                    value="${usuario.nome}"
                                />
                                <label path="nome" for="nome" class="form-label"
                                    >Informe seu Nome</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="email"
                                    name="email"
                                    placeholder="Informe seu E-mail"
                                    value="${usuario.email}"
                                />
                                <label for="email" class="form-label"
                                    >Informe seu E-mail</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="password"
                                    class="form-control"
                                    name="senha"
                                    placeholder="Informe sua Senha"
                                    value="${usuario.senha}"
                                />
                                <label for="senha" class="form-label"
                                    >Informe sua Senha</label
                                >
                            </div>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <input
                                type="submit"
                                class="btn btn-primary"
                                value="${pageTitle}"
                            />
                            <a href="/usuarios" class="btn btn-link"
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
