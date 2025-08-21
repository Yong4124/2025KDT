<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%
    
    request.setCharacterEncoding("UTF-8");

    String username = request.getParameter("username");
    String address = request.getParameter("address");
    String email = request.getParameter("email");
    String cel = request.getParameter("cel");

    String jdbcURL = "jdbc:mysql://localhost:3305/user_db?useUnicode=true&characterEncoding=UTF-8";
    String dbUser = "root";
    String dbPassword = "1234";

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        String sql = "INSERT INTO users (username, address, email, cel) VALUES (?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, address);
        stmt.setString(3, email);
        stmt.setString(4, cel);

        int result = stmt.executeUpdate();

        if (result > 0) {
            out.println("<h3>회원 가입이 완료되었습니다!</h3>");
        } else {
            out.println("<h3>회원 가입에 실패했습니다.</h3>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h3>오류 발생: " + e.getMessage() + "</h3>");
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<a href="signUp.jsp">돌아가기</a>
</body>
</html>
