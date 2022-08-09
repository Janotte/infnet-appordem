<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <link href="${contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>APP Ordem</title>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="../../includes/navbar.jsp" />

        <div  mt-3 table-responsive">
                <h2>Descrição da classes do projeto</h2>
                <p>Projeto do Aplicativo de Gestão de Ordem de Serviço</p>
                <table class="table table-striped">
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
                <table class="table table-striped">
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
                <table class="table table-striped">
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
                            <td>ncm</td>
                            <td>String</td>
                            <td colspan="2">NCM do componente</td>
                        </tr>
                        <tr>
                            <td>nome</td>
                            <td>String</td>
                            <td colspan="2">Nome do componente</td>
                        </tr>
                         <tr>
                            <td>custo</td>
                            <td>Double</td>
                            <td colspan="2">Custo do componente</td>
                        </tr>
                        <tr>
                            <td>valor</td>
                            <td>Double</td>
                            <td colspan="2">Valor do componente</td>
                        </tr>

                    </tbody>
                </table>
                <table class="table table-striped">
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
                            <td colspan="2">Código da licença</td>
                        </tr>
                        <tr>
                            <td>nome</td>
                            <td>String</td>
                            <td colspan="2">Nome da licença</td>
                        </tr>
                         <tr>
                            <td>custo</td>
                            <td>Double</td>
                            <td colspan="2">Custo da licença</td>
                        </tr>
                        <tr>
                            <td>valor</td>
                            <td>Double</td>
                            <td colspan="2">Valor da licença</td>
                        </tr>
                        <tr>
                            <td>validade</td>
                            <td>String</td>
                            <td colspan="2">Validade da licença</td>
                        </tr>
                    </tbody>
                </table>
                <table class="table table-striped">
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
                            <td colspan="2">Código do serviço</td>
                        </tr>
                        <tr>
                            <td>nome</td>
                            <td>String</td>
                            <td colspan="2">Nome do serviço</td>
                        </tr>
                         <tr>
                            <td>custo</td>
                            <td>Double</td>
                            <td colspan="2">Custo do serviço</td>
                        </tr>
                        <tr>
                            <td>valor</td>
                            <td>Double</td>
                            <td colspan="2">Valor do serviço</td>
                        </tr>
                        <tr>
                            <td>garantia</td>
                            <td>String</td>
                            <td colspan="2">Garantia do serviço</td>
                        </tr>
                    </tbody>
                </table>
            </div>
    </div>
</body>
</html>