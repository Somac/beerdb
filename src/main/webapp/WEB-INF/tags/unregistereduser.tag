<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<html>
<body>
        <jsp:invoke fragment="header"/>

        <!-- Navigation bar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Database for Beers and Brewerys</a>
                </div>
                <!-- Sign in -->
                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form">
                        <div class="form-group">
                            <input type="text" placeholder="Username" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-default">Sign in</button>
                        <button type="submit" class="btn btn-default">Sign Up</button>
                    </form>
                </div>
            </div>
        </nav>

</body>
</html>