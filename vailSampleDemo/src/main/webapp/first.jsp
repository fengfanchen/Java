<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>随机验证码</title>

    <style type="text/css">
        .code_a{
            color: #0000ff;
            font-size: 12px;
            text-decoration: none;
            cursor: pointer;
        }
        #imgCode{
            cursor: pointer;
        }
    </style>

    <script type="text/javascript">
        function changeCode() {

            var imgCode = document.getElementById("imgCode");
            imgCode.src = "first?" + Math.random();
        }
        changeCode();
    </script>

</head>
<body>
    <form action="login" method="post">
        <label>验证码：</label>
        <input type="text" id="inCode" name="inCode">
        <img src="first" align="center" id="imgCode" />
        <a class="code_a" onclick="changeCode()">换一张</a><br/>
        <input type="submit" value="登录" />
    </form>
    <div style="color:red">${err}</div>
</body>
</html>
