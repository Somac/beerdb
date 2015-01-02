<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
    <c:set var="principalUsername">
        <sec:authentication property="principal.username" />
    </c:set>
</sec:authorize>
<html>
<head>
<!-- Links and scripts -->
<t:dependencies></t:dependencies>
</head>
<body>
<!-- Navigation bar (tag file) -->
<t:navigationbar></t:navigationbar>

<!-- Sign Up & Sign In forms -->
<div class="container">
    <div class="row">
        <!-- Sign Up -->
        <div class="col-md-6 text-center">
            <form:form id="validate-sign-up-form" modelAttribute="user" method="POST" action="${context}/signup"
                       class="form-horizontal" role="form">
                <h1>Sign Up</h1>

                <!-- Username -->
                <p class="lato text-left">Username *</p>
                <div class="input-group login-input-group">
                    <!-- Nested span makes empty square to the left side of field -->
                    <span class="input-group-addon"><span></span></span>
                    <form:input path="username" class="form-control"/>
                </div>

                <!-- Firstname -->
                <p class="lato text-left">Firstname</p>
                <div class="input-group login-input-group">
                    <span class="input-group-addon"><span></span></span>
                    <form:input path="firstname" class="form-control"/>
                </div>

                <!-- Lastname -->
                <p class="lato text-left">Lastname</p>
                <div class="input-group login-input-group">
                    <span class="input-group-addon"><span></span></span>
                    <form:input path="lastname" class="form-control"/>
                </div>

                <!-- Email -->
                <p class="lato text-left">Email *</p>
                <div class="input-group login-input-group">
                    <span class="input-group-addon"><span></span></span>
                    <form:input path="email" class="form-control"/>
                </div>

                <!-- Password -->
                <p class="lato text-left">Password *</p>
                <div class="input-group login-input-group">
                    <span class="input-group-addon"><span></span></span>
                    <form:input path="password" type="password" class="form-control" id="password"/>
                </div>

                <!-- Password -->
                <p class="lato text-left">Password *</p>
                <div class="input-group login-input-group">
                    <span class="input-group-addon"><span></span></span>
                    <input name="password2" type="password" class="form-control"/>
                </div>

                <!-- signupError = "Username already exists" / "Email already exists" -->
                <div class="error login-input-group"><c:out value="${signupError}"/></div>
                <div class="form-group" id="errors"></div>

                <div class="login-form-group form-group">
                    <div class="col-sm-12 controls">
                        <button type="submit" class="btn btn-success">Sign Up</button>
                    </div>
                </div>
            </form:form>
        </div>
        <!-- Sign In -->
        <div class="col-md-6 text-center">
            <form action="j_spring_security_check" method="POST" id="loginform" class="form-horizontal" role="form" >
                <h1>Sign In</h1>
                <!-- Username -->
                <p class="lato text-left">Username</p>
                <div class="input-group login-input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    <input id="login-username" type="text" class="form-control" name="j_username">
                </div>

                <!-- Password -->
                <p class="lato text-left">Password</p>
                <div class="input-group login-input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="login-password" type="password" class="form-control" name="j_password">
                </div>

                <!-- loginError = "Username and/or password is wrong!" -->
                <div class="error login-input-group"><c:out value="${loginError}"/></div>

                <div id="login-form-group form-group">
                    <div class="col-sm-12 controls">
                        <button type="submit" class="btn btn-success">Sign In</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Footer  -->
<t:footer></t:footer>
</body>
</html>
