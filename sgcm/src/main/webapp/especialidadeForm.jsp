<%@page pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Objects" %>
<jsp:useBean id="controller" class="br.ufac.sgcm.controller.EspecialidadeController" scope="page" />
<jsp:useBean id="registro" class="br.ufac.sgcm.model.Especialidade" scope="page" />
<% registro=controller.processRequest(request, response);%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <link rel="icon" href="./imagens/logo_branco(64).png">
        <title>SGCM - Profissionais</title>
        <link rel="stylesheet" href="./css/estilo.css">
        <script src="./js/script.js" defer></script>
    </head>
    <body>
        <header>
            <div id="topo">
                <img src="./imagens/logo_branco(64).png" alt="Logo SGCM">
                <p>SGCM - Sistema de Gerenciamento de Consultas Médicas</p>
            </div>
        </header>
        <nav>
            <ul>
                <li>
                    <a href="index.jsp">Home</a>
                </li>
                <li>
                    <a href="paciente.jsp">Paciente</a>
                </li>
                <li>
                    <a href="atendimento.jsp">Atendimento</a>
                </li>
                <li>
                    <a href="profissional.jsp">Profissional</a>
                </li>
                <li>
                    <a href="convenio.jsp">Convênio</a>
                </li>
                <li>
                    <a href="unidade.jsp">Unidade</a>
                </li>
                <li>
                    <a href="especialidade.jsp">Especialidade</a>
                </li>
            </ul>
        </nav>
    
        <main>
        <%-- Inserir o form --%>
        <form class="grid" method="post">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" value="<%=Objects.toString(registro.getNome(),"")%>"/>
            <button class="botao_verde" type="submit" name="submit">Salvar</button>
        </form>
        </main>
        <footer>
            <p>Telefone para contato: <a>+556832233030</a> | Email: <a>suporte.sgcm@ufac.br</a></p>
        </footer>
    </body>
</html>
