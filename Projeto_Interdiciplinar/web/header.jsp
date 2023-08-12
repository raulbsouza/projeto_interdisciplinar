<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta  http-equiv="Content-Type" content="text/html; charset=iso-8895-1">
        <title>E-sports House</title>
        <!--JQuery-->
        <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script> 
        <script src="${pageContext.request.contextPath}/js/jquery.mask.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.maskMoney.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/app.js"></script>

        <meta name="viewport" content="width=device-width" initial-scale="1.0">

        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/icon.png">
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/config.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

    </head>

    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="${pageContext.request.contextPath}/index.jsp">E-sports House</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Pesquisar" aria-label="Pesquisar" aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Configurações</a></li>
                        <!--<li><a class="dropdown-item" href="#!">Activity Log</a></li>-->
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Sair</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <div class="sb-sidenav-menu-heading">Usuário</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/controle.png" class="icon-side-bar"/>
                                Jogos
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/JogoListar">Listar Jogos</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseJogadores" aria-expanded="false" aria-controls="collapseJogadores">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/jogador.png" class="icon-side-bar"/>
                                Players
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseJogadores" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/PlayerListar">Listar Players</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseTimes" aria-expanded="false" aria-controls="collapseTimes">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/time.png" class="icon-side-bar"/>
                                Times
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseTimes" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/TimeListar">Listar Times</a>
                                </nav>
                            </div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePartida" aria-expanded="false" aria-controls="collapsePartida">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/espada.png" class="icon-side-bar"/>
                                Partidas
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePartida" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/PartidaListar">Listar Partidas</a>
                                </nav>
                            </div>


                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="login.html">Login</a>
                                            <a class="nav-link" href="register.html">Register</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Admin</div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCadastros" aria-expanded="false" aria-controls="collapseCadastros">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/cadastro.png" class="icon-side-bar"/>
                                Cadastros
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseCadastros" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/JogoNovo">Cadastrar Jogo</a>
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/PlayerNovo">Cadastrar Player</a>
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/TimeNovo">Cadastrar Time</a>
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/PartidaNovo">Cadastrar Partida</a>
                                </nav>
                            </div>  
                                
                                
                                
                                <div class="sb-sidenav-menu-heading">Sites de Apoio</div>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCs" aria-expanded="false" aria-controls="collapseCs">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/csgo_logo.png" class="icon-side-bar"/>
                                CS:GO
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseCs" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="https://www.hltv.org/" target="_blank">HLTV</a>
                                </nav>
                            </div> 
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVal" aria-expanded="false" aria-controls="collapseVal">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/valorant_logo.png" class="icon-side-bar"/>
                                Valorant
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseVal" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">                                    
                                    <a class="nav-link" href="https://valorantesports.com/" target="_blank">Valorant Esports</a>
                                </nav>
                            </div> 
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLol" aria-expanded="false" aria-controls="collapseLol">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/lol_logo.png" class="icon-side-bar"/>
                                LOL
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLol" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="https://lolesports.com/" target="_blank">LoL Esports</a>
                                </nav>
                            </div>  
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseDota" aria-expanded="false" aria-controls="collapseDota">
                                <div class="sb-nav-link-icon"></div><img src="${pageContext.request.contextPath}/img/dota2_logo.png" class="icon-side-bar"/>
                                DOTA 2
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseDota" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="https://www.dota2.com/esports/summer23/schedule" target="_blank">DOTA 2</a>
                                </nav>
                            </div>  
                             
                                
                                
                                
                                
                        </div>
                    </div>

                </nav>
            </div>

