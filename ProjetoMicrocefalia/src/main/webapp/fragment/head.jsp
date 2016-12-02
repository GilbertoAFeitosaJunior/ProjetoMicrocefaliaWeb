<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Exibir Usuário</title>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://code.jquery.com/jquery-2.2.2.min.js"></script>
        <script src="http://metroui.org.ua/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/js/metro.min.js"></script>


        <style type="text/css">
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-responsive.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-schemes.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-rtl.min.css";
            @import "https://cdn.rawgit.com/olton/Metro-UI-CSS/develop/build/css/metro-icons.min.css";
        </style>

        <style>
            html, body {
                height: 100%;
                overflow:hidden;
            }
            body {
            }
            .page-content {
                padding-top: 3.125rem;
                min-height: 100%;
                height: 100%;
            }
            .table .input-control.checkbox {
                line-height: 1;
                min-height: 0;
                height: auto;
            }

            @media screen and (max-width: 800px){
                #cell-sidebar {
                    flex-basis: 52px;
                }
                #cell-content {
                    flex-basis: calc(100% - 52px);
                }
            }

            #cell-content {
                overflow: auto;
            }
        </style>

        <script>
            function pushMessage(t) {
                var mes = 'Info|Implement independently';
                $.Notify({
                    caption: mes.split("|")[0],
                    content: mes.split("|")[1],
                    type: t
                });
            }

            $(function () {
                $('.sidebar').on('click', 'li', function () {
                    if (!$(this).hasClass('active')) {
                        $('.sidebar li').removeClass('active');
                        $(this).addClass('active');
                    }
                })
            })
        </script>

    </head>
    <body class="bg-steel">
        <div class="app-bar fixed-top darcula" data-role="appbar">
            <a class="app-bar-element branding">Microcefalia</a>
            <span class="app-bar-divider"></span>

            <div class="app-bar-element place-right">
                <span class="dropdown-toggle"><span class="mif-cog"></span> ${sessionScope.usuLogado.nome}</span>
                <div class="app-bar-drop-container padding10 place-right no-margin-top block-shadow fg-dark" data-role="dropdown" data-no-close="true" style="width: 220px">
                    <ul class="unstyled-list fg-dark">
                        <li><a href="" class="fg-white1 fg-hover-yellow">Profile</a></li>
                        <li><a href="autenticador.do" class="fg-white3 fg-hover-yellow">Sair</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="page-content">
            <div class="flex-grid no-responsive-future" style="height: 100%;">
                <div class="row" style="height: 100%">
                    <div class="cell size-x200" id="cell-sidebar" style="background-color: #71b1d1; height: 100%">
                        <ul class="sidebar">
                            <li class="active">
                                <a href="noticiacontroller.do?acao=listaNoticia">
                                    <span class="mif-apps icon"></span>
                                    <span class="title">Notícias</span>
                                </a>
                            </li>
                            <li>
                                <a href="usuariocontroller.do?acao=listaUsuario">
                                    <span class="mif-vpn-publ icon"></span>
                                    <span class="title">Liberar Usuario Web</span>
                                </a>
                            </li>
                            <li>
                                <a href="forum.jsp">
                                    <span class="mif-drive-eta icon"></span>
                                    <span class="title">Fórum</span>
                                </a>
                            </li>

                            <li>
                                <a href="usuandroidcontroller.do?acao=listar">
                                    <span class="mif-vpn-publ icon"></span>
                                    <span class="title">Usuarios Android</span>
                                </a>
                            </li>
                           
                        </ul>
                    </div>
                    <div class="cell auto-size padding20 bg-white" id="cell-content">