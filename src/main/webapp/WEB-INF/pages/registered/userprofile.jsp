<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Links and scripts (tag file) -->
    <t:dependencies></t:dependencies>
</head>
<body>
<!-- Navigation bar (Tag file) -->
<t:navigationbar></t:navigationbar>

<div class="container gap">
    <div class="row">

        Placeholder page. These are going to be editable etc.

        <p>Username: ${user.username}</p>
        <p>Email: ${user.email}</p>
        <p>Created: ${user.created}</p>

    </div>
</div>



<!-- Footer (tag files) -->
<t:footer></t:footer>
</body>
</html>
