<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<h1 class="ms-3">Ordens</h1>
<table class="table table-striped">
    <thead class="table-info">
        <tr>
          <th scope="col">Código</th>
          <th scope="col">Data</th>
          <th scope="col">Situação</th>
          <th scope="col">Atendimento</th>
          <th scope="col">Cliente</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>00001</td>
            <td>05/08/2022 08:15:42</td>
            <td>Concluída</td>
            <td>Remoto</td>
            <td>Igor Cauê Aparício</td>
        </tr>
       <tr>
           <td>00002</td>
           <td>06/08/2022 10:15:42</td>
           <td>Concluída</td>
           <td>Interno</td>
           <td>Giovanna Raquel Galvão</td>
       </tr>
        <tr>
            <td>00003</td>
            <td>08/08/2022 08:05:17</td>
            <td>Em análise</td>
            <td>Externo</td>
            <td>Eduardo e Patrícia Entregas Expressas Ltda</td>
        </tr>
         <tr>
            <td>00004</td>
            <td>09/08/2022 15:53:21</td>
            <td>Aberta</td>
            <td>Externo</td>
            <td>Diogo André Lorenzo Viana</td>
        </tr>
    </tbody>
</table>

<%@ include file="../common/footer.jspf"%>