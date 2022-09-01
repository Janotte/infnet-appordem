<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br" class="h-100">
  <c:import url="/WEB-INF/jsp/common/head.jsp" />
  <body>
    <div class="container-fluid">
      <c:import url="/WEB-INF/jsp/common/navigation.jsp" />
      <main class="container-flex col-12">
        <div id="top" class="row d-flex align-items-baseline">
          <div class="col-md-3 ms-3">
            <h2>Licenças</h2>
          </div>
          <div class="col-md-5">
            <div class="input-group h2">
              <input
                name="data[search]"
                class="form-control"
                id="search"
                type="text"
                placeholder="Pesquisar Licenças"
              />
              <span class="input-group-btn ms-2">
                <button class="btn btn-primary" type="submit">
                  <i class="bi bi-search"></i>
                </button>
              </span>
            </div>
          </div>
          <div class="col-md-3">
            <a href="/licenca/adicionar" class="btn btn-primary"
              >Nova Licença</a
            >
          </div>
        </div>
        <!-- /#top -->
        <hr />
        <div id="list" class="row">
          <div class="table-responsive col-md-12">
            <table class="table table-striped" cellspacing="0" cellpadding="0">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Nome</th>
                  <th scope="col">Preço de Venda</th>
                  <th scope="col" class="actions">Ações</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="licenca" items="${licencaList}">
                  <tr>
                    <td>${licenca.id}</td>
                    <td>${licenca.nome}</td>
                    <td>
                      <fmt:formatNumber
                        type="number"
                        minFractionDigits="2"
                        maxFractionDigits="2"
                        value="${licenca.precoVenda}"
                      />
                    </td>
                    <td class="actions">
                      <a
                        class="btn btn-info btn-sm"
                        href="/licenca/${licenca.id}/atualizar"
                        data-bs-toggle="tooltip"
                        data-bs-placement="top"
                        title="Editar"
                      >
                        <i class="bi bi-check-circle text-light"></i>
                      </a>
                      <a
                        class="btn btn-danger btn-sm"
                        href="#"
                        data-bs-toggle="modal"
                        data-bs-target="#confirm-delete-modal"
                        data-href="/licenca/${licenca.id}/excluir"
                        data-bs-toggle="tooltip"
                        data-bs-placement="top"
                        title="Excluir"
                      >
                        <i class="bi bi-trash text-light"></i>
                      </a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <!-- /#list -->
      </main>
      <!-- /#main -->
      <c:import url="/WEB-INF/jsp/common/footer.jsp" />
    </div>
    <c:import url="/WEB-INF/jsp/common/delete-modal.jsp" />
  </body>
</html>
