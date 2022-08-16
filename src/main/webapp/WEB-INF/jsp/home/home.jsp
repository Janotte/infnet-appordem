<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>

<h1 class="ms-3">Descrição da classes do projeto</h1>
<p class="ms-3">Projeto do Aplicativo de Gestão de Ordem de Serviço</p>
<table class="table table-striped mb-4">
    <h4>Classe - Ordem</h4>
        <thead class="table-info">
            <tr>
              <th style="width: 20%" scope="col">Atributo</th>
              <th style="width: 20%" scope="col">Tipo</th>
              <th style="width: 60%" scope="col">Descrição</th>
            </tr>
        </thead>
    <tbody>
        <tr>
            <td>codigo</td>
            <td>Long</td>
            <td colspan="2">Código da ordem de serviço</td>
        </tr>
        <tr>
            <td>dataAbertura</td>
            <td>LocalDateTime</td>
            <td colspan="2">Data e hora de registro da ordem de serviço</td>
        </tr>
        <tr>
            <td>situcao</td>
            <td>Situacao</td>
            <td colspan="2">Situação da ordem de serviço, podendo ser aberta, em analise e concluída. </td>
        </tr>
        <tr>
            <td>tipoAtendimento</td>
            <td>TipoAtendimento</td>
            <td colspan="2">O tipo de atendimento são interno, remoto ou externo</td>
        </tr>
        <tr>
            <td>equipamento</td>
            <td>String</td>
            <td colspan="2">Descrição do equipamento a ser reparado</td>
        </tr>
        <tr>
            <td>problema</td>
            <td>String</td>
            <td colspan="2">Descrição do problema apresentado pelo equipamento</td>
        </tr>
        <tr>
            <td>solucao</td>
            <td>String</td>
            <td colspan="2">Descrição da solução para o problema</td>
        </tr>
        <tr>
            <td>observacao</td>
            <td>String</td>
            <td colspan="2">Espaço destinado para observações necessárias</td>
        </tr>
    </tbody>
</table>
<table class="table table-striped mb-4">
    <h4>Classe - Cliente</h4>
        <thead class="table-info">
            <tr>
              <th style="width: 20%" scope="col">Atributo</th>
              <th style="width: 20%" scope="col">Tipo</th>
              <th style="width: 60%" scope="col">Descrição</th>
            </tr>
        </thead>
    <tbody>
        <tr>
            <td>codigo</td>
            <td>Long</td>
            <td colspan="2">Código do cliente</td>
        </tr>
        <tr>
            <td>nome</td>
            <td>String</td>
            <td colspan="2">Nome do cliente</td>
        </tr>
        <tr>
            <td>cpfCnpj</td>
            <td>String</td>
            <td colspan="2">CPF ou CNPJ do cliente</td>
        </tr>
        <tr>
            <td>celular</td>
            <td>String</td>
            <td colspan="2">Número do celular do cliente</td>
        </tr>
        <tr>
            <td>email</td>
            <td>String</td>
            <td colspan="2">E-mail do cliente</td>
        </tr>
    </tbody>
</table>
<table class="table table-striped mb-4">
    <h4>Classe - Componente</h4>
        <thead class="table-info">
            <tr>
              <th style="width: 20%" scope="col">Atributo</th>
              <th style="width: 20%" scope="col">Tipo</th>
              <th style="width: 60%" scope="col">Descrição</th>
            </tr>
        </thead>
    <tbody>
        <tr>
            <td>codigo</td>
            <td>Long</td>
            <td colspan="2">Código do componente</td>
        </tr>
         <tr>
            <td>nome</td>
            <td>String</td>
            <td colspan="2">Nome do componente</td>
        </tr>
        <tr>
            <td>custoCompra</td>
            <td>Double</td>
            <td colspan="2">Custo de compra do componente</td>
        </tr>
        <tr>
            <td>precoVenda</td>
            <td>Double</td>
            <td colspan="2">Preço de venda do componente</td>
        </tr>
        <tr>
            <td>ncm</td>
            <td>String</td>
            <td colspan="2">NCM do componente</td>
        </tr>

         <tr>
            <td>valorCompra</td>
            <td>Double</td>
            <td colspan="2">Valor de compra do componente</td>
        </tr>
        <tr>
            <td>valorFrete</td>
            <td>Double</td>
            <td colspan="2">Valor do frete do componente</td>
        </tr>

    </tbody>
</table>
<table class="table table-striped mb-4">
    <h4>Classe - Licenca</h4>
        <thead class="table-info">
            <tr>
              <th style="width: 20%" style="width: 20%" scope="col">Atributo</th>
              <th style="width: 20%" scope="col">Tipo</th>
              <th style="width: 60%" scope="col">Descrição</th>
            </tr>
        </thead>
    <tbody>
        <tr>
            <td>codigo</td>
            <td>Long</td>
            <td colspan="2">Código do componente</td>
        </tr>
         <tr>
            <td>nome</td>
            <td>String</td>
            <td colspan="2">Nome do componente</td>
        </tr>
        <tr>
            <td>custoCompra</td>
            <td>Double</td>
            <td colspan="2">Custo de compra do componente</td>
        </tr>
        <tr>
            <td>precoVenda</td>
            <td>Double</td>
            <td colspan="2">Preço de venda do componente</td>
        </tr>
        <tr>
            <td>quantidadeDispositivos</td>
            <td>Integer</td>
            <td colspan="2">Quantidade de dispositivos da licença</td>
        </tr>
        <tr>
            <td>validade</td>
            <td>String</td>
            <td colspan="2">Validade da licença</td>
        </tr>
        <tr>
            <td>fabricante</td>
            <td>String</td>
            <td colspan="2">Fabricante da licença</td>
        </tr>
    </tbody>
</table>
<table class="table table-striped mb-4">
    <h4>Classe - Servico</h4>
        <thead class="table-info">
            <tr>
              <th style="width: 20%" scope="col">Atributo</th>
              <th style="width: 20%" scope="col">Tipo</th>
              <th style="width: 60%" scope="col">Descrição</th>
            </tr>
        </thead>
    <tbody>
        <tr>
            <td>codigo</td>
            <td>Long</td>
            <td colspan="2">Código do componente</td>
        </tr>
         <tr>
            <td>nome</td>
            <td>String</td>
            <td colspan="2">Nome do componente</td>
        </tr>
        <tr>
            <td>custoCompra</td>
            <td>Double</td>
            <td colspan="2">Custo de compra do componente</td>
        </tr>
        <tr>
            <td>precoVenda</td>
            <td>Double</td>
            <td colspan="2">Preço de venda do componente</td>
        </tr>
        <tr>
            <td>garantia</td>
            <td>String</td>
            <td colspan="2">Garantia do serviço</td>
        </tr>
         <tr>
            <td>tipoServico</td>
            <td>TipoServico</td>
            <td colspan="2">Tipo do serviço</td>
        </tr>
         <tr>
            <td>classificacaoFiscal</td>
            <td>String</td>
            <td colspan="2">Classificação fiscal do serviço</td>
        </tr>
    </tbody>
</table>

<%@ include file="../common/footer.jspf"%>