<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
    <c:set var="principalUsername">
        <sec:authentication property="principal.username" />
    </c:set>
</sec:authorize>

<!-- Image above navbar-->
<div class="banner">
    <img class="banner-image" src="<c:url value="/resources/logos/beerbanner.jpg"/>">
    </img>
</div>

<!-- Navigation bar -->
<nav class="navbar navbar-inverse navbar" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <!-- Mobile header -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">BeerDB</a>
        </div>

        <!-- Navigation -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">

                <!-- Sign Up / Sign In links are shown for the unregistered user -->
                <sec:authorize access="isAnonymous()">
                    <li>
                        <a href="#" class="open-sign-up-modal">Sign Up</a>
                    </li>
                    <li>
                        <a href="#" id="open-sign-in-modal">Sign In</a>
                    </li>
                </sec:authorize>

                <!-- Dropdown menu are shown for the registered user -->
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form action="#">
                            <a href="${context}/registered/addbeer" type="submit" class="btn btn-success navbar-btn">Add beer</a>
                        </form>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <span class=""></span>
                            ${principalUsername} <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="${context}/registered/profile" type="submit">Profile</a></li>
                            <li><a href="#">Settings</a></li>
                            <li class="divider"></li>
                            <li><a href="${context}/logout">
                                <span class="glyphicon glyphicon-log-out"></span>
                                Log out</a>
                            </li>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </div>

    </div>
</nav>