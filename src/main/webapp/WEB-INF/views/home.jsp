<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html class="dark">
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Seriendar</title>

    <meta name="keywords" content="Séries, Calendário de Séries, Data de Lançamento de Séries" />
    <meta name="description" content="Calendário contendo a data de lançamento de séries no mundo.">
    <meta name="author" content="Alexandre Lara e Weiner Silva">

    <!-- Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="img/apple-touch-icon.png">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Web Fonts  -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800%7CShadows+Into+Light" rel="stylesheet" type="text/css">

    <!-- Vendor CSS -->
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/font-awesome/css/font-awesome.min.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/simple-line-icons/css/simple-line-icons.min.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/owl.carousel/assets/owl.carousel.min.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/owl.carousel/assets/owl.theme.default.min.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/magnific-popup/magnific-popup.min.css' />">

    <!-- Theme CSS -->

    <link rel="stylesheet" href="<spring:url value='/resources/css/theme.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/css/theme-elements.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/css/theme-blog.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/css/theme-shop.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/css/theme-animate.css' />">

    <!-- Current Page CSS -->
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/rs-plugin/css/settings.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/rs-plugin/css/layers.css' />">
    <link rel="stylesheet" href="<spring:url value='/resources/vendor/rs-plugin/css/navigation.css' />">

    <!-- Skin CSS -->
    <link rel="stylesheet" href="<spring:url value='/resources/css/skins/default.css' />">

    <!-- Theme Custom CSS -->
    <link rel="stylesheet" href="<spring:url value='/resources/css/custom.css' />">

    <!-- Head Libs -->
    <script src="<spring:url value='/resources/vendor/modernizr/modernizr.min.js' />"></script>

</head>
<body>

<div class="body">
    <header id="header" data-plugin-options='{"stickyEnabled": true, "stickyEnableOnBoxed": true, "stickyEnableOnMobile": true, "stickyStartAt": 57, "stickySetTop": "-57px", "stickyChangeLogo": true}'>
        <div class="header-body">
            <div class="header-container container" style="width:100%;">
                <div class="header-row">
                    <div class="header-column">
                        <div class="header-logo">
                            <a href="<c:url value="/"/> ">
                                <img alt="Serie" width="350" height="90" data-sticky-width="311" data-sticky-height="80" data-sticky-top="33" src="<spring:url value="/resources/img/custom/s_logo.png" />">
                            </a>
                        </div>
                    </div>
                    <div class="header-column">

                        <div class="header-row">
                            <div class="header-nav">
                                <button class="btn header-btn-collapse-nav" data-toggle="collapse" data-target=".header-nav-main" >
                                    <i class="fa fa-bars"></i>
                                </button>
                                <ul class="header-social-icons social-icons hidden-xs">
                                    <li class="social-icons-facebook"><a href="http://www.facebook.com/" target="_blank" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                                    <li class="social-icons-twitter"><a href="http://www.twitter.com/" target="_blank" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                                    <li class="social-icons-linkedin"><a href="http://www.linkedin.com/" target="_blank" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div role="main" class="main">

        <section class="page-header">
            <div class="container" style="width:100%;">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li class="active">Home</li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h1>Calendário</h1>
                    </div>
                </div>
            </div>
        </section>

        <div class="container" style="width:100%;">

            <div class="row">
                <div class="col-md-12">
                    <div class="portfolio-title">
                        <div class="row">
                            <div class="col-md-12 center">
                                <table class="table" align="center">
                                    <td align="left" width="20%"><h1 class="mb-none"><a href="<spring:url value="/week/${week-1}" />"><< Anterior</a></h1></td>
                                    <td align="center" width="60%"><h1 class="mb-none">Episódios da Semana </h1></td>
                                    <td align="right" width="20%"><h1 class="mb-none"> <a href="<spring:url value="/week/${week+1}" />">Próximo >></a></h1></td>
                                </table>


                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <hr class="mt-xl mb-none solid">


        <div class="container" style="width:100%;">
            <br />
            <table class="table table-striped" style="table-layout: fixed">
                <tr>
                    <c:forEach var="daysOfWeek" items="${days}" varStatus="loop">
                        <th ><h5>${daysOfWeek.day} ${daysOfWeek.getMonthName()} </h5></th>
                    </c:forEach>
                </tr>
                <c:forEach begin="0" end="${maxEpisodesInADay-1}" varStatus="loop">
                <tr>
                    <c:forEach begin="0" end="6" varStatus="internLoop">
                        <c:choose>
                            <c:when test="${ episodesByDay.get(internLoop.index).size() <= loop.index }">
                                <td>&nbsp;</td>
                            </c:when>
                            <c:otherwise>
                                <td style="font-size: small"><a href="<spring:url value="/tvshow/${episodesByDay.get(internLoop.index).get(loop.index).tvShowId}"/>" style="font-size: small">${ episodesByDay.get(internLoop.index).get(loop.index).seriesName } <br> T${episodesByDay.get(internLoop.index).get(loop.index).airedEpisodeSeasonString}E${episodesByDay.get(internLoop.index).get(loop.index).airedEpisodeNumberString}</a></td></td>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </tr>
                </c:forEach>
            </table>

        </div>

        <br/>

    </div>


    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <p>© Copyright 2016. Todos os direitos reservados.</p>
                </div>

            </div>
        </div>
    </footer>
</div>

<!-- Vendor -->
<script src="<spring:url value='/resources/vendor/jquery/jquery.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery.appear/jquery.appear.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery.easing/jquery.easing.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery-cookie/jquery-cookie.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/bootstrap/js/bootstrap.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/common/common.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery.validation/jquery.validation.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery.stellar/jquery.stellar.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery.easy-pie-chart/jquery.easy-pie-chart.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery.gmap/jquery.gmap.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/jquery.lazyload/jquery.lazyload.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/isotope/jquery.isotope.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/owl.carousel/owl.carousel.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/magnific-popup/jquery.magnific-popup.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/vide/vide.min.js' />"></script>

<!-- Theme Base, Components and Settings -->
<script src="<spring:url value='/resources/js/theme.js' />"></script>

<!-- Current Page Vendor and Views -->
<script src="<spring:url value='/resources/vendor/rs-plugin/js/jquery.themepunch.tools.min.js' />"></script>
<script src="<spring:url value='/resources/vendor/rs-plugin/js/jquery.themepunch.revolution.min.js' />"></script>

<!-- Theme Custom -->
<script src="<spring:url value='/resources/js/custom.js' />"></script>

<!-- Theme Initialization Files -->
<script src="<spring:url value='/resources/js/theme.init.js' />"></script>

<!-- Examples -->
<script src="<spring:url value='/resources/js/examples/examples.portfolio.js' />"></script>

<!-- Google Analytics: Change UA-XXXXX-X to be your site's ID. Go to http://www.google.com/analytics/ for more information.
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-12345678-1', 'auto');
    ga('send', 'pageview');
</script>
 -->

</body>
</html>