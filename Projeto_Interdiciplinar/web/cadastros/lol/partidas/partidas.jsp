<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
    <h2>Partidas</h2>
    <table align="center"class="tablelistarpartidas">
        <thead>
            <tr align="center">
                <th align="left" class="listlol">ID</th>
                <th align="left" class="listlol">Jogo</th>
                <th align="left" class="listlol">Campeonato</th>
                <th align="left" class="listlol">Time 1</th>
                <th align="center" class="listlol">X</th>
                <th align="left" class="listlol">Time 2</th>
                <th align="left" class="listlol">Data</th>
                <th align="left" class="listlol">Hora</th>
                <th align="rigth"></th>
                <th align="rigth"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="partida" items="${partidas}">
                <tr class="tablepart">
                    <td align="left" class="listpart">${partida.idPartida}</td>
                    <td align="left" class="listpart">${partida.jogoPartida}</td>
                    <td align="left" class="listpart">${partida.campPartida}</td>
                    <td align="left" class="listpart">${partida.timeUm}</td>
                    <td align="center" class="listpart"><strong>X</strong></td>
                    <td align="left" class="listpart">${partida.timeDois}</td>
                    <td align="left" class="listpart">${partida.dataPartida}</td>
                    <td align="left" class="listpart">${partida.horaPartida}</td>
                    <td align="center"class="listbutton">
                        <div class="botaoexcluir"><a href="${pageContext.request.contextPath}/PartidalolExcluir?idPartida=${partida.idPartida}">Excluir</a></div>
                    </td>
                    <td align="center"class="listbutton">
                        <div class="botaoalterar"><a href="${pageContext.request.contextPath}/PartidalolCarregar?idPartida=${partida.idPartida}">Alterar</a></div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div align="center">
        <a href="${pageContext.request.contextPath}/PartidalolNovo">Novo</a>
        <a href="index.jsp">Voltar à Páginca Inicial</a>
    </div>

    <script>
        $(document).ready(function () {
            console.log('entrei ready');
            $('#datatable').DataTable({
                "oLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Ultimo"
                    }
                }
            });
        });
    </script>
<%@ include file="/footer.jsp" %>
