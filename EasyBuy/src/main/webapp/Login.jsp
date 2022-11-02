<!DOCTYPE>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>

    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>

    <script type="text/javascript" src="js/select.js"></script>

    <script type="text/javascript" src="js/lrscroll.js"></script>

    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>

    <script type="text/javascript" src="js/lrscroll_1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js.js" ></script>


    <title>胡永见</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <span class="fr">
        	<span class="fl">你好，请<a href="Login.jsp">登录</a>&nbsp; <a href="Regist.html" style="color:#ff4e00;">免费注册</a>&nbsp; </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<!--End Header End-->
<!--Begin Login Begin-->
<div class="log_bg">
    <div class="top">
        <div class="logo"><a href="Index.jsp"><img src="images/logo.png" /></a></div>
    </div>
    <div class="login">
        <div class="log_img"><img src="images/l_img.png" width="611" height="425" /></div>
        <div class="log_c">

            <h2 style="color: red; size: 14px">${errorMsg}</h2>
            <form id="login_form" action="${pageContext.request.contextPath}/loginServlet" method="post"  >
                <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="55">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">登录</span>
                            <span class="fr">还没有商城账号，<a href="Regist.jsp" style="color:#ff4e00;">立即注册</a></span>
                        </td>
                    </tr>
                    <tr height="70">
                        <td>用户名</td>
                        <td><input type="text" id="l_user" name="account" value="account" class="l_user" onblur="login1()" />
                            <span class="l_user_span"></span>
                        </td>
                    </tr>
                    <tr height="70">
                        <td>密&nbsp; &nbsp; 码</td>
                        <td><input type="password" id="l_pwd" name="password" value="password" class="l_pwd" onblur="login2()" />
                            <span class="l_pwd_span"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox" /></label><label class="r_txt">请保存我这次的登录信息</label>
                    </span>
                            <span class="fr"><a href="#" style="color:#ff4e00;">忘记密码</a></span>
                        </td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="submit" value="登录" class="log_btn" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End-->
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
    </div>
</div>
<!--End Footer End -->

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->

<script type="text/javascript">

    function login1(){
        var l_user = $("#l_user").val();
        if (l_user=="" || l_user == null){
            $(".l_user_span").text("不能为空");
            $(".l_user_span").css("color","red");
        }
    }
    function login2(){
        var l_pwd = $("#l_pwd").val();
        if (l_pwd=="" || l_pwd == null){
            $(".l_pwd_span").text("不能为空");
            $(".l_pwd_span").css("color","red");
        }
    }

    /*function login(){

        var $login_form = $("#login_form");
        var login_data = $login_form.serialize();

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/loginServlet",
            data:login_data,
            async:true,
            success:function ( r ){
                if (parseInt(r) == 0){
                    location.href = "${pageContext.request.contextPath}/pCServlet";
                }else if (parseInt(r) == 1){
                    location.href = "${pageContext.request.contextPath}/Member.jsp";
                }else if (parseInt(r) == -1){
                    alert("密码或账号错误");
                    location.href = "${pageContext.request.contextPath}/Login.jsp";
                }
            }
        });

    }*/

</script>

</html>
