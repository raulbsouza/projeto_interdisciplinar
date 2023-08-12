<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4 vinteecinco">
            <div class="initial-card vertical-center">


                <div align="center" >
                    <h3 class="noticias-do-dia">Cadastar Player</h3>
                </div>
                <div>
                    <form name="cadastrarplayer" action="PlayerCadastrar" method="POST">

                        <input type="hidden" name="idplayer" id="idplayer" value="${player.idPlayer}" readonly="readonly" />
                        <div class="noticia">
                            <table class="table-cadastro-jogo">
                                <tr>
                                    <td>
                                        Nome:
                                    </td>
                                    <td>
                                        <input type="text" name="nome" id="nome" value="${player.nome}" />
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Jogo
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







