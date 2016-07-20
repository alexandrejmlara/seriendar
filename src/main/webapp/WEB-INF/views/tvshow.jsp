<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="dark">
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Séries | ${tvshow.seriesName} </title>

    <meta name="keywords" content="Séries, Calendário de Séries, Data de Lançamento de Séries" />
    <meta name="description" content="Calendário contendo a data de lançamento de séries no mundo.">
    <meta name="author" content="Alexandre Lara e Weiner Silva">

    <!-- Favicon -->
    <link rel="shortcut icon" href="<spring:url value="/resources/img/favicon.ico" />" type="image/x-icon" />
    <link rel="apple-touch-icon" href="<spring:url value="/resources/img/apple-touch-icon.png" />">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Web Fonts  -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800%7CShadows+Into+Light" rel="stylesheet" type="text/css">

    <!-- Vendor CSS -->
    <link rel="stylesheet" href="<spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/vendor/simple-line-icons/css/simple-line-icons.min.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/vendor/owl.carousel/assets/owl.carousel.min.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/vendor/owl.carousel/assets/owl.theme.default.min.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/vendor/magnific-popup/magnific-popup.min.css" />">

    <!-- Theme CSS -->
    <link rel="stylesheet" href="<spring:url value="/resources/css/theme.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/css/theme-elements.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/css/theme-blog.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/css/theme-shop.css" />">
    <link rel="stylesheet" href="<spring:url value="/resources/css/theme-animate.css" />">

    <!-- Skin CSS -->
    <link rel="stylesheet" href="<spring:url value="/resources/css/skins/default.css" />">

    <!-- Theme Custom CSS -->
    <link rel="stylesheet" href="<spring:url value="/resources/css/custom.css" />">

    <!-- Head Libs -->
    <script src="<spring:url value="/resources/vendor/modernizr/modernizr.min.js" />"></script>

</head>
<body>

<div class="body">
    <header id="header" data-plugin-options='{"stickyEnabled": true, "stickyEnableOnBoxed": true, "stickyEnableOnMobile": true, "stickyStartAt": 57, "stickySetTop": "-57px", "stickyChangeLogo": true}'>
        <div class="header-body">
            <div class="header-container container">
                <div class="header-row">
                    <div class="header-column">
                        <div class="header-logo">
                            <a href="index.html">
                                <img alt="Serie" width="350" height="90" data-sticky-width="311" data-sticky-height="80" data-sticky-top="33" src="<spring:url value="/resources/img/custom/s_logo.png" />"  >
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
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li><a href="<spring:url value="/" /> ">Home</a></li>
                            <li class="active">Séries</li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h1>${tvshow.seriesName}</h1>
                    </div>
                </div>
            </div>
        </section>

        <hr class="mt-xl mb-none solid">

        <div class="owl-carousel owl-theme full-width owl-loaded owl-drag owl-carousel-init m-none mb-lg" data-plugin-options='{"items": 1, "loop": true, "nav": true, "dots": false, "animateOut": "fadeOut"}'>
            <div>
                <img src="<spring:url value="/resources/img/custom/${tvshow.id}.jpg" />" class="img-responsive" alt="">
            </div>
        </div>

        <div class="container">

            <div class="row">
                <section class="parallax section section-text-light section-parallax section-center mt-none" data-stellar-background-ratio="0">
                    <div class="container">
                        <div class="row">
                            <div class="counters counters-text-light">
                                <div class="col-md-3 col-sm-6">
                                    <div class="counter">
                                        <i class="fa fa-user"></i>
                                        <strong data-to="2342" data-append="+">2342</strong>
                                        <label>Fãs</label>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="counter">
                                        <i class="fa fa-heart"></i>
                                        <strong data-to="${tvshow.siteRatingCount}">${tvshow.siteRatingCount}</strong>
                                        <label>Curtidas</label>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="counter">
                                        <i class="fa fa-film"></i>
                                        <strong data-to="${episodes.size()-1}">${episodes.size()}</strong>
                                        <label>Episódios</label>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="counter">
                                        <i class="fa fa-tag"></i>
                                        <strong data-to="${seasons}">${seasons}</strong>
                                        <label>Temporadas</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>

            <div class="featured-boxes featured-boxes-style-3 featured-boxes-flat">
                <div class="row col-md-3 col-sm-6">
                    <div class="col-md-12 col-sm-12">
                        <div class="featured-box featured-box-primary featured-box-effect-3" style="height: 128px;">
                            <div class="box-content">
                                <i class="icon-featured fa fa-clock-o"></i>
                                <h4>Horário</h4>
                                <p style="font-size: 16px; color:white;">${tvshow.airsDayOfWeek}, ${tvshow.airsTime}</p>
                            </div>
                        </div>
                        <div class="featured-box featured-box-secondary featured-box-effect-3" style="height: 128px;">
                            <div class="box-content">
                                <i class="icon-featured fa fa-hourglass-start"></i>
                                <h4>Tamanho do Episódio</h4>
                                <p style="font-size: 16px; color:white;">${tvshow.runtime} minutos</p>
                            </div>
                        </div>
                        <div class="featured-box featured-box-tertiary featured-box-effect-3" style="height: 128px;">
                            <div class="box-content">
                                <i class="icon-featured fa fa-cube"></i>
                                <h4>Categoria</h4>
                                <p style="font-size: 16px; color:white;">${tvshow.genre.get(0)}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">

                <div class="col-md-9">
                    <div class="heading heading-primary heading-border heading-bottom-border">
                        <h1 class="heading-primary">Sinopse</h1>
                    </div>

                    <p class="mt-none mb-xlg">${tvshow.overview}</p>

                    <div class="heading heading-primary heading-border heading-bottom-border">
                        <h1 class="heading-primary">Lista de episódios</h1>
                    </div>

                    <div class="col-md-12">
                        <div class="panel-group panel-group-quaternary" id="accordion2Quaternary">
                            <c:forEach begin="1" end="${seasons}" varStatus="loop">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2Quaternary" href="#collapse2Quaternary${loop.index}">
                                            ${loop.index}ª Temporada
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapse2Quaternary${loop.index}" class="accordion-body collapse <c:if test="${loop.index == 1}">in</c:if>">
                                    <div class="panel-body">
                                        <table class="table table-striped">
                                            <tbody>
                                            <c:forEach var="episode" items="${episodes}">
                                            <c:if test="${episode.airedSeason == loop.index }">
                                            <tr>
                                                <td>
                                                    ${episode.airedEpisodeNumber}
                                                </td>
                                                <td>
                                                    ${episode.episodeName}
                                                </td>
                                                <td>
                                                    ${episode.firstAiredPtBr}
                                                </td>
                                            </tr>
                                            </c:if>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>


                </div>

            </div>

        </div>

    </div>

</div>

<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <p>© Copyright 2016. Todos os direitos reservados.</p>
            </div>
            <div class="col-md-4">
                <nav id="sub-menu">
                    <ul>
                        <li><a href="#">FAQ's</a></li>
                        <li><a href="#">Sitemap</a></li>
                        <li><a href="contact-us.html">Contato</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</footer>
</div>

<!-- Vendor -->
<script src="<spring:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery.appear/jquery.appear.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery.easing/jquery.easing.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery-cookie/jquery-cookie.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/common/common.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery.validation/jquery.validation.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery.stellar/jquery.stellar.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery.easy-pie-chart/jquery.easy-pie-chart.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery.gmap/jquery.gmap.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/jquery.lazyload/jquery.lazyload.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/isotope/jquery.isotope.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/owl.carousel/owl.carousel.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js" />"></script>
<script src="<spring:url value="/resources/vendor/vide/vide.min.js" />"></script>

<!-- Theme Base, Components and Settings -->
<script src="<spring:url value="/resources/js/theme.js" />"></script>

<!-- Theme Custom -->
<script src="<spring:url value="/resources/js/custom.js" />"></script>

<!-- Theme Initialization Files -->
<script src="<spring:url value="/resources/js/theme.init.js" />"></script>

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

