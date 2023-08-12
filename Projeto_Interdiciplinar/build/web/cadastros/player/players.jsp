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
                        <img src="${pageContext.request.contextPath}/img/jogador.png" width="3%"/>
                        Players
                    </div>
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                                <tr class="tablejog">
                                    <th >ID</th>                    
                                    <th >Jogo</th>
                                    <th >Nome</th>
                                    <th ></th> 
                                    <th ></th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="player" items="${player}">                    
                                    <tr class="tablejog">
                                        <td >${player.idPlayer}</td>                    
                                        <td >${player.idJogo.descricao}</td>
                                        <td >${player.nome}</td>
                                        <td >
                                            <div align="center" class="button-excluir">
                                                <a href="${pageContext.request.contextPath}/PlayerExcluir?idPlayer=${player.idPlayer}"  class="decoration-none">Excluir</a>
                                            </div>
                                        </td>
                                        <td align="center">
                                            <div align="center" class="button-alterar">
                                                <a href="${pageContext.request.contextPath}/PlayerCarregar?idPlayer=${player.idPlayer}" class="decoration-none">Alterar</a>
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