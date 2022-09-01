<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
  <c:import url="/WEB-INF/jsp/common/head.jsp" />

  <body>
    <div class="container-fluid">
      <c:import url="/WEB-INF/jsp/common/navigation.jsp" />
      <main class="container col-11 col-md-6" id="form-container">
        <div id="top" class="row gx-5 ms-3">
          <h2 class="page-header">${pageTitle}</h2>
        </div>
        <!-- /#top -->
        <div id="form" class="row gx-5">
          <form:form
            action="${formAction}"
            method="POST"
            modelAttribute="usuario"
          >
            <fieldset>
              <div class="form-floating mb-3">
                <form:input
                  path="id"
                  type="text"
                  class="form-control"
                  id="id"
                  name="id"
                  readOnly="readOnly"
                />
                <form:label path="id" for="id" class="form-label"
                  >Id</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="nome"
                  type="text"
                  class="form-control"
                  id="nome"
                  name="nome"
                  placeholder="Informe seu Nome"
                />
                <form:label path="nome" for="nome" class="form-label"
                  >Informe seu Nome</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="email"
                  type="text"
                  class="form-control"
                  id="email"
                  name="email"
                  placeholder="Informe seu E-mail"
                />
                <form:label path="email" for="email" class="form-label"
                  >Informe seu E-mail</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="senha"
                  type="password"
                  class="form-control"
                  name="senha"
                  placeholder="Informe sua Senha"
                />
                <form:label path="senha" for="senha" class="form-label"
                  >Informe sua Senha</form:label
                >
              </div>
            </fieldset>
            <div class="d-flex justify-content-center">
              <input
                type="submit"
                class="btn btn-primary"
                value="${pageTitle}"
              />
              <a href="/usuarios" class="btn btn-link">Cancelar</a>
            </div>
          </form:form>
        </div>
        <!-- /#form -->
      </main>
      <!-- /#main -->
      <c:import url="/WEB-INF/jsp/common/footer.jsp" />
    </div>
  </body>
</html>
