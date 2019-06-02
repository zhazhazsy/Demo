<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <style>
        .chao{
            background-color: #FFFFFF;
            width: 280px;
            height:60px;
            border-radius: 20px;
            border-style: solid;
            margin-top: 2px;
        }
        .chao:hover{
            background-color: #d4d4d4;
        }
    </style>

</head>

<body>
<s:iterator value="#session.list">
    <a href="evaluateAction?id=<s:property value="muneid"/>">
    <div class="chao">
        <div style="float:left;width: 30%;">
            <img width="50px" style="margin-left: 20px;margin-top: 2px;" src="img/mune/<s:property value="muneid"/>.png">
        </div>
        <div style="float: left;width: 69%;margin-top: 5px;">
            <font style="font-weight: bold;">
                 <s:property value="munename"/>
            </font>
                <br>
            <font color="red" style="font-weight: bold;">
                <s:property value="price"/>
            </font>
            <font size="1" color="#696969">
                元
            </font>
        </div>
    </div>
    </a>
</s:iterator>
</body>
</html>
