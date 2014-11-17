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
                    <ul class="nav navbar-nav navbar-right">
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
                            <form:form id="validate-form" modelAttribute="user" method="POST" action="/signup">
                                Username:
                                <form:input path="username" class="form-control"/>
                                <form:errors path="username"/>
                                Firstname:
                                <form:input path="firstname" class="form-control"/>
                                <form:errors path="firstname"/>
                                Lastname:
                                <form:input path="lastname" class="form-control"/>
                                <form:errors path="lastname"/>
                                Email:
                                <form:input path="email" class="form-control"/>
                                <form:errors path="email"/>
                                Password:
                                <form:input path="password" type="password" class="form-control" id="password"/>
                                <form:errors path="password"/>
                                Password:
                                <input name="password2" type="password" class="form-control"/>

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
                            <form action="j_spring_security_check" method="POST">
                                Username:
                                <input type="text" class="form-control" name="j_username">
                                Password:
                                <input type="password" class="form-control" name="j_password">

                                <button type="submit" class="btn btn-primary">Go!</button>
                            </form>
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