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
            modelAttribute="componente"
          >
            <fieldset>
              <div class="form-floating mb-3">
                <form:input
                  path="ncm"
                  type="text"
                  class="form-control"
                  id="ncm"
                  name="ncm"
                  placeholder="Informe o NCM"
                />
                <form:label path="ncm" for="ncm" class="form-label"
                  >Informe o NCM</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="nome"
                  type="text"
                  class="form-control"
                  id="nome"
                  name="nome"
                  placeholder="Informe seu nome"
                />
                <form:label path="nome" for="nome" class="form-label"
                  >Informe seu nome</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="valorCompra"
                  type="text"
                  class="form-control"
                  name="valorCompra"
                  placeholder="Informe o valor de compra"
                />
                <form:label
                  path="valorCompra"
                  for="valorCompra"
                  class="form-label"
                  >Informe o valor de compra</form:label
                >
              </div>
              <div class="form-floating mb-3">
                <form:input
                  path="valorFrete"
                  type="text"
                  class="form-control"
                  name="valorFrete"
                  placeholder="Informe o valor do frete"
                />
                <form:label
                  path="valorFrete"
                  for="valorFrete"
                  class="form-label"
                  >Informe o valor do frete</form:label
                >
              </div>
            </fieldset>
            <div class="d-flex justify-content-center">
              <button type="submit" class="btn btn-primary">
                ${pageTitle}
              </button>
              <a href="/componentes" class="btn btn-link">Cancelar</a>
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
