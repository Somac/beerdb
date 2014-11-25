<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- Modals have to be in own file so that navigationbar.tag remains usable elsewhere in the code. Otherwise sign up / sign in form is
following you to anywhere and blows all the other spring forms & requires empty User object in every GET method -->

<!-- SIGN UP MODAL -->
<div class="modal" id="sign-up-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="loginbox" class="mainbox col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <!-- Modal head -->
                <div class="panel-heading">
                    <div class="panel-title">Sign Up</div>
                    <button type="button" class="close login-close-button" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                </div>
                <!-- Modal body -->
                <div class="login-panel-body panel-body">
                    <form:form id="validate-sign-up-form" modelAttribute="user" method="POST" action="${context}/signup"
                               class="form-horizontal" role="form">
                        <!-- Username -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"></span>
                            <form:input path="username" class="form-control" placeholder="username"/>
                        </div>

                        <!-- Firstname -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"></span>
                            <form:input path="firstname" class="form-control" placeholder="firstname"/>
                        </div>

                        <!-- Lastname -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"></span>
                            <form:input path="lastname" class="form-control" placeholder="lastname"/>
                        </div>

                        <!-- Email -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"></span>
                            <form:input path="email" class="form-control" placeholder="email"/>
                        </div>

                        <!-- Password -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"></span>
                            <form:input path="password" type="password" class="form-control" placeholder="password" id="password"/>
                        </div>

                        <!-- Password -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"></span>
                            <input name="password2" type="password" class="form-control" placeholder="password"/>
                        </div>

                        <!-- signupError = "Username already exists" / "Email already exists" -->
                        <div class="error login-input-group"><c:out value="${signupError}"/></div>

                        <div class="login-form-group form-group">
                            <div class="col-sm-12 controls">
                                <button type="submit" class="btn btn-success">Sign Up</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- SIGN IN MODAL -->
<div class="modal" id="sign-in-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div id="loginbox" class="mainbox col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <!-- Modal head -->
                <div class="panel-heading">
                    <div class="panel-title">Sign In</div>
                    <button type="button" class="close login-close-button" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                </div>
                <!-- Modal body -->
                <div id="login-panel-body" class="panel-body" >
                    <form action="j_spring_security_check" method="POST" id="loginform" class="form-horizontal" role="form" >
                        <!-- Username -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input id="login-username" type="text" class="form-control" name="j_username" placeholder="username">
                        </div>

                        <!-- Password -->
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input id="login-password" type="password" class="form-control" name="j_password" placeholder="password">
                        </div>

                        <!-- loginError = "Username and/or password is wrong!" -->
                        <div class="error login-input-group"><c:out value="${loginError}"/></div>

                        <div id="login-form-group form-group">
                            <div class="col-sm-12 controls">
                                <button type="submit" class="btn btn-success">Login</button>
                            </div>
                        </div>
                    </form>
                </div> <!-- login-panel-body -->
            </div> <!-- panel -->
        </div> <!-- loginbox -->
    </div> <!-- modal-dialog -->
</div> <!-- modal -->