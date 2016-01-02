
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
        <title>Wypożyczalnia</title>
        <meta name="description" content="Serwis o starych grach pochodzÄcych z Nintendo Entertainment System">
        <meta name="keywords" content="gry, komputerowe, retro, nes, konsole, retrogranie, stare gry">
        <link href="style3.css" rel="stylesheet" type="text/css">
        <link href="css/fontello.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

    </head>

    <body>
        <div class="wrapper">
            <div class="header">
                <div class="logo">
                    <img src="ProjectZTP/pad.png" style="float: left;">
                    <span id="logo2"style="color: #c34f4f">wypozyczalnia</span>.com
                    <div style="clear: both">
                    </div>
                </div>
                <div class="nav">
                    <ol>
                        <li><a href="index2.jsp">Strona główna</a></li>
                        <li><a href="#">Wypożyczalnia</a>
                            <ul>
                                <li><a href="FrontBin">Kosz</a></li>
                                <li><a href="FrontArchieve">Archiwum</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Zarządzaj</a>
                            <ul>
                                <li><a href="FrontBook">Książkami</a></li>
                                <li><a href="FrontRental">Wypożyczeniami</a></li>
                                <li><a href="FrontWorker">Pracownikami</a></li>
                                <li><a href="FrontUser">Użytkownikami</a></li>
                                <li><a href="FrontCathegory">Kategoriami</a></li>
                                <li><a href="FrontTag">Etykietami</a></li>
                                <li><a href="FrontProfile">Profilem</a></li>
                                <li><a href="FrontQuote">Wpisami</a></li>
                            </ul>
                        </li>
                        <li><a href="login2.jsp">Zaloguj</a>
                        </li>
                        <li><a href="signup2.jsp">Zarejestruj</a>
                        </li>
                        <li><a href="Logout">Wyloguj</a></li>
                        <li><a href="#">Skórki</a>
                            <ul>
                                <li><a href="javascript:void(fChangeStyle())" id="style" onchange="fChangeStyle()" >Modern</a></li>
                                <li><a href="javascript:void(fChangeStyle2())" id="style2" onchange="fChangeStyle2()" >Pink</a></li>
                                <li><a href="javascript:void(fChangeStyle3())" id="style3" onchange="fChangeStyle3()" >Sunny</a></li>
                            </ul>
                        </li>

                    </ol>
                </div>
                <div class="content">
                    <table border="1">
                        <c:forEach items="${produkty}" var="produkt">
                            <tr>
                                <td>${produkt}</td>
                            </tr>
                        </c:forEach></table>
                </div>
                <div class="socials">
                    <div class="socialdivs">
                        <div class="fb"><i class="icon-facebook"></i></div>
                        <div class="yt"><i class="icon-youtube"></i></div>
                        <div class="tw"><i class="icon-twitter"></i></div>
                        <div class="gplus"><i class="icon-gplus"></i></div>
                        <div style="clear: both"></div>
                    </div>
                </div>
                <div class="footer">wypozyczalnia.com &copy; 2015 Thank you for your visit;-)</div>
            </div>
            <script src="jquery-1.11.3.min.js"></script>
            <script>
                                    $(document).ready(function () {
                                        var NavY = $('.nav').offset().top;

                                        var stickyNav = function () {
                                            var ScrollY = $(window).scrollTop();

                                            if (ScrollY > NavY) {
                                                $('.nav').addClass('sticky');
                                            } else {
                                                $('.nav').removeClass('sticky');
                                            }
                                        };

                                        stickyNav();

                                        $(window).scroll(function () {
                                            stickyNav();
                                        });
                                    });

                                    function fChangeStyle() {


                                        document.getElementsByTagName('link')[0].href = "style.css";

                                    }
                                    function fChangeStyle2() {


                                        document.getElementsByTagName('link')[0].href = "style2.css";

                                    }
                                    function fChangeStyle3() {


                                        document.getElementsByTagName('link')[0].href = "style3.css";

                                    }
            </script>
    </body>
</html>