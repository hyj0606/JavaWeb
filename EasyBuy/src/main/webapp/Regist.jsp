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
        	<span class="fl">你好，请<a href="Login.html">登录</a>&nbsp; <a href="Regist.jsp" style="color:#ff4e00;">免费注册</a>&nbsp; </span>
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
    <div class="regist">
        <div class="log_img"><img src="images/l_img.png" width="611" height="425" /></div>
        <div class="reg_c">

            <form id="regist_form" action="${pageContext.request.contextPath}/registServlet" method="post">
                <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="95">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">注册<p style="color: red;size: 14px">${errorMsg}</p></span>
                            <span class="fr">已有商城账号，<a href="Login.jsp" style="color:#ff4e00;">我要登录</a></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;登录名 </td>
                        <td><input type="text" id="l_user" name="l_user" value="" class="l_user" onblur="check1();" />
                            <span class="regist_span_data"></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right">用户名 &nbsp;</td>
                        <td><input type="text" id="user_name" name="user_name" value="" class="l_mem" onblur="check1()" />
                            <span class="regist_span_data"></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                        <td><input type="password" id="password" name="password" value="" class="l_pwd" onblur="check1()" />
                            <span class="l_pwd_span" ></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                        <td><input type="password" id="l_pwd2" name="pwd" value="" class="l_pwd"  />
                            <span class="l_pwd_span" ></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;性别:&nbsp;</td>
                        <td><input id="man" type="radio" checked="checked" name="sex" value="1"/>男
                            <input type="radio" id="woman" name="sex" value="0">女</td>
                    </tr>
                    <tr height="50">
                        <td align="right"> 身份证号&nbsp;</td>
                        <td><input type="text" id="identity_code" name="identity_code" value="" class="l_num" onblur="check1()" />
                            <span class="regist_span_data"></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                        <td><input type="text" id="email" name="email" value="" class="l_email" onblur="check1()" />
                            <span class="regist_span_data"></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                        <td><input type="text" id="mobile" name="mobile" value="" class="l_tel" onblur="check1()" />
                            <span class="regist_span_data"></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;类型:&nbsp;</td>
                        <td><input  type="radio" checked="checked" name="type" value="1"/>后台
                            <input type="radio" name="type" value="0">前台</td>
                    </tr>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="submit" value="立即注册" class="log_btn" onclick="regist();" /></td>
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



    function check1(){
        var login_name_val = $('#login_name').val();
        var user_name_val = $('#user_name').val();
        var password_val = $('#password').val();
        var identity_codeval = $('#identity_code').val();
        var email_val = $('#email').val();
        var mobile_val = $('#mobile').val();
        if (!login_name_val || !user_name_val || !password_val || !identity_codeval || !email_val || !mobile_val) {
            $(".regist_span_data").text("提示：输入框不能为空！");
            $(".regist_span_data").css("color", "red");
        }

    }

</script>


</html>
