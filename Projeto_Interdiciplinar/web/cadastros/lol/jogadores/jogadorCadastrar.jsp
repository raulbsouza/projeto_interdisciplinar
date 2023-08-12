<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarjogadorlol" action="JogadorlolCadastrar" method="POST">
    <table>
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Jogador
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
                <td><input type="text" name="idjogador" id="idjogador" value="${jogadores.idJogadorLOL}" readonly="readonly" size="50" maxlength="50"/></td>
            </tr>
            <tr>
                <td>Nome: </td>
                <td><input type="text" name="nomejogador" id="nomejogador" value="${jogadores.nomeJogadorLOL}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>KDA: </td>
                <td><input type="text" name="kda" id="kda" value="${jogadores.kdaJogadorLOL}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>CS por Minuto </td>
                <td><input type="text" name="csminute" id="csminute" value="${jogadores.csMinute}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>Gold por Minuto </td>
                <td><input type="text" name="goldminute" id="goldminute" value="${jogadores.goldMinute}" size="50" maxlength="50" required/></td>
            </tr>
            <tr>
                <td>Participações </td>
                <td><input type="text" name="participacao" id="participacao" value="${jogadores.part}" size="50" maxlength="50" required/></td>
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