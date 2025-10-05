<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <title>Admin Page - Spring MVC Demo</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        header, nav, footer { background: #f0f0f0; padding: 10px 20px; }
        nav a, nav form button { margin-right: 10px; text-decoration: none; }
        main { padding: 20px; }
        button { padding: 5px 10px; }
    </style>
</head>
<body>
    <header>
        <h1>Admin Page</h1>
        <nav>
            <a href="${pageContext.request.contextPath}/">Home</a>
            <form action="${pageContext.request.contextPath}/logout" method="post" style="display:inline;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button type="submit">Logout</button>
            </form>
        </nav>
    </header>

    <main>
        <p>Welcome, <sec:authentication property="name" />! You have ADMIN privileges.</p>
        <p>Here you can manage admin-specific features and access restricted resources.</p>
    </main>

    <footer>
        &copy; 2025 Spring MVC Demo
    </footer>
</body>
</html>
