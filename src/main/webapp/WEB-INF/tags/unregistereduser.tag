<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<html>
<body>
        <jsp:invoke fragment="header"/>

        <!-- Navigation bar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Database for Beers and Brewerys</a>
                </div>
                <!-- Sign In -->
                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form">
                        <div class="form-group">
                            <input type="text" placeholder="Username" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-default">Sign In</button>
                    </form>
                    <button type="submit" id="registration-button" class="btn btn-default" data-toggle="modal" data-target="#registration">Sign Up</button>
                </div>
            </div>
        </nav>

        <!-- Registration pop-up -->
        <div class="modal" id="registration" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                        <span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">Registration</h4>
                    </div>
                    <div class="modal-body">
                        <div class="col-lg-6">
                            <form:form commandName="user" method="POST" action="/registration">
                                Username:
                                <input type="text" class="form-control" name="username">
                                Firstname:
                                <input type="text" class="form-control" name="firstname">
                                Lastname:
                                <input type="text" class="form-control" name="lastname">
                                Email:
                                <input type="text" class="form-control" name="email">
                                <br>
                                Password:
                                <input type="text" class="form-control" name="password">
                                Password:
                                <input type="text" class="form-control" name="password2">
                                <br>
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

</body>
</html>