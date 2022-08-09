<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Licenças</title>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="../../includes/navbar.jsp" />
        <div mt-3 table-responsive">
                <h1 class="ms-3">Licenças</h1>
                <table class="table table-striped">
                    <thead class="table-info">
                        <tr>
                          <th scope="col">Código</th>
                          <th scope="col">Nome</th>
                          <th scope="col">Custo</th>
                          <th scope="col">Valor</th>
                          <th scope="col">Validade</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>00001</td>
                            <td>Nome da licença 1</td>
                            <td>100,00</td>
                            <td>140,00</td>
                            <td>12 meses</td>
                        </tr>
                       <tr>
                           <td>00002</td>
                           <td>Nome da licença 2</td>
                           <td>200,00</td>
                           <td>280,00</td>
                           <td>24 meses</td>
                       </tr>
                        <tr>
                            <td>00003</td>
                            <td>Nome da licença 3</td>
                            <td>300,00</td>
                            <td>420,00</td>
                            <td>36 meses</td>
                        </tr>
                    </tbody>
                </table>
            </div>
    </div>
</body>
</html>