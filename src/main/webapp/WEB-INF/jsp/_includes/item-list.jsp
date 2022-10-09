<table
    id="table-itens"
    class="table table-striped"
    cellspacing="0"
    cellpadding="0"
>
    <thead>
        <tr>
            <th scope="col">Nome</th>
            <th scope="col">Qt</th>
            <th scope="col">Valor</th>
            <th scope="col">Total</th>
            <th scope="col">
                <a
                    class="btn btn-primary btn-sm"
                    href="#"
                    data-bs-toggle="modal"
                    data-bs-target="#insert-modal"
                    data-href=""
                    data-bs-toggle="tooltip"
                    data-bs-placement="top"
                    title="Adicionar"
                >
                    Adicionar
                </a>
            </th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty ordem.itens}">
            <c:forEach items="${ordem.itens}" var="item">
                <tr>
                    <td>${item.produto.nome}</td>
                    <td>
                        <div id="item" class="d-flex aligns-items-center">
                            <input
                                type="hidden"
                                name="itens"
                                value="${item.id}"
                                class="form-input"
                            />
                            <div
                                class="form-group d-flex justify-content-start w-50"
                            >
                                <input
                                    type="number"
                                    name="quantidade"
                                    class="form-control w-50"
                                    value="${item.quantidade}"
                                />
                            </div>
                        </div>
                    </td>
                    <td>${item.valorItem}</td>
                    <td>${item.totalItem}</td>
                    <td>
                        <a class="btn btn-sm btn-danger" href="#"
                            ><i class="bi bi-trash text-light"></i
                        ></a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
