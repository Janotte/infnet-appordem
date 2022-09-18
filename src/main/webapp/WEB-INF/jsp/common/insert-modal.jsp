<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Modal -->
<div class="modal fade" id="insert-modal" data-bs-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="insertModelLabel">Inserir Produto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="form-floating mb-3">
                    <select
                      name="itemId"
                      id="itemId"
                      path="item"
                      class="form-select form-floating mb-3"
                      aria-label=".form-select-lg cliente"
                    >
                      <option selected>Selecione o Produto</option>
                      <c:forEach var="item" items="${produtoList}">
                        <option value="${item.id}">${item.nome}</option>
                      </c:forEach>
                    </select>
                    <label
                      path="itemId"
                      for="itemId"
                      class="form-label"
                      >Cliente</label
                    >
                  </div>
                   <div class="form-floating mb-3">
                      <input
                        path="quantidade"
                        type="number"
                        class="form-control"
                        name="quantidade"
                        placeholder="Quantidade"
                      />
                      <label path="quantidade" for="quantidade" class="form-label">Quantidade</label>
                    </div>
            </div>
            <div class="modal-footer">
                <a type="button" class="btn btn-primary confirm-delete-btn">Inserir</a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal END -->