<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath() + "/ui";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>CanvasLayer</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=k7FWhLNhBxNNLrxRL10m2e1cyik0XZ7H"></script>
<style type="text/css">
body, html,#container {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
</style>
</head>
<body>
    <div id="container"></div>
</body>
</html>
<script type="text/javascript">
    var mp = new BMap.Map("container");
    mp.centerAndZoom(new BMap.Point(116.3964,39.9093), 10);
    mp.enableScrollWheelZoom();

    var canvasLayer = new BMap.CanvasLayer({
        update: update
    });

    function update() {
        var ctx = this.canvas.getContext("2d");

        if (!ctx) {
            return;
        }

        ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);

        var temp = {};
        ctx.fillStyle = "rgba(50, 250, 20, 0.7)";
        ctx.beginPath();
        var data = [
            new BMap.Point(116.297047,39.979542),
            new BMap.Point(116.321768,39.88748),
            new BMap.Point(116.494243,39.956539)
        ];

        for (var i = 0, len = data.length; i < len; i++) {
            var pixel = mp.pointToPixel(data[i]);
            ctx.fillRect(pixel.x, pixel.y, 130, 130);
        }
    }
    mp.addOverlay(canvasLayer);
   // var map = new BMap.Map("container");    
    var point = new BMap.Point(116.404, 39.915);    
    map.centerAndZoom(point, 15);    
    window.setTimeout(function(){  
        map.panTo(new BMap.Point(118.409, 39.918));    
    }, 6000);    
</script>