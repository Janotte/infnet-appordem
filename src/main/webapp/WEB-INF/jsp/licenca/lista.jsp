<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<h1 class="ms-3">Licenças</h1>
<table class="table table-striped">
    <thead class="table-info">
        <tr>
          <th scope="col">Código</th>
          <th scope="col">Nome</th>
          <th scope="col">Custo de Compra</th>
          <th scope="col">Preço de Venda</th>
          <th scope="col">Dispositivos</th>
          <th scope="col">Validade</th>
          <th scope="col">Fabricante</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>00001</td>
            <td>Nome da licença 1</td>
            <td>100,00</td>
            <td>140,00</td>
            <td>1</td>
            <td>12 meses</td>
            <td>Fabricante do Produto 1</td>
        </tr>
       <tr>
           <td>00002</td>
           <td>Nome da licença 2</td>
           <td>200,00</td>
           <td>280,00</td>
           <td>3</td>
           <td>24 meses</td>
           <td>Fabricante do Produto 2</td>
       </tr>
        <tr>
            <td>00003</td>
            <td>Nome da licença 3</td>
            <td>300,00</td>
            <td>420,00</td>
            <td>5</td>
            <td>36 meses</td>
            <td>Fabricante do Produto 3</td>
        </tr>
    </tbody>
</table>

<%@ include file="../common/footer.jspf"%>