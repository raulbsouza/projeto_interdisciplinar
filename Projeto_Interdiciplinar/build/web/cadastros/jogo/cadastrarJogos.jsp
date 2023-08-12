<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4 vinteecinco">
            <div class="initial-card vertical-center">


                <div align="center" >
                    <h3 class="noticias-do-dia">Cadastar Jogos</h3>
                </div>
                <div>
                    <form name="cadastrarjogo" action="JogoCadastrar" method="POST">

                        <input type="hidden" name="idjogo" id="idjogo" value="${jogo.idJogo}" readonly="readonly" />
                        <div class="noticia">
                            <table class="table-cadastro-jogo">
                                <tr>
                                    <td>
                                        Nome:
                                    </td>
                                    <td>
                                        <input type="text" name="descricao" id="descricao" value="${jogo.descricao}" />
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Tipo:
                                    </td>
                                    <td>
                                        <input type="text" name="tipo" id="tipo" value="${jogo.tipo}" />
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







