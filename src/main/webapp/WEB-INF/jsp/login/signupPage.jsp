<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/header.jspf"%>

<main class="container-flex col-12">
    <div class="container col-11 col-md-9" id="form-container">
        <div class="row gx-5">
            <div class="col-md-6">
                <h2>Fazer o cadastro</h2>
                <form:form action="${formAction}" method="POST" modelAttribute="usuario">
                    <fieldset>
                        <div class="form-floating mb-3">
                           <form:input path="nome" type="text" class="form-control" id="nome" name="nome" placeholder="Informe seu Nome"/>
                           <form:label path="nome" for="nome" class="form-label">Informe seu Nome</form:label>
                        </div>
                        <div class="form-floating mb-3">
                           <form:input path="email" type="text" class="form-control" id="email" name="email" placeholder="Informe seu E-mail"/>
                           <form:label path="email" for="email" class="form-label">Informe seu E-mail</form:label>
                        </div>
                        <div class="form-floating mb-3">
                           <form:input path="senha" type="password" class="form-control" name="senha" placeholder="Informe sua Senha"/>
                           <form:label path="senha" for="senha" class="form-label">Informe sua Senha</form:label>
                        </div>

                        <div class="mb-3">
                            <div class="form-check mb-2">
                                <input type="checkbox" class="form-check-input" id="agree-form" name="agree-form">
                                <label for="agree-form" class="form-check-label">Concordo com os <a href="#">termos de serviço</a></label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <div class="form-check mb-2">
                                <input type="checkbox" class="form-check-input" id="newsletter" name="newsletter" checked>
                                <label for="newsletter" class="form-check-label">Aceito receber as NewsLetters</label>
                            </div>
                        </div>
                    <fieldset>
                    <div class="d-flex justify-content-center">
                        <input type="submit" class="btn btn-primary" value=${pageTitle}>
                    </div>
                </form:form>
            </div>
            <div class="col-md-6">
                <div class="row align-items-center">
                    <div class="col-12">
                        <img src="${contextPath}/resources/img/register.svg" alt="Tela de Registro" class="img-fluid">
                    </div>
                    <div class="col-12">
                        <a href="/login">Já possuo cadastro</a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">

            </div>
        </div>
    </div>
</div> <!-- /#main -->
<%@ include file="../common/footer.jspf"%>