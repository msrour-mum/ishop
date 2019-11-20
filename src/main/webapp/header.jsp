<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#"> <span STYLE="color: yellow">i</span><span STYLE="color: white">Shop</span>  </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <c:if test="${userData!=null && userData.isAdmin==true}">

                <li class="nav-item">
                    <a class="nav-link" href="/products">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="orders">Orders</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="#">|</a>
            </li>

            <c:if test="${userData!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Hello "${userData.userName}"</a>

                </li>

            </c:if>

            <c:if test="${userData==null}">
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
            </c:if>


        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
        </form>
        <span class="price" style="font-size:24px;color:yellow;margin-left: 1em;">
       <a href="/cart">     <i class="fa fa-shopping-cart"></i>
            <b>4</b>
           </a>
        </span>
    </div>
</nav>