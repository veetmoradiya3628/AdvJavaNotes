<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Login - Spring MVC Demo</title>
    <style>
        body { font-family: Arial, sans-serif; display:flex; justify-content:center; align-items:center; height:100vh; background:#f5f5f5; }
        .login-container { background: #fff; padding: 20px 30px; border-radius: 5px; box-shadow: 0 2px 6px rgba(0,0,0,0.2); }
        input { display:block; margin: 10px 0; padding: 5px; width: 100%; }
        button { padding: 5px 10px; width: 100%; }
        .error { color: red; margin-top: 10px; }
        .logout { color: green; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Sign In</h2>
        <form action="${pageContext.request.contextPath}/perform_login" method="post">
            <label>Username: <input name="username" type="text" /></label>
            <label>Password: <input name="password" type="password" /></label>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Login</button>
        </form>

        <c:if test="${param.error != null}">
            <div class="error">Invalid username or password.</div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="logout">You have been logged out successfully.</div>
        </c:if>
    </div>
</body>
</html>
