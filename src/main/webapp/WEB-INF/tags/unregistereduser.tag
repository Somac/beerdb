<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<html>
<body>
        <jsp:invoke fragment="header"/>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
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
                <!-- Navigation bar -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#" id="open-sign-up-modal">Sign Up</a>
                        </li>
                        <li>
                            <a href="#" id="open-sign-in-modal">Sign In</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- SIGN UP pop-up -->
        <div class="modal" id="sign-up-modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" id="reset-form" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">SIGN UP</h4>
                    </div>
                    <div class="modal-body">
                        <div class="col-lg-6">
                            <form:form id="validate-form" commandName="user" method="POST" action="/registration">
                                Username:
                                <input type="text" class="form-control" name="username">
                                Firstname:
                                <input type="text" class="form-control" name="firstname">
                                Lastname:
                                <input type="text" class="form-control" name="lastname">
                                Email:
                                <input type="text" class="form-control" name="email">
                                Password:
                                <input type="password" class="form-control" name="password" id="password">
                                Password:
                                <input type="password" class="form-control" name="password2">

                                <button type="submit" class="btn btn-primary">Seivaa!</button>
                            </form:form>
                        </div>
                        <div class="col-lg-6">
                            <!-- prerendered text, username validation? -->
                        </div>
                        <div class="modal-footer">
                            <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                            <%--<button type="submit" class="btn btn-primary">Save changes</button>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- LOG IN pop-up -->
        <div class="modal" id="sign-in-modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">SIGN IN</h4>
                    </div>
                    <div class="modal-body">
                        <div class="col-lg-6">
                            <form:form action="#">
                                Username:
                                <input type="text" class="form-control" name="username">
                                Password:
                                <input type="password" class="form-control" name="password">

                                <button type="submit" class="btn btn-primary">Go!</button>
                            </form:form>
                        </div>
                        <div class="col-lg-6">
                            <!-- prerendered text, username validation? -->
                        </div>
                        <div class="modal-footer">
                            <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                            <%--<button type="submit" class="btn btn-primary">Save changes</button>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>