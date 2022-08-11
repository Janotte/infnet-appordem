<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<h1 class="ms-3">Componentes</h1>
<table class="table table-striped">
    <thead class="table-info">
        <tr>
          <th scope="col">Código</th>
          <th scope="col">NCM</th>
          <th scope="col">Nome</th>
          <th scope="col">Valor de Compra</th>
          <th scope="col">Valor do Frete</th>
          <th scope="col">Custo de Compra</th>
          <th scope="col">Preço de Venda</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>00001</td>
            <td>1111.11.11</td>
            <td>Nome do componente 1</td>
            <td>100,00</td>
            <td>10,00</td>
            <td>110,00</td>
            <td>157,14</td>
        </tr>
       <tr>
           <td>00002</td>
           <td>2222.22.22</td>
           <td>Nome do componente 2</td>
           <td>200,00</td>
           <td>25,00</td>
           <td>225,00</td>
           <td>321,42</td>
       </tr>
        <tr>
            <td>00003</td>
            <td>3333.33.33</td>
            <td>Nome do componente 3</td>
            <td>300,00</td>
            <td>20,00</td>
            <td>320,00</td>
            <td>457,14</td>
        </tr>
    </tbody>
</table>

<%@ include file="../common/footer.jspf"%>