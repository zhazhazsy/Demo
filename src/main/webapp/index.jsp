<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户评价</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <script type="text/javascript" src="js/zturn.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Open Sans', sans-serif;
        background-color:#10729c;
        background-image: -moz-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: -webkit-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: -o-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: -ms-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);overflow: hidden;
    }
    header {
        background-color: rgba(0,0,0,0.2);
        position: absolute;
        height: 80px;
        width: 100%;
        left: 0px;
        bottom: 20px;
    }

    header h1 {
        text-transform: uppercase;
        margin-left: 0px;
        margin-top: 0px;
        line-height: 70px;
        font-weight: 600;
        font-size: 40px;
        opacity: 0.8;
        color: #fff;
    }
    h1,
    h2,
    h3,
    h4,
    h5,
    h6,
    ol,
    li,
    ul,
    p,
    dl,
    dt,
    dd {
        padding: 0;
        margin: 0
    }

    ul,
    ol,
    li,
    dl,
    dt,
    dd {
        text-decoration: none;
        list-style: none
    }

    .lf {
        float: left
    }

    .rt {
        float: right
    }

    .clear {
        clear: both
    }

    .ovh {
        overflow: hidden
    }

    a {
        color: #303030;
        text-decoration: none;
    }

    a:hover {
        text-decoration: none;
    }

    input {
        border: none;
        outline: none;
    }

    img {
        border: none
    }
    /*轮播*/

    html,
    body {
        width: 100%;
        height: 100%;
        font-family: 'Open Sans', sans-serif;
        background-color:#10729c;
        background-image: -moz-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: -webkit-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: -o-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: -ms-radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);
        background-image: radial-gradient(50% 50%, ellipse cover, #10729c, #000030 100%);overflow: hidden;
        overflow:scroll;
        overflow-x:hidden;
        overflow-y:hidden;
    }

    .lb_gl {
        height: 100%;
    }

    .container {
        width: 100%;
        position: relative;
        height: 100%;
    }

    .pictureSlider {
        height: 100%;
        transform: rotate(90deg) translateY(25%) translateX(-25%);
    }

    .poster-list {
        width: 100%;
        height: 100%;
        margin-top: -250px;
    }

    .poster-item {
        background: #fff;
        height: 70%;
        width: 90%;
        margin-top: -100px;
        border-radius: 10px;
        padding: 45px 23px 20px 23px;
        transition: all 0.5s;
        cursor: default;
        -moz-transition: all 0.5s;
        cursor: default;
        -webkit-transition: all 0.5s;
        cursor: default;
        -o-transition: all 0.5s;
        cursor: default;
        transform: rotate(-90deg);
        overflow: hidden;
    }

    .turn_3d {
        text-align: center;
        color: #fff;
        font-weight: 400;
        font-size: 36px;
        padding: 28px 0;
    }
    .poster-item .say {
        font-size: 18px;
        margin-bottom: 5px;
        padding-left: 10px;
    }

    .students_star {
        padding: 10px 10px 0 10px;
    }

    .cell_list {
        margin-bottom: 20px;
        color: #999;
        font-size: 18px;
        overflow: hidden;
    }

    .darks {
        color: #000;
        padding-left: 10px;
    }

    .zwjs {
        border-top: 1px solid #d0cddb;
        line-height: 26px;
        padding-top: 5px;
        color: #999;
        font-size: 12px;
        max-height: 84px;
        overflow: hidden;
    }

    .for_btn {
        position: relative;
        height: 100%;
        overflow: hidden
    }

    .in_page {
        position: absolute;
        left: 50%;
        top: 50%;
        width: 40px;
        height: 40px;
        margin-left: -20px;
        margin-top: -20px;
    }

    .in_page>img {
        width: 40px;
        height: 40px;
    }

    .check_more {
        width: 180px;
        height: 50px;
        line-height: 50px;
        text-align: center;
        color: #fff;
        background: #bc241d;
        margin: 0 auto;
        display: block;
    }
    header {
        background-color: rgba(0,0,0,0.2);
        position: absolute;
        height: 80px;
        width: 100%;
        left: 0px;
        bottom: 20px;
    }

    header h1 {
        text-transform: uppercase;
        margin-left: 0px;
        margin-top: 0px;
        line-height: 70px;
        font-weight: 600;
        font-size: 40px;
        opacity: 0.8;
        color: #fff;
    }
</style>
</style>
<body>
<div style="height: 700px;width: 100%;margin:0 auto;">
    <!--轮播-->

    <div class="lb_gl">
        <div class="container">
            <div class="pictureSlider poster-main">
                <ul id="zturn" class="poster-list">


                    <li class="poster-item zturn-item">
                        <div class="for_btn">
                            <img src="img/a2.jpg" width="100%">
                        </div>

                    </li>

                    <li class="poster-item zturn-item">
                        <div class="for_btn">
                            <img src="img/a3.jpg" width="100%">
                        </div>

                    </li>

                    <li class="poster-item zturn-item">
                        <div class="for_btn">
                            <img src="img/a1.jpg" width="100%">
                        </div>

                    </li>

                    <li class="poster-item zturn-item">
                        <div class="for_btn">
                            <img src="img/a2.jpg" width="100%">
                        </div>

                    </li>
                    <li class="poster-item  zturn-item">
                        <div class="for_btn">
                            <img src="img/a3.jpg" width="100%">
                        </div>

                    </li>

                    <li class="poster-item zturn-item">
                        <div class="for_btn">
                            <img src="img/a1.jpg" width="100%">
                        </div>

                    </li>

                    <li class="poster-item zturn-item">
                        <div class="for_btn">
                            <img src="img/a2.jpg" width="100%">
                        </div>

                    </li>
                    <li class="poster-item  zturn-item">
                        <div class="for_btn">
                            <img src="img/a3.jpg" width="100%">
                        </div>

                    </li>
                    <li class="poster-item  zturn-item">
                        <div class="for_btn">
                            <img src="img/a1.jpg" width="100%">
                        </div>

                    </li>

                </ul>

            </div>
        </div>

    </div>

</div>
<canvas id='world' width='500' height='500'></canvas>
<header><h1 style="text-align: center"><a href="login.html">去登陆</a></h1></header>


</body>
</html>
<script>
    /*var TWO_PI = Math.PI * 2;
    var HALF_PI = Math.PI * 0.5;
    var THICKNESS = 12;
    var LENGTH = 10;
    var STEP = 0.1;
    var FPS = 1000 / 60;*/
    window.onload = function() {
        var querystr=location.search.substring(1,location.search.length);
        if(querystr=="logout=1"){
            alert("注销成功");
        }
    }
    var aa = new zturn({
        id: "zturn",
        opacity: 0.9,
        width: 200,
        Awidth: 300,
        scale: 0.9,
        auto: true, //是否轮播 默认5000
        turning: 2000 //轮播时长
    })
    /*function Particle(x, y, mass) {

        this.x = x || 0;
        this.y = y || 0;
        this.ox = this.x;
        this.oy = this.y;
        this.mass = mass || 1.0;
        this.massInv = 1.0 / this.mass;
        this.fixed = false;

        this.update = function (dt) {
            if (!this.fixed) {
                var fx = 0.0000;
                var fy = 0.0000;
                var tx = this.x,
                    ty = this.y;

                this.x += (this.x - this.ox) + fx * this.massInv * dt * dt;
                this.y += (this.y - this.oy) + fy * this.massInv * dt * dt;
                this.ox = tx;
                this.oy = ty;
            }
        };
    };

    function Spring(p1, p2, restLength, strength) {

        this.p1 = p1;
        this.p2 = p2;
        this.restLength = restLength || 10;
        this.strength = strength || 1.0;

        this.update = function (dt) {

            // Compute desired force
            var dx = p2.x - p1.x,
                dy = p2.y - p1.y,
                dd = Math.sqrt(dx * dx + dy * dy) + 0.0001,
                tf = (dd - this.restLength) / (dd * (p1.massInv + p2.massInv)) * this.strength,
                f;

            // Apply forces
            if (!p1.fixed) {
                f = tf * p1.massInv;
                p1.x += dx * f;
                p1.y += dy * f;
            }

            if (!p2.fixed) {
                f = -tf * p2.massInv;
                p2.x += dx * f;
                p2.y += dy * f;
            }
        }
    };

    function Sim() {

        this.particles = [];
        this.springs = [];

        this.tick = function (dt) {

            var i, n;

            for (i = 0, n = this.springs.length; i < n; ++i) {
                this.springs[i].update(dt);
            }

            for (i = 0, n = this.particles.length; i < n; ++i) {
                this.particles[i].update(dt);
            }
        }
    };

    // Create a new system
    var sim = new Sim(),
        old = new Date().getTime(),
        canvas = document.getElementById('world'),
        context = canvas.getContext('2d');

    function init() {

        var np,
            op,
            mouse,
            anchor,
            step = STEP,
            length = LENGTH,
            count = length / step;

        var sx = canvas.width * 0.5;
        var sy = canvas.height * 0.5;

        for (var i = 0; i < count; ++i) {

            //np = new Particle(i*8,i*8,0.1+Math.random()*0.01);
            np = new Particle(sx + (Math.random() - 0.5) * 200, sy + (Math.random() - 0.5) * 200, 0.1 + Math.random() * 0.01);
            sim.particles.push(np);

            if (i > 0) {
                s = new Spring(np, op, step, 0.95);
                sim.springs.push(s);
            }

            op = np;
        }

        // Fix the first particle
        anchor = sim.particles[0];
        //anchor.fixed = true;
        anchor.x = 50;
        anchor.y = 50;

        // Move last particle with mouse
        mouse = sim.particles[count - 1];
        mouse.fixed = true;

        canvas.addEventListener('mousemove', function (event) {
            mouse.x = event.clientX;
            mouse.y = event.clientY;
        });
    };

    function step() {

        var now = new Date().getTime(),
            delta = now - old;

        sim.tick(delta);

        // Clear canvas
        canvas.width = canvas.width;

        var points = []; // Midpoints
        var angles = []; // Delta angles

        var i, n, p1, p2, dx, dy, mx, my, sin, cos, theta;

        // Compute midpoints and angles
        for (i = 0, n = sim.particles.length - 1; i < n; ++i) {

            p1 = sim.particles[i];
            p2 = sim.particles[i + 1];

            dx = p2.x - p1.x;
            dy = p2.y - p1.y;

            mx = p1.x + dx * 0.5;
            my = p1.y + dy * 0.5;

            points[i] = {
                x: mx,
                y: my
            };
            angles[i] = Math.atan2(dy, dx);
        }

        // Render
        context.beginPath();

        for (i = 0, n = points.length; i < n; ++i) {

            p1 = sim.particles[i];
            p2 = points[i];

            theta = angles[i];

            r = Math.sin((i / n) * Math.PI) * THICKNESS;
            sin = Math.sin(theta - HALF_PI) * r;
            cos = Math.cos(theta - HALF_PI) * r;

            context.quadraticCurveTo(
                p1.x + cos,
                p1.y + sin,
                p2.x + cos,
                p2.y + sin);
        }

        for (i = points.length - 1; i >= 0; --i) {

            p1 = sim.particles[i + 1];
            p2 = points[i];

            theta = angles[i];

            r = Math.sin((i / n) * Math.PI) * THICKNESS;
            sin = Math.sin(theta + HALF_PI) * r;
            cos = Math.cos(theta + HALF_PI) * r;

            context.quadraticCurveTo(
                p1.x + cos,
                p1.y + sin,
                p2.x + cos,
                p2.y + sin);

        }

        context.strokeStyle = 'rgba(255,255,255,0.1)';
        context.lineWidth = 8;
        context.stroke();

        context.strokeStyle = 'rgba(0,0,0,0.8)';
        context.lineWidth = 0.5;
        context.stroke();

        context.fillStyle = 'rgba(255,255,255,0.9)';
        context.fill();

        old = now;

        setTimeout(step, FPS);
    };

    function resize() {
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
    }

    window.addEventListener("resize", resize);
    resize();

    init();
    step();*/

</script>
<%--
   ┏┓　　　┏┓
 ┏┛┻━━━┛┻┓
 ┃　　　　　　　┃
 ┃　　　━　　　┃
 ┃　┳┛　┗┳　┃
 ┃　　　　　　　┃
 ┃　　　┻　　　┃
 ┃　　　　　　　┃
 ┗━┓　　　┏━┛
     ┃　　　┃
     ┃　　　┃
     ┃　　　┗━━━┓
     ┃　　　　　　　┣┓
     ┃　　　　　　　┏┛
     ┗┓┓┏━┳┓┏┛
       ┃┫┫　┃┫┫
       ┗┻┛　┗┻┛
        神兽保佑
        代码无BUG!
--%>

