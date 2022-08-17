<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<main class="container col-11 col-md-6" id="form-container">
    <div class="row gx-5">
        <div id="top" class="col-md-12">
            <h2 class="page-header">Atualizar Cliente</h2>
        </div>
        <div class="col-md-12">
            <form>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Informe seu nome">
                    <label for="nome" class="form-label">Informe seu nome</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="cpf-cnpj" name="cpf-cnpj" placeholder="Informe seu CPF ou CNPJ">
                    <label for="cpf-cnpj" class="form-label">Informe seu CPF ou CNPJ</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="celular" name="celular" placeholder="Informe seu celular">
                    <label for="celular" class="form-label">Informe seu celular</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Informe seu email">
                    <label for="email" class="form-label">Informe seu email</label>
                </div>
            </form>
        </div>
    </div>
    <div id="actions" class="row gx-5">
         <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Salvar</button>
            <a href="/clientes" class="btn btn-secondary">Cancelar</a>
        </div>
    </div>
</main>

<%@ include file="../common/footer.jspf"%>