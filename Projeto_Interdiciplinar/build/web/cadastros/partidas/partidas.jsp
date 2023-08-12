<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4 cinquenta">
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active"></li>
            </ol>
            <div class="row">

                <div class="card mb-4">
                    <div class="card-header">
                        <img src="${pageContext.request.contextPath}/img/espada-preto.png" width="3%"/>
                        Partidas
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr class="tablejog">
                                    <th >ID</th>                    
                                    <th >Jogo</th>
                                    <th >Time Um</th>
                                    <th >X</th>
                                    <th >Time Dois</th> 
                                    <th >Data</th> 
                                    <th >Hora</th> 
                                    <th ></th> 
                                    <th ></th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="partida" items="${partida}">                    
                                    <tr class="tablejog">
                                        <td >${partida.idPartida}</td>                    
                                        <td >${partida.idJogo.descricao}</td>
                                        <td >${partida.timeUm.nomeTime}</td>
                                        <td >X</td>
                                        <td >${partida.timeDois.nomeTime}</td>
                                        <td >${partida.dataPartida}</td>
                                        <td >${partida.hora}</td>
                                        <td >
                                            <div align="center" class="button-excluir">
                                                <a href="${pageContext.request.contextPath}/PartidaExcluir?idPartida=${partida.idPartida}"  class="decoration-none">Excluir</a>
                                            </div>
                                        </td>
                                        <td align="center">
                                            <div align="center" class="button-alterar">
                                                <a href="${pageContext.request.contextPath}/PartidaCarregar?idPartida=${partida.idPartida}" class="decoration-none">Alterar</a>
                                            </div>
                                        </td>
                                    </tr>                
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
    </main>


<%@ include file="/footer.jsp" %>        
