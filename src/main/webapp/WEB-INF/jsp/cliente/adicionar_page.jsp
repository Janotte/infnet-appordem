<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
        <div class="row gx-5" id="form-container">
          <form:form
            action="${formAction}"
            method="POST"
            modelAttribute="cliente"
          >
            <fieldset>
              <div class="form-floating mb-3">
                <form:input
                  path="nome"
                  type="text"
                  class="form-control"
                  name="nome"
                  placeholder="Nome"
                />
                <form:label path="nome" for="nome" class="form-label"
                  >Nome</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="cpfCnpj"
                  type="text"
                  class="form-control"
                  name="cpfCnpj"
                  placeholder="CPF ou CNPJ"
                />
                <form:label path="cpfCnpj" for="cpfCnpj" class="form-label"
                  >CPF ou CNPJ</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="celular"
                  type="text"
                  class="form-control"
                  name="celular"
                  placeholder="Celular"
                />
                <form:label path="celular" for="celular" class="form-label"
                  >Celular</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="email"
                  type="email"
                  class="form-control"
                  name="email"
                  placeholder="E-mail"
                />
                <form:label path="email" for="email" class="form-label"
                  >E-mail</form:label
                >
              </div>
            </fieldset>
            <div class="d-flex justify-content-center">
              <button type="submit" class="btn btn-primary">
                ${pageTitle}
              </button>
              <a href="/clientes" class="btn btn-link">Cancelar</a>
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
