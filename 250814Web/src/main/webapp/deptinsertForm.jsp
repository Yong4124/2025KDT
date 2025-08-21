<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept Insert</title>
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
<form action="deptinsert" method="post">
    <table>
        <tr>
            <td>No :</td>
            <td><input type="text" name="deptno"></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="dname"></td>
        </tr>
        <tr>
            <td>Loc :</td>
            <td><input type="text" name="loc"></td>
        </tr>
        <tr>
            <td colspan="2" class="btn-row">
                <input type="submit" value="추가">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
