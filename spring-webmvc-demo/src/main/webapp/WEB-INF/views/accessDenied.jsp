<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <title>Access Denied - Spring MVC Demo</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        header, nav, footer { background: #f0f0f0; padding: 10px 20px; }
        nav a, nav form button { margin-right: 10px; text-decoration: none; }
        main { padding: 20px; color: red; }
        button { padding: 5px 10px; }
    </style>
</head>
<body>
    <header>
        <h1>Access Denied</h1>
        <nav>
            <a href="${pageContext.request.contextPath}/">Home</a>
            <sec:authorize access="hasRole('USER')">
                <a href="${pageContext.request.contextPath}/user">User Page</a>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <a href="${pageContext.request.contextPath}/admin">Admin Page</a>
            </sec:authorize>

            <form action="${pageContext.request.contextPath}/logout" method="post" style="display:inline;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button type="submit">Logout</button>
            </form>
        </nav>
    </header>

    <main>
        <p>Sorry, <sec:authentication property="name" />! You do not have permission to access this page.</p>
    </main>

    <footer>
        &copy; 2025 Spring MVC Demo
    </footer>
</body>
</html>
