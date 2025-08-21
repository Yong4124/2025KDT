<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept Update</title>
<style>
    table {
        border-collapse: collapse;
        margin: 20px 0; /* 왼쪽 정렬 */
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
<form action="deptupdate" method="post">
    <input type="hidden" name="deptno" value="${dto.deptno}" />
    <table>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="dname" value="${dto.dname}"></td>
        </tr>
        <tr>
            <td>Loc :</td>
            <td><input type="text" name="loc" value="${dto.loc}"></td>
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
