<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Modal -->
<div
    class="modal fade"
    id="insert-modal"
    data-bs-backdrop="static"
    tabindex="-1"
    role="dialog"
    aria-labelledby="modalLabel"
>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="insertModelLabel">
                    Inserir Produto
                </h5>
                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-floating mb-3">
                        <c:if test="${not empty produtoList}">
                            <select
                                name="item.produto.id"
                                path="item.produto"
                                class="form-select form-floating mb-3"
                                aria-label=".form-select-lg itens"
                            >
                                <option selected>Selecione o Produto</option>
                                <c:forEach var="produto" items="${produtoList}">
                                    <option value="${produto.id}">
                                        ${produto.nome}
                                    </option>
                                </c:forEach>
                            </select>
                            <label
                                path="produto"
                                for="produto"
                                class="form-label"
                                >Produto
                            </label>
                        </c:if>
                        <c:if test="${empty produtoList}">
                            <select
                                name="produto"
                                path="produto"
                                id="produto"
                                class="form-select form-floating mb-3"
                                aria-label=".form-select-lg cliente"
                            >
                                <option selected>
                                    Não existe produtos cadastrados
                                </option>
                            </select>
                            <label
                                path="produto"
                                for="produto"
                                class="form-label"
                                >Produto</label
                            >
                        </c:if>
                    </div>
                    <div class="form-floating mb-3">
                        <input
                            path="quantidade"
                            type="number"
                            class="form-control"
                            name="quantidade"
                            placeholder="Quantidade"
                        />
                        <label
                            path="quantidade"
                            for="quantidade"
                            class="form-label"
                            >Quantidade</label
                        >
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a
                    type="submit"
                    class="btn btn-primary confirm-insert-btn"
                    value="${pageTitle}"
                ></a>
                <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                >
                    Fechar
                </button>
            </div>
        </div>
    </div>
</div>
<!-- Modal END -->
