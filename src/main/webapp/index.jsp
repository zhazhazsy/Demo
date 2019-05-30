<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户评价</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
        list-style: none;
    }
    html,body{
        width: 100%;
    }
    .header{
        height: 1px;
        background: #ffffff;
        color: aqua;
        text-align: center;
    }
    .nav{
        height: 69px;
        width: 100%;
        background: #ffffff;
        font: 200 15px/70px simhei;
        text-align: center;
    }
    .fixed {
        position: fixed;
        top: 0;
        left: 0;
    }
    .a1:hover{
        background-image: url(img/bagtop.jpg);
        color: red;
    }
    .a2:hover{
        background-image: url(img/bagtop.jpg);
        color: red;
    }
    #nav #nav5{
        height: 69px;
        width: 11%;
        float: left;
        background-color: red;
        color: #ffffff;
    }
    #nav #nav5:hover{
        background-color: #FF3030;
    }
    .list-group-item:hover{
        background-image: url(img/bag/bagmn.jpg);
        background-repeat: no-repeat;
    }
    #mu1{
        border-bottom: 0px;
    }
    fieldset{
        margin:auto;
        border:4px solid blue;
    }
    #tu{
        border-style:outset;
    }
</style>
<body>
<a href="login.html">去登陆</a>

</body>
</html>
<script>
    var header = document.getElementById('header');
    var nav = document.getElementById('nav');
    var content = document.getElementById('con');
    function getScrollTop() {
        return window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    }

    // 给页面注册滚动事件
    window.onscroll = function() {
        var scrollTop = getScrollTop();
        if (scrollTop >= header.offsetHeight) {
            nav.className = "nav fixed";
            content.style.marginTop = nav.offsetHeight + "px";
        } else {
            nav.className = "nav";
            content.style.marginTop = 0;
        }
    };
</script>
