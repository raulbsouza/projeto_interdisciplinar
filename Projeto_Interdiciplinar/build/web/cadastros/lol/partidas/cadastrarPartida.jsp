<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarpartidalol" action="PartidalolCadastrar" method="POST">
    <table>
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Partida
                </th>
            </tr>
            <tr>
                <th colspan="2" align="center">
                    ${mensagem}
                </th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="idpartida" id="idpartida" value="${partidas.idPartida}" readonly="readonly" size="50" maxlength="50"/></td>
            </tr>
            <tr>
                <td>Jogo: </td>
                <td><input type="text" name="jogopart" id="jogopart" value="${partidas.jogoPartida}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>Campeonato: </td>
                <td><input type="text" name="camppart" id="camppart" value="${partidas.campPartida}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>Time Um:</td>
                <td><input type="text" name="teamone" id="teamone" value="${partidas.timeUm}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>Time Dois: </td>
                <td><input type="text" name="teamtwo" id="teamtwo" value="${partidas.timeDois}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>Data: </td>
                <td><input type="text" name="datapart" id="datapart" value="${partidas.dataPartida}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>Hora: </td>
                <td><input type="text" name="horapart" id="horapart" value="${partidas.horaPartida}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar"/>
                    <input type="reset" name="limpar" id="limpar" value="Limpar"/>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp">Voltar à Página Inicial</a></h5></td>
            </tr>
        </tbody>
    </table>
</form>
<%@include file="/footer.jsp" %>