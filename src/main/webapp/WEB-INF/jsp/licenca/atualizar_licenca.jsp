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
                        modelAttribute="licenca"
                    >
                        <fieldset>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="id"
                                    name="id"
                                    readOnly="readOnly"
                                    value="${licenca.id}"
                                />
                                <label for="id" class="form-label">Id</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    id="nome"
                                    name="nome"
                                    placeholder="Nome"
                                    value="${licenca.nome}"
                                />
                                <label for="nome" class="form-label"
                                    >Nome</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="custoCompra"
                                    placeholder="Custo de compra"
                                    value="${licenca.custoCompra}"
                                />
                                <label for="custoCompra" class="form-label"
                                    >Custo de Compra</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="number"
                                    class="form-control"
                                    name="quantidadeDispositivos"
                                    placeholder="Quantidade de dispositivos"
                                    value="${licenca.quantidadeDispositivos}"
                                />
                                <label
                                    for="quantidadeDispositivos"
                                    class="form-label"
                                    >Quantidade de dispositivos</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="validade"
                                    placeholder="Validade"
                                    value="${licenca.validade}"
                                />
                                <label for="validade" class="form-label"
                                    >Validade</label
                                >
                            </div>
                            <div class="form-floating mb-3">
                                <input
                                    type="text"
                                    class="form-control"
                                    name="fabricante"
                                    placeholder="Fabricante"
                                    value="${licenca.fabricante}"
                                />
                                <label for="fabricante" class="form-label"
                                    >Fabricante</label
                                >
                            </div>
                        </fieldset>
                        <div class="d-flex justify-content-center">
                            <input
                                type="submit"
                                class="btn btn-primary"
                                value="${pageTitle}"
                            />
                            <a href="/licencas" class="btn btn-link"
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
