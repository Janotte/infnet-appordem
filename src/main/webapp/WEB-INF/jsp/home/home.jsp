<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
  <c:import url="/WEB-INF/jsp/common/head.jsp" />
  <body>
    <div class="container-fluid">
      <c:import url="/WEB-INF/jsp/common/navigation.jsp" />
      <main class="container-flex col-12">
        <div id="list" class="row">
          <h1 class="ms-3">${projeto.nome}</h1>
          <p class="ms-3">
            ${projeto.descricao}
          </p>
        </div>
        <hr />
        <div id="top" class="row">
          <c:forEach var="classe" items="${projeto.classes}">
          <h2>Classe: ${classe.nome}</h2>
          <div class="table-responsive col-md-12">
            <table class="table table-striped" cellspacing="0" cellpadding="0">
              <thead>
                <tr>
                  <th style="width: 20%" scope="col">Atributo</th>
                  <th style="width: 20%" scope="col">Tipo</th>
                  <th style="width: 60%" scope="col">Descrição</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="atributo" items="${classe.atributos}">
                <tr>
                  <td>${atributo.nome}</td>
                  <td>${atributo.tipo}</td>
                  <td colspan="2">${atributo.descricao}</td>
                </tr>
                </c:forEach>
              </tbody>

            </table>
          </div>
          </c:forEach>
        </div>
        <hr />

        <!-- /#list -->
      </main>
      <footer class="footer mt-auto py-3 fixed-bottom bg-dark">
        <div class="container">
          <span class="text-muted"
            > ${projeto.descricao}</span
          >
        </div>
      </footer>
    </div>
  </body>
</html>
