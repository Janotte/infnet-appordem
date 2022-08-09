<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Componentes</title>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="../../includes/navbar.jsp" />
        <div mt-3 table-responsive">
                <h1 class="ms-3">Componentes</h1>
                <table class="table table-striped">
                    <thead class="table-info">
                        <tr>
                          <th scope="col">Código</th>
                          <th scope="col">NCM</th>
                          <th scope="col">Nome</th>
                          <th scope="col">Custo</th>
                          <th scope="col">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>00001</td>
                            <td>1111.11.11</td>
                            <td>Nome do componente 1</td>
                            <td>100,00</td>
                            <td>140,00</td>
                        </tr>
                       <tr>
                           <td>00002</td>
                           <td>2222.22.22</td>
                           <td>Nome do componente 2</td>
                           <td>200,00</td>
                           <td>280,00</td>
                       </tr>
                        <tr>
                            <td>00003</td>
                            <td>3333.33.33</td>
                            <td>Nome do componente 3</td>
                            <td>300,00</td>
                            <td>420,00</td>
                        </tr>
                    </tbody>
                </table>
            </div>
    </div>
</body>
</html>