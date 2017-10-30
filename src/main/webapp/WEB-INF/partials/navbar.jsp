<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header"><img src="/assets/images/blue_dog.png" width="45" height="45">
            <a class="navbar-brand" href="/ads">Trash Hound</a>
        </div>
        <form class="navbar-form navbar-left">
            <div class="form-group">
                <input class="form-control" placeholder="Search" id="search">
            </div>
            <button type="button" class="btn btn-default" id="button-search">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li>



            </li>
            <li><a href="/ads">Ad Index</a></li>
            <c:choose>
                <c:when test="${user==null}">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:when>
                <c:when test="${user!=null}">
                    <li><a href="/ads/create">Create Ad</a></li>
                    <li><a href="/profile">Profile</a> </li>
                    <li><a href="/logout">Logout</a></li>
                </c:when>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->


</nav>


<script type="text/javascript">



document.getElementById('button-search').addEventListener('click', function(){
    var searchBox = document.getElementById('search').value;
    window.location.replace("/search?searchTerms="+searchBox);
    console.log(searchBox);
    return searchBox;

});
</script>