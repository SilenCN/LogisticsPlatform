<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="com.service.OrderInfoService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.utils.CookieUtils" %>
<%@ page import="com.model.OrderInfo" %><%--
  Created by IntelliJ IDEA.
  User: silen
  Date: 18-1-11
  Time: 下午4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>物流运输平台首页</title>
    <link href="mmk_media/css/home_layout.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<%
    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletConfig().getServletContext());
    OrderInfoService orderInfoService = (OrderInfoService) context.getBean("orderInfoService");

    String typeString = request.getParameter("goodstype");

    String departure = request.getParameter("startplace");
    if (null == departure || departure.equals("")) {
        departure = OrderInfo.DEPARTURE_ALL;
    }
    String target = request.getParameter("destination");
    if (null == target || target.equals("")) {
        target = OrderInfo.TARGET_ALL;
    }

    String pageString = request.getParameter("page");
    int pageInt = 1;
    if (pageString == null) {
        pageInt = 1;
    } else {
        pageInt = Integer.parseInt(pageString);
    }
    int type = 0;
    if (typeString == null) {
        type = 0;
    } else {
        type = Integer.parseInt(typeString.trim());
    }

    boolean isDriver = null != CookieUtils.getCookieValueByName(request, "userType") && CookieUtils.getCookieValueByName(request, "userType").equals("1");


%>
<div class="baseplate" align="center">

    <div class="header">
        <img class="logo" src="mmk_media/image/logo_big_touming.png" alt="logo"/>
        <img class="slash" src="mmk_media/image/slash.png" alt=""/>
        <img class="webtitle" src="mmk_media/image/title2.png" alt="">
    </div>

    <div class="article">

        <hr class="hr_style1"/>

        <div class="topnav">
            <a class="menu active" href="home.jsp">主页</a>
            <a class="menu" href="javascript:redictMyOrder()">我的订单</a>
            <a class="menu" href="javascript:redictReleaseOrder()">发布订单</a>
            <a class="menu" href="#aboutus">关于我们</a>
            <a class="exit" href="javascript:exitLogin();">退出账号</a>
            <a href="javascript:redictPersonInfo()">
                <img class="personalcenter" src="mmk_media/image/personalcenter.png" alt="个人中心"/>
            </a>
            <a href="messages.html">
                <img class="message" src="mmk_media/image/message.png" alt="信息"/>
            </a>
        </div>

        <div class="container1">
            <div class="photos">
                <img class="poster" src="mmk_media/image/poster3.jpg" alt=""/>
            </div>
        </div>

        <div class="container2" style="width:1000px;">

            <form action="home.jsp" method="post">
                <img class="zbfl" src="mmk_media/image/zbfl.png" alt=""/>
                <img class="zbfr" src="mmk_media/image/zbfr.png" alt=""/>

                <br/> <br/> <br/>
                <div style="width:80%">
                    <hr class="hr_style3"/>
                    <label class="resultstitle">货运需求信息</label><br/>
                </div>

                <label>起始地：</label>
                <div class="styled-select" style="width:120px;">
                    <select id="startplace" name="startplace">
                        <option value="安徽省">安徽省</option>
                        <option value="北京市">北京市</option>
                        <option value="重庆市">重庆市</option>
                        <option value="福建省">福建省</option>
                        <option value="甘肃省">甘肃省</option>
                        <option value="广东省">广东省</option>
                        <option value="广东省">广西省</option>
                        <option value="贵州省">贵州省</option>
                        <option value="海南省">海南省</option>
                        <option value="河北省">河北省</option>
                        <option value="河南省">河南省</option>
                        <option value="黑龙江省">黑龙江省</option>
                        <option value="湖北省">湖北省</option>
                        <option value="湖南省">湖南省</option>
                        <option value="吉林省">吉林省</option>
                        <option value="江苏省">江苏省</option>
                        <option value="江西省">江西省</option>
                        <option value="辽宁省">辽宁省</option>
                        <option value="内蒙古省">内蒙古省</option>
                        <option value="青海省">青海省</option>
                        <option value="山东省">山东省</option>
                        <option value="山西省">山西省</option>
                        <option value="陕西省">陕西省</option>
                        <option value="上海省">上海市</option>
                        <option value="四川省">四川省</option>
                        <option value="天津市">天津市</option>
                        <option value="西藏省">西藏省</option>
                        <option value="新疆省">新疆省</option>
                        <option value="云南省">云南省</option>
                        <option value="浙江省">浙江省</option>
                        <option selected value="ALL">全部</option>
                    </select>
                </div>
                <label>目的地：</label>
                <div class="styled-select" style="width:120px;">
                    <select id="destination" name="destination">
                        <option value="安徽省">安徽省</option>
                        <option value="北京市">北京市</option>
                        <option value="重庆市">重庆市</option>
                        <option value="福建省">福建省</option>
                        <option value="甘肃省">甘肃省</option>
                        <option value="广东省">广东省</option>
                        <option value="广东省">广西省</option>
                        <option value="贵州省">贵州省</option>
                        <option value="海南省">海南省</option>
                        <option value="河北省">河北省</option>
                        <option value="河南省">河南省</option>
                        <option value="黑龙江省">黑龙江省</option>
                        <option value="湖北省">湖北省</option>
                        <option value="湖南省">湖南省</option>
                        <option value="吉林省">吉林省</option>
                        <option value="江苏省">江苏省</option>
                        <option value="江西省">江西省</option>
                        <option value="辽宁省">辽宁省</option>
                        <option value="内蒙古省">内蒙古省</option>
                        <option value="青海省">青海省</option>
                        <option value="山东省">山东省</option>
                        <option value="山西省">山西省</option>
                        <option value="陕西省">陕西省</option>
                        <option value="上海省">上海市</option>
                        <option value="四川省">四川省</option>
                        <option value="天津市">天津市</option>
                        <option value="西藏省">西藏省</option>
                        <option value="新疆省">新疆省</option>
                        <option value="云南省">云南省</option>
                        <option value="浙江省">浙江省</option>
                        <option selected value="ALL">全部</option>
                    </select>
                </div>
                <label>货物类型：</label>
                <div class="styled-select" style="width:120px;">
                    <select id="goodstype" name="goodstype">
                        <option value="1">机械设备</option>
                        <option value="2">家具</option>
                        <option value="3">食品</option>
                        <option value="4">生鲜</option>
                        <option value="5">家禽</option>
                        <option value="6">电子产品</option>
                        <option value="7">衣服饰品</option>
                        <option value="8">其他</option>
                        <option selected value="0">全部</option>
                    </select>
                </div>
                <button id="serch" type="submit">搜索</button>
            </form>
            <br/>
            <div>

                <div>    <!--表头-->
                    <table class="tableheader">
                        <tr>
                            <td class="title1">货物类型</td>
                            <td class="title2">货物名称</td>
                            <td class="title3">重量</td>
                            <td class="title4">出发地</td>
                            <td class="title5">目的地</td>
                            <td class="title6">发货时间</td>
                        </tr>
                    </table>
                </div>

                <div align="center">

                    <%
                        List<Map<String, Object>> orderList = orderInfoService.searchOrderInfo(type, departure, target, pageInt);
                        for (Map<String, Object> orderInfo : orderList) {
                    %>
                    <table class="result accordion">
                        <tr>
                            <td class="title1"><%=orderInfo.get("type")%>
                            </td>
                            <td class="title2"><%=orderInfo.get("goods")%>
                            </td>
                            <td class="title3"><%=orderInfo.get("weight")%>
                            </td>
                            <td class="title4"><%=((String) orderInfo.get("departure")).split("\\|")[0]%>
                            </td>
                            <td class="title5"><%=((String) orderInfo.get("target")).split("\\|")[0]%>
                            </td>
                            <td class="title6"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date((long) orderInfo.get("createTime")))%>
                            </td>
                        </tr>
                    </table>
                    <div class="panel">
                        <table class="details">
                            <tr>
                                <td>发货详细地址</td>
                                <td><%=((String) orderInfo.get("departure")).split("\\|")[1]%>
                                </td>
                            </tr>
                            <tr>
                                <td>收货详细地址</td>
                                <td><%=((String) orderInfo.get("target")).split("\\|")[1]%>
                                </td>
                            </tr>
                            <tr>
                                <td>货主联系方式</td>
                                <td>***</td>
                            </tr>
                            <tr>
                                <td>备注</td>
                                <td><%=orderInfo.get("remark")%>
                                </td>
                            </tr>
                        </table>
                        <%
                            if (isDriver) {
                        %>
                        <button class="apply" type="submit" onclick="javascript:apply(<%=orderInfo.get("id")%>)">申请订单</button>
                        <%
                            }
                        %>
                    </div>
                    <%
                        }
                    %>

                    <%--   <table class="result accordion">
                           <tr>
                               <td class="title1">宇神</td>
                               <td class="title2">极品牌宇神</td>
                               <td class="title3">1000</td>
                               <td class="title4">河北省</td>
                               <td class="title5">安徽省</td>
                               <td class="title6">2018-1-15</td>
                           </tr>
                       </table>
                       <div class="panel">
                           <table class="details">
                               <tr>
                                   <td>发货详细地址</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>收货详细地址</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>货主联系方式</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>备注</td>
                                   <td>***</td>
                               </tr>
                           </table>
                           <button class="apply" type="submit" onclick="hintInfo()">申请订单</button>
                       </div>

                       <table class="result accordion">
                           <tr>
                               <td class="title1">宇神</td>
                               <td class="title2">极品牌宇神</td>
                               <td class="title3">1000</td>
                               <td class="title4">河北省</td>
                               <td class="title5">安徽省</td>
                               <td class="title6">2018-1-15</td>
                           </tr>
                       </table>
                       <div class="panel">
                           <table class="details">
                               <tr>
                                   <td>发货详细地址</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>收货详细地址</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>货主联系方式</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>备注</td>
                                   <td>***</td>
                               </tr>
                           </table>
                           <button class="apply" type="submit" onclick="hintInfo()">申请订单</button>
                       </div>

                       <table class="result accordion">
                           <tr>
                               <td class="title1">宇神</td>
                               <td class="title2">极品牌宇神</td>
                               <td class="title3">1000</td>
                               <td class="title4">河北省</td>
                               <td class="title5">安徽省</td>
                               <td class="title6">2018-1-15</td>
                           </tr>
                       </table>
                       <div class="panel">
                           <table class="details">
                               <tr>
                                   <td>发货详细地址</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>收货详细地址</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>货主联系方式</td>
                                   <td>***</td>
                               </tr>
                               <tr>
                                   <td>备注</td>
                                   <td>***</td>
                               </tr>
                           </table>
                           <button class="apply" type="submit" onclick="hintInfo()">申请订单</button>
                       </div>--%>

                    <script>
                        var acc = document.getElementsByClassName("accordion");
                        var i;

                        for (i = 0; i < acc.length; i++) {
                            acc[i].onclick = function () {
                                this.classList.toggle("active");
                                var panel = this.nextElementSibling;
                                if (panel.style.maxHeight) {
                                    panel.style.maxHeight = null;
                                } else {
                                    panel.style.maxHeight = panel.scrollHeight + "px";
                                }
                            }
                        }
                    </script>

                </div>    <!--结果表结束-->

                <ul class="pagination">

                    <%
                        if (pageInt != 1) {
                    %>
                    <li><a href="home.jsp?goodstype=<%=type%>&startplace=<%=departure%>&target=<%=target%>&page=<%=(pageInt-1)%>">«上一页</a></li>
                    <%
                        }
                    %>
                    <%--                   <li><a class="active" href="">1</a></li>
                                       <li><a href="">2</a></li>
                                       <li><a href="">3</a></li>
                                       <li><a href="">4</a></li>
                                       <li><a href="">5</a></li>
                                       <li><a href="">6</a></li>
                                       <li><a href="">7</a></li>--%>
                    <li><a href="home.jsp?goodstype=<%=type%>&startplace=<%=departure%>&target=<%=target%>&page=<%=(pageInt+1)%>">下一页»</a></li>
                </ul>

            </div>    <!--表和翻页结束-->

            <br/>

        </div>    <!--表、翻页、搜索结束-->

        <div class="aboutus" id="aboutus">
            <p><strong>关于我们：</strong>@傻敷敷小组<br/>超凶的组长：李新宇</p>
            <p>帅气的后台：韩婷婷<br/>美丽的后台：肖丁剑</p>
            <p>萌萌的前端：杨志坤<br/>超好的前端：覃嘉俊</p>
        </div>

    </div>    <!--article结束-->

    <hr class="hr_style2"/>

    <div class="footer">2018 &copy; 傻敷敷小组</div>

</div>

<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>

<script src="media/js/bootstrap.min.js" type="text/javascript"></script>

<!--[if lt IE 9]>

<script src="media/js/excanvas.min.js"></script>

<script src="media/js/respond.min.js"></script>

<![endif]-->

<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>

<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>

<script src="media/js/jquery.uniform.min.js" type="text/javascript"></script>

<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->

<script src="media/js/jquery.validate.min.js" type="text/javascript"></script>

<script src="javascript/CookieUtils.js" type="text/javascript"></script>
<script src="javascript/common_utils.js" type="text/javascript"></script>

<script src="javascript/apply.js" type="text/javascript"></script>
</body>
</html>

