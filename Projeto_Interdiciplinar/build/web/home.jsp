<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="header.jsp"/>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4 setentaecinco">
            <div class="initial-card">
                <h1 align="center" class="noticias-do-dia">Notícias do dia</h1>
                <br/>

                <div class="noticia">
                    <div class="div-imagem">
                        <img src="${pageContext.request.contextPath}/img/noticias/cs/csnew1.png" class="img-noticia"/>
                    </div>
                    <div class="texto-noticia">
                        <h3>AGENTES LIVRES E JOGADORES PARA TRANSFERÊNCIA</h3>
                        
                        À medida que a temporada atinge o frenesi de transferência do intervalo do jogador, 
                        vamos dar uma olhada em alguns dos agentes livres mais emocionantes e jogadores listados para transferência.
                        <br/>
                        <br/>
                        <a href="newcs1.jsp">Ler mais...</a>
                    </div>
                </div>

                    <div class="noticia">
                    <div class="div-imagem">
                        <img src="${pageContext.request.contextPath}/img/noticias/valorant/valorantnew1.png" class="img-noticia"/>
                    </div>
                    <div class="texto-noticia">
                        <h3>MASTERS: LOUD PERDE PARA A EDG E É ELIMINADA</h3>
                        <br/>
                        A trajetória da LOUD no VALORANT Masters Tokyo chegou ao fim na madrugada deste domingo
                        <br/>
                        <br/>
                        <a href="newvalorant1.jsp">Ler mais...</a>
                    </div>
                </div>
                    
                    
                <div class="noticia">
                    <div class="div-imagem">
                        <img src="${pageContext.request.contextPath}/img/noticias/lol/lolnew1.png" class="img-noticia"/>
                    </div>
                    <div class="texto-noticia">
                        <h3>CBLOL 2023: RED assume liderança</h3>
                        <br/>
                        O CBLOL 2023 continua a todo vapor e tem uma nova líder isolada: a RED Kalunga.
                        <br/>
                        <br/>
                        <a href="newlol1.jsp">Ler mais...</a>
                    </div>
                </div>
                    
                    
                <div class="noticia">
                    <div class="div-imagem">
                        <img src="${pageContext.request.contextPath}/img/noticias/dota/dotanew1.png" class="img-noticia"/>
                    </div>
                    <div class="texto-noticia">
                        <h3>Aramis deixa Old G em saída repentina</h3>
                        <br/>
                        No[o]ne- compartilhou como Aramis acabou saindo do Old G e como isso pode afetar seu slot no DPC.
                        <br/>
                        <br/>
                        <a href="newdota1.jsp">Ler mais...</a>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <jsp:include page="footer.jsp"/>
