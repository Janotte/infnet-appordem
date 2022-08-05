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
                    <td>codigo</td>
                    <td>Long</td>
                    <td colspan="6">Código da ordem de serviço</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>dataAbertura</td>
                    <td>LocalDateTime</td>
                    <td colspan="6">Data e hora de registro da ordem de serviço</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>situcao</td>
                    <td>Situacao</td>
                    <td colspan="2">Situação da ordem de serviço, podendo ser aberta, em analise e concluída. </td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>cliente</td>
                    <td>Cliente</td>
                    <td colspan="2">Cliente para o qual o serviço será realizado</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>atendente</td>
                    <td>Usuario</td>
                    <td colspan="2">Usuário logado ao sistema que realiza o registro da ordem de serviço</td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>tipoAtendimento</td>
                    <td>TipoAtendimento</td>
                    <td colspan="2">O tipo de atendimento são interno, remoto ou externo</td>
                </tr>
                <tr>
                    <th scope="row">7</th>
                    <td>equipamento</td>
                    <td>String</td>
                    <td colspan="2">Descrição do equipamento a ser reparado</td>
                </tr>
                <tr>
                    <th scope="row">8</th>
                    <td>problema</td>
                    <td>String</td>
                    <td colspan="2">Descrição do problema apresentado pelo equipamento</td>
                </tr>
                <tr>
                    <th scope="row">9</th>
                    <td>solucao</td>
                    <td>String</td>
                    <td colspan="2">Descrição da solução para o problema</td>
                </tr>
                 <tr>
                    <th scope="row">10</th>
                    <td>componentes</td>
                    <td>Componente</td>
                    <td colspan="2">Lista de componentes substituídos ou adicionados ao equipamento</td>
                </tr>
                 <tr>
                    <th scope="row">11</th>
                    <td>licencas</td>
                    <td>Licenca</td>
                    <td colspan="2">Lista de licenças adicionadas ao equipamento</td>
                </tr>
                <tr>
                    <th scope="row">12</th>
                    <td>servicos</td>
                    <td>Servico</td>
                    <td colspan="2">Lista de serviços realizados no equipamento</td>
                </tr>
                 <tr>
                    <th scope="row">13</th>
                    <td>observacao</td>
                    <td>String</td>
                    <td colspan="2">Espaço destinado para observações necessárias</td>
                </tr>
            </tbody>
        </table>
        <table class="table table-striped">
            <h4>Classe - Pessoa</h4>
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
                    <td>codigo</td>
                    <td>Long</td>
                    <td colspan="6">Código da pessoa</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>nome</td>
                    <td>String</td>
                    <td colspan="6">Nome da pessoa</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>cpfCnpj</td>
                    <td>String</td>
                    <td colspan="2">CPF ou CNPJ da pessoa</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>celular</td>
                    <td>String</td>
                    <td colspan="2">Número do celular da pessoa</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>email</td>
                    <td>String</td>
                    <td colspan="2">E-mail da pessoa</td>
                </tr>    
            </tbody>
        </table>
        <table class="table table-striped">
            <h4>Classe - Cliente</h4>
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
                    <td>tipoCliente</td>
                    <td>TipoCliente</td>
                    <td colspan="6">Tipo do cliente, vip ou normal</td>
                </tr>   
            </tbody>
        </table>
        <table class="table table-striped">
            <h4>Classe - Usuario</h4>
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
                    <td>senha</td>
                    <td>String</td>
                    <td colspan="6">Senha para acesso ao aplicativo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>funcao</td>
                    <td>Funcao</td>
                    <td colspan="6">Função do usuário, administrador, recepcionista ou técnico</td>
                </tr>      
            </tbody>
        </table>
        <table class="table table-striped">
            <h4>Classe - Produto</h4>
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
                    <td>codigo</td>
                    <td>Long</td>
                    <td colspan="6">Código do produto</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>nome</td>
                    <td>String</td>
                    <td colspan="6">Nome do produto</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>valor</td>
                    <td>Double</td>
                    <td colspan="2">Valor do produto</td>
                </tr>   
            </tbody>
        </table>
        <table class="table table-striped">
            <h4>Classe - Componente</h4>
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
                    <td>ncm</td>
                    <td>String</td>
                    <td colspan="6">NCM do componente</td>
                </tr>  
            </tbody>
        </table>
        <table class="table table-striped">
            <h4>Classe - Licenca</h4>
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
                    <td>validade</td>
                    <td>String</td>
                    <td colspan="6">Validade da licença</td>
                </tr>  
            </tbody>
        </table>
        <table class="table table-striped">
            <h4>Classe - Servico</h4>
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
                    <td>garantia</td>
                    <td>String</td>
                    <td colspan="6">Garantia do servico</td>
                </tr>  
            </tbody>
        </table>
    </div>
</body>
</html>