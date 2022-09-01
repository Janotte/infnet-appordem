<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
  <c:import url="/WEB-INF/jsp/common/head.jsp" />

  <body>
    <div class="container-fluid">
      <c:import url="/WEB-INF/jsp/common/navigation.jsp" />
      <main class="container-flex col-12">
        <div class="container col-11 col-md-9" id="form-container">
          <div class="row align-items-center gx-5">
            <div class="col-md-6 order-md-2">
              <h2>Faça o login</h2>
              <form action="/login" method="POST">
                <div class="form-floating mb-3">
                  <input
                    type="email"
                    class="form-control"
                    id="email"
                    name="email"
                    placeholder="Informe seu e-mail"
                  />
                  <label for="email" class="form-label"
                    >Informe seu e-mail</label
                  >
                </div>
                <div class="form-floating mb-3">
                  <input
                    type="password"
                    class="form-control"
                    id="senha"
                    name="senha"
                    placeholder="Informe sua senha"
                  />
                  <label for="senha" class="form-label"
                    >Informe sua senha</label
                  >
                </div>
                <div class="d-flex justify-content-center">
                  <input type="submit" class="btn btn-primary" value="Entrar" />
                </div>
              </form>
            </div>
            <div class="col-md-6 order-md-1">
              <div class="col-12">
                <img
                  src="${contextPath}/resources/img/login.svg"
                  alt="Entrar"
                  class="img-fluid"
                />
              </div>
              <div class="col-12" id="link-container">
                <a href="/signup">Cadastre-se</a>
              </div>
            </div>
          </div>
        </div>
      </main>
      <c:import url="/WEB-INF/jsp/common/footer.jsp" />
    </div>
  </body>
</html>
