<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP Insert</title>
<style>
    table {
        border-collapse: collapse;
        margin: 20px 0;
    }
    td {
        padding: 8px 10px;
    }
    td:first-child {
        text-align: right;
        font-weight: bold;
        white-space: nowrap;
    }
    input {
        width: 200px;
        padding: 5px;
    }
</style>
</head>
<body>
<form action="empinsert" method="post">
    <table>
        <tr>
            <td>No :</td>
            <td><input type="text" name="empno"></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="ename"></td>
        </tr>
        <tr>
            <td>Job :</td>
            <td><input type="text" name="job"></td>
        </tr>
        <tr>
            <td>Mgr :</td>
            <td><input type="text" name="mgr"></td>
        </tr>
        <tr>
            <td>Hiredate :</td>
            <td><input type="date" name="hiredate"></td>
        </tr>
        <tr>
            <td>Sal :</td>
            <td><input type="text" name="sal"></td>
        </tr>
        <tr>
            <td>Comm :</td>
            <td><input type="text" name="comm"></td>
        </tr>
        <tr>
            <td>Deptno :</td>
            <td><input type="text" name="deptno"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <input type="submit" value="추가">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
