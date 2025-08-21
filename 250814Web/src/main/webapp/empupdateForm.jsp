<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP Update</title>
<style>
    table {
        border-collapse: collapse;
        margin: 20px 0;
    }
    td {
        padding: 8px 12px;
    }
    td:first-child {
        text-align: right;
        font-weight: bold;
        white-space: nowrap;
    }
    input[type="text"] {
        width: 200px;
        padding: 5px;
    }
    .btn-row {
        padding-top: 10px;
    }
</style>
</head>
<body>
<form action="empupdate" method="post">
    <table>
        <tr>
            <td>Empno :</td>
            <td>
                ${dto.empno}
                <input type="hidden" name="empno" value="${dto.empno}">
            </td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="ename" value="${dto.ename}"></td>
        </tr>
        <tr>
            <td>Job :</td>
            <td><input type="text" name="job" value="${dto.job}"></td>
        </tr>
        <tr>
            <td>Mgr :</td>
            <td><input type="text" name="mgr" value="${dto.mgr}"></td>
        </tr>
        <tr>
            <td>Hiredate :</td>
            <td><input type="text" name="hiredate" value="${dto.hiredate}"></td>
        </tr>
        <tr>
            <td>Sal :</td>
            <td><input type="text" name="sal" value="${dto.sal}"></td>
        </tr>
        <tr>
            <td>Comm :</td>
            <td><input type="text" name="comm" value="${dto.comm}"></td>
        </tr>
        <tr>
            <td>Deptno :</td>
            <td><input type="text" name="deptno" value="${dto.deptno}"></td>
        </tr>
        <tr>
            <td colspan="2" class="btn-row">
                <input type="submit" value="수정">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
