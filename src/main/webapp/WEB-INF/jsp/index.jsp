<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>APP Ordem</title>
</head>
<body>
    <div class="container mt-3 table-responsive">
        <h2>AppOrdem</h2>
        <p>Projeto do Aplicativo de Gestão de Ordem de Serviço</p>
        <table class="table table-striped">
            <h4>Classe - Ordem</h4>
                <thead class="table-info">
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Atributo</th>
                      <th scope="col">Tipo</th>
                      <th scope="col">Descrição</th>
                    </tr>
                </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>dataAbertura</td>
                    <td>LocalDateTime</td>
                    <td colspan="6">Data e hora do registro da ordem de serviço</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>situcao</td>
                    <td>Situacao</td>
                    <td colspan="2">Status da ordem de serviço, podendo ser aberta, atendimento, aprovação, aprovada ou concluída. </td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>cliente</td>
                    <td>Cliente</td>
                    <td colspan="2">Cliente para o qual o serviço será realizado</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>atendente</td>
                    <td>Usuario</td>
                    <td colspan="2">Usuário logado ao sistema que realizou o registro da ordem de serviço</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>tipoAtendimento</td>
                    <td>TipoAtendimento</td>
                    <td colspan="2">O tipo de atendimento são interno, remoto ou externo</td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>equipamento</td>
                    <td>String</td>
                    <td colspan="2">Descrição do equipamento a ser reparado</td>
                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>problema</td>
                    <td>String</td>
                    <td colspan="2">Descrição do problema apresentado pelo equipamento</td>
                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>solucao</td>
                    <td>String</td>
                    <td colspan="2">Descrição da solução para o problema</td>
                </tr>
                 <tr>
                    <th scope="row">9</th>
                    <td>componentes</td>
                    <td>Componente</td>
                    <td colspan="2">Lista de componentes substituídos ou adicionados ao equipamento</td>
                </tr>
                 <tr>
                    <th scope="row">10</th>
                    <td>licencas</td>
                    <td>Licenca</td>
                    <td colspan="2">Lista de licenças adicionadas ao equipamento</td>
                </tr>
                <tr>
                    <th scope="row">10</th>
                    <td>servicos</td>
                    <td>Servico</td>
                    <td colspan="2">Lista de serviços realizados no equipamento</td>
                </tr>
                 <tr>
                    <th scope="row">11</th>
                    <td>observacao</td>
                    <td>String</td>
                    <td colspan="2">Espaço destinado para observações necessárias</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>