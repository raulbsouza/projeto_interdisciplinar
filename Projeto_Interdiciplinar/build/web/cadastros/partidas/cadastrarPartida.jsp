<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4 trinta">
            <div class="initial-card vertical-mid">


                <div align="center" >
                    <h3 class="noticias-do-dia">Cadastar Partida</h3>
                </div>
                <div>
                    <form name="cadastrarpartida" action="PartidaCadastrar" method="POST">

                        <input type="hidden" name="idpartida" id="idpartida" value="${partida.idPartida}" readonly="readonly" />
                        <div class="noticia">
                            <table>
                                <tr>
                                    <td>
                                        Data:
                                    </td>
                                    <td>
                                        <input type="date" name="datapartida" id="datapartida" value="${partida.dataPartida}" />
                                    </td>
                                    <td>

                                    </td>
                                   
                                </tr>
                                <tr>
                                     <td>
                                        Hora: 
                                    </td>
                                    <td>
                                        <input type="text" name="hora" id="hora" value="${partida.hora}"/>
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Jogo:
                                    </td>
                                    <td>
                                        <select name="idjogo" id="idjogo">
                                            <option value="">Selecione</option>
                                            <c:forEach var="jogo" items="${jogo}">
                                                <option value="${jogo.idJogo}" 
                                                        ${player.idJogo.idJogo == jogo.idJogo ? "selected" : ""}>
                                                    ${jogo.descricao}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Time 1:
                                    </td>
                                    <td>
                                        <select name="timeUm" id="time">
                                            <option value="">Selecione</option>
                                            <c:forEach var="time" items="${time}">
                                                <option value="${time.idTime}" 
                                                        ${partida.timeUm.idTime == time.idTime ? "selected" : ""}>
                                                    ${time.nomeTime}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Time 2:
                                    </td>
                                    <td>
                                        <select name="timeDois" id="time">
                                            <option value="">Selecione</option>
                                            <c:forEach var="time" items="${time}">
                                                <option value="${time.idTime}" 
                                                        ${partida.timeDois.idTime == time.idTime ? "selected" : ""}>
                                                    ${time.nomeTime}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                            </table>

                            <div align="center" class="button-submit" >
                                <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" class="button-cadastrar" />
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </main>
    <%@ include file="/footer.jsp" %>







