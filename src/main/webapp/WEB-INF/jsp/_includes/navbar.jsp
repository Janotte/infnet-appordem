<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Navigation -->
<div id="navigation" class="container">
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">APP Ordem</a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/">Home</a>
          </li>
          <c:if test="${not empty auth.nome}">
            <li class="nav-item">
              <a class="nav-link" href="/ordens">Ordem</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/clientes">Cliente</a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="/produtos">Produtos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/componentes">Componentes</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/licencas">Licença</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/servicos">Serviço</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/usuarios">Usuário</a>
            </li>
          </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <c:if test="${empty auth.nome}">
            <li>
              <a class="nav-link" href="/login"
                >Login <i class="bi bi-box-arrow-in-right"></i
              ></a>
            </li>
          </c:if>

          <c:if test="${not empty auth.nome}">
            <li>
              <a class="nav-link" href="/logout">
                <span id="username">${auth.nome}</span>
                <span> Logout <i class="bi bi-box-arrow-right"></i></span>
              </a>
            </li>
          </c:if>
        </ul>
      </div>
    </div>
  </nav>
</div>
<!-- Navigation END -->