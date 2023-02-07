<html>
<link rel="stylesheet" href="style/index.css">
<head>
    <title>Catalog</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<h2 style="text-align: center ; margin-top: 20px">Welcome  ${userEmail}  </h2>

    <div class="container">
        <form  method="post">
            <div class="table">
                <div class="head">
                    <div class="cell">Completed</div>
                    <div class="cell">Name magazine</div>
                    <div class="cell">Price($)</div>
                </div>
                <div class="row">
                    <form class="cell">
                    </form>
                    <div class="cell"></div>
                    <div class="cell"></div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">ADAC Motorwelt</div>
                    <div class="cell">100</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">Reader's Digest </div>
                    <div class="cell">67</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">Cosmopolitan </div>
                    <div class="cell">45</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">National Geographic</div>
                    <div class="cell">20</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">Good Housekeeping</div>
                    <div class="cell">84</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">Gushi Hui</div>
                    <div class="cell">58</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">Glamour</div>
                    <div class="cell">37</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">Pink</div>
                    <div class="cell">62</div>
                </div>
                <div class="row">
                    <form class="cell">
                        <input type="checkbox">
                    </form>
                    <div class="cell">Watchtowe</div>
                    <div class="cell">95</div>
                </div>
            </div>
            <div>
            <button type="subscribe"><b>Subscribe</b></button>
            <button type="unsubscribe"><b>Unsubscribe</b></button>
        </div>
        </form>


    </div>
    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
