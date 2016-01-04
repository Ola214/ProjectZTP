
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
        <title>Wypożyczalnia</title>
        <link href="style.css" rel="stylesheet" type="text/css">
        <link href="css/fontello.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

        <style type="text/css">

            input[type=text] {
                font-size: 20px;
                font-weight: bold;
                font-family: 'Lato', sans-serif;
                padding:5px; 
                border:2px solid #ccc; 
                -webkit-border-radius: 5px;
                border-radius: 5px;
            }

            input[type=text]:focus {
                border-color:#333;
            }

            input[type=submit] {
                padding:5px 15px; 
                background-color: #c34f4f;
                color: #ffffff;
                font-size: 20px;
                font-weight: bold;
                border:0 none;
                cursor:pointer;
                -webkit-border-radius: 5px;
                border-radius: 5px; 
                font-family: 'Lato', sans-serif;
            }

            body
            {
                background-color: #303030;
                color: #ffffff;
                font-family: 'Lato', sans-serif;
                font-size: 20px;
                margin: 0 !important;
            }

            .wraper
            {
                width: 100%;
            }

            #logo2
            {
                color: #c34f4f;
            }

            .header
            {
                width: 100%;
                padding: 40px 0; /*pading w pionie, padding w poziomie*/
            }

            .logo
            {
                width: 500px;
                font-size: 48px;
                margin-left: auto;
                margin-right: auto;
            }

            .nav
            {
                width: 100%;
                padding: 10px 0;
                background-color: #c34f4f;
                text-align: center;
                border-top: 1px solid #751b1b;
                border-bottom: 1px solid #751b1b;
            }

            .content
            {
                //text-align: center;
                width: 1000px;
                margin-left: auto;
                margin-right: auto;
                text-align: justify;
                padding-top: 10px;
            }

            .socials
            {
                width: 100%;
                text-align: center;
                background-color: #292929;
            }

            .socialdivs
            {
                width: 1000px;
                margin-left: auto;
                margin-right: auto;
            }

            .fb
            {
                width: 250px;
                height: 155px;
                float:left;
            }

            .fb:hover
            {
                background-color: #4668b3;
            }

            .yt
            {
                width: 250px;
                height: 155px;
                float:left;
            }

            .yt:hover
            {
                background-color: #d94348;
            }

            .tw
            {
                width: 250px;
                height: 155px;
                float:left;
            }

            .tw:hover
            {
                background-color: #3095d3;
            }

            .gplus
            {
                width: 250px;
                height: 155px;
                float:left;
            }

            .gplus:hover
            {
                background-color: #d95333;
            }

            .footer
            {
                text-align: center;
                background-color: #222222;
                padding: 30px;
            }

            .sticky
            {
                width: 100%;
                position: fixed;
                left: 0;
                top: 0;
                z-index: 100; /*zasłanianie się, będzie na wierzchu, im większy z-index tym bardziej na wierzchu */
            }

            ol
            {
                padding: 0;
                margin: 0;
                list-style-type: none;
                font-size: 18px;
                height: 35px;
                line-height: 200%;
                display: inline-block; /*wspoczyło text-align z nav*/
            }

            ol a
            {
                color: #ffffff;
                text-decoration: none;
                display: block;
            }

            ol > li /*stylizujemy element li, którego rodzicem jest ol */
            {
                float: left;
                width: 150px;
                height: 40px;
                border-right: 1px dashed #751b1b;
            }

            ol > li:first-child
            {
                border-left: 1px dashed #751b1b;
            }

            ol > li:hover
            {
                background-color: #cf6969;
            }

            ol > li:hover > a
            {
                color: #451717;
            }

            ol > li > ul
            {
                list-style-type: none;
                padding: 0;
                margin: 0;
                height: 40px;
                display: none; /*nie wyświetlaj podmenu*/
            }

            ol > li:hover > ul /*hover może ogarnąć na którym elemencie zaszła akcja - gdzie jest kursor*/
            {
                display: block;
            }

            ol > li > ul > li /*ol ma potomka li, a li potomka ul ... */
            {
                background-color: #cf6969;
                position: relative;
                z-index: 100;
                border-top: 1px dashed #751b1b;
            }

            ol > li > ul > li:hover
            {
                background-color: #c34f4f;
            }

            ol > li > ul > li:hover > a
            {
                color: #451717;
            }

            
        </style>
    </head>

    <body>
        <div class="wrapper">
            <div class="header">
                <div class="logo">
                   
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