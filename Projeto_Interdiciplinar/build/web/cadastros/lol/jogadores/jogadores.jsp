<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"/>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4 setentaecinco">
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active"></li>
            </ol>
            <div class="row">

                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        Jogadores de LOL
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr class="tablejog">
                                    <th >ID</th>
                                    <th >Nome</th>
                                    <th >KDA</th>
                                    <th >CS por Minuto</th>
                                    <th >GOLD por Minuto</th>
                                    <th >Participação em abates</th>
                                    <th ></th>
                                    <th ></th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="jogadores" items="${jogadores}">
                                    <tr class="tablejog">
                                        <td >${jogadores.idJogadorLOL}</td>
                                        <td >${jogadores.nomeJogadorLOL}</td>
                                        <td >${jogadores.kdaJogadorLOL}</td>
                                        <td >${jogadores.csMinute}</td>
                                        <td >${jogadores.goldMinute}</td>
                                        <td >${jogadores.part}</td>
                                        <td >
                                            <div align="center" class="button-excluir">
                                                <a href="${pageContext.request.contextPath}/JogadorlolExcluir?idJogadorLOL=${jogadores.idJogadorLOL}"  class="decoration-none">Excluir</a>
                                            </div>
                                        </td>
                                        <td >
                                            <div align="center" class="button-alterar">
                                                <a href="${pageContext.request.contextPath}/JogadorlolCarregar?idJogadorLOL=${jogadores.idJogadorLOL}" class="decoration-none">Alterar</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>




    <%@ include file="/footer.jsp" %>
