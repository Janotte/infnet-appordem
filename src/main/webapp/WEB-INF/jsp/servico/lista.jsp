<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<h1 class="ms-3">Serviços</h1>
<table class="table table-striped">
    <thead class="table-info">
        <tr>
          <th scope="col">Código</th>
          <th scope="col">Nome</th>
          <th scope="col">Custo</th>
          <th scope="col">Preço de Venda</th>
          <th scope="col">Garantia</th>
          <th scope="col">Tipo Serviço</th>
          <th scope="col">Classificação Fiscal</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>00001</td>
            <td>Nome do serviço 1</td>
            <td>100,00</td>
            <td>140,00</td>
            <td>90 dias</td>
            <td>Manutenção de Sistemas Operacionais e Aplicativos</td>
            <td>1.07 – Suporte técnico em informática</td>
        </tr>
       <tr>
           <td>00002</td>
           <td>Nome do serviço 2</td>
           <td>200,00</td>
           <td>280,00</td>
           <td>12 meses</td>
           <td>Manutenção de Hardware</td>
           <td>14.02 – Assistência técnica</td>
       </tr>
        <tr>
            <td>00003</td>
            <td>Nome do serviço 3</td>
            <td>300,00</td>
            <td>420,00</td>
            <td>3 anos</td>
            <td>Manutenção de Infraestrutura de rede</td>
            <td>14.02 – Assistência técnica</td>
        </tr>
    </tbody>
</table>

<%@ include file="../common/footer.jspf"%>