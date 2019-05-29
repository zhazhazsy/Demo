<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>MyJSP</title>

</head>

<body>
<sql:setDataSource var="dbs" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/webroot"
                   user="root"  password="123" />
<sql:query dataSource="${dbs}" var="db">
    select*from buy;
</sql:query>
${db.id}
66666666666666666



</body>
</html>
