<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.service.OrderService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.utils.CookieUtils" %>
<%@ page import="com.model.Order" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.service.ApplyService" %>
<%@ page import="com.service.LogisticsService" %>
<%@ page import="com.model.Logistics" %>
<%@ page import="com.service.InfoService" %><%--
  Created by IntelliJ IDEA.
  User: silen
  Date: 18-1-11
  Time: 下午1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>物流运输平台——我的订单</title>
    <link href="mmk_media/css/myorders_layout.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/timeline.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <script>
        function hideElement(part) {
            part.parentNode.style.display = 'none';
        }

        function hintInfo_del() {
            confirm("提示：您已成功删除一个订单!");
        }

        function hintInfo_agree() {
            confirm("提示：您的订单已同意司机申请!");
        }
    </script>
</head>

<body>
<%
    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletConfig().getServletContext());
    OrderService orderService = (OrderService) context.getBean("orderService");
    int ownerId = Integer.parseInt(CookieUtils.getCookieValueByName(request, "userId"));

    ApplyService applyService = (ApplyService) context.getBean("applyService");

    LogisticsService logisticsService = (LogisticsService) context.getBean("logisticsService");
    InfoService infoService = (InfoService) context.getBean("infoService");
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
            <a class="menu" href="home.jsp">主页</a>
            <a class="menu active" href="javascript:redictMyOrder()">我的订单</a>
            <a class="menu" href="javascript:redictReleaseOrder()">发布订单</a>
            <a class="menu" href="#aboutus">关于我们</a>
            <a class="exit" href="javascript:exitLogin()">退出账号</a>
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

        <div class="submenu">
            <ul>
                <li><a href="#noapplication">待申请订单</a></li>
                <li><a href="#noconfirmation">待确认订单</a></li>
                <li><a href="#intransit">运输中订单</a></li>
                <li><a href="#historyords">历史订单</a></li>
            </ul>
        </div>

        <div class="container2" style="width:1000px;">

            <div>

                <img class="zbfl" src="mmk_media/image/zbfl.png" alt=""/>
                <img class="zbfr" src="mmk_media/image/zbfr.png" alt=""/>

                <div id="noapplication" id="unApply_layout" style="width:80%">
                    <hr class="hr_style3"/>
                    <label class="resultstitle">待申请订单</label>

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
                    <%--start--%>
                    <%
                        List<Map<String, Object>> unApplyOrders = orderService.getOrderInfoByOwnerId(ownerId, Order.STATUS_NO_APPLY);
                        for (Map<String, Object> valueMap : unApplyOrders) {
                    %>
                    <div align="center">
                        <table type="button" class="result accordion">
                            <tr>
                                <td class="title1"><%=valueMap.get("type")%>
                                </td>
                                <td class="title2"><%=valueMap.get("goods")%>
                                </td>
                                <td class="title3"><%=valueMap.get("weight")%>
                                </td>
                                <td class="title4"><%=((String) valueMap.get("departure")).split("\\|")[0]%>
                                </td>
                                <td class="title5"><%=((String) valueMap.get("target")).split("\\|")[0]%>
                                </td>
                                <td class="title6"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date((long) valueMap.get("createTime")))%>
                                </td>
                            </tr>
                        </table>
                        <div class="panel">
                            <table class="details">
                                <tr>
                                    <td>发货详细地址</td>
                                    <td><%=((String) valueMap.get("departure")).split("\\|")[1]%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>收货详细地址</td>
                                    <td><%=((String) valueMap.get("target")).split("\\|")[1]%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>备注</td>
                                    <td><%=valueMap.get("remark")%>
                                    </td>
                                </tr>
                            </table>
                            <button class="apply" type="submit" onclick="javascript:delOrder(<%=valueMap.get("id")%>)">
                                删除订单
                            </button>
                        </div>

                        <%
                            }
                        %>
                        <%--end--%>
                        <%--
                        <table type="button" class="result accordion">
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
                                    <td>备注</td>
                                    <td>***</td>
                                </tr>
                            </table>
                            <button class="apply" type="submit" onclick="hintInfo_del()">删除订单</button>
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
                </div>

                <div id="noconfirmation" style="width:80%">
                    <hr class="hr_style3"/>
                    <label class="resultstitle">待确认订单</label><br/>

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

                    <%
                        List<Map<String, Object>> waitCheckOrders = orderService.getOrderInfoByOwnerId(ownerId, Order.STATUS_WAIT_CHECK);

                    %>

                    <div align="center">
                        <%--start--%>
                        <%
                            for (Map<String, Object> unCheckMap : waitCheckOrders) {
                        %>
                        <table type="button" class="result accordion">
                            <tr>
                                <td class="title1"><%=unCheckMap.get("type")%>
                                </td>
                                <td class="title2"><%=unCheckMap.get("goods")%>
                                </td>
                                <td class="title3"><%=unCheckMap.get("weight")%>
                                </td>
                                <td class="title4"><%=((String) unCheckMap.get("departure")).split("\\|")[0]%>
                                </td>
                                <td class="title5"><%=((String) unCheckMap.get("target")).split("\\|")[0]%>
                                </td>
                                <td class="title6"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date((long) unCheckMap.get("createTime")))%>
                                </td>
                            </tr>
                        </table>
                        <div class="panel">
                            <table class="details">
                                <%
                                    List<Map<String, Object>> applyList = applyService.getApplyCarInfoList((int) unCheckMap.get("id"));
                                    for (Map<String, Object> applyMap : applyList) {
                                %>
                                <tr>
                                    <td class="title1"><input type="radio" value="<%=applyMap.get("carId")%>"
                                                              name="drivers<%=unCheckMap.get("id")%>"/></td>
                                    <td><%=applyMap.get("name")%>
                                    </td>
                                    <td>运送货物*次</td>
                                    <td><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date((long) applyMap.get("createTime")))%>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                <%--  <tr>
                                      <td class="title1"><input type="radio" name="drivers1"/></td>
                                      <td>**司机</td>
                                      <td>运送货物*次</td>
                                  </tr>
                                  <tr>
                                      <td class="title1"><input type="radio" name="drivers1"/></td>
                                      <td>**司机</td>
                                      <td>运送货物*次</td>
                                  </tr>--%>
                            </table>
                            <button class="apply" type="submit" onclick="javascript:postApply(<%=unCheckMap.get("id")%>)">
                                同意申请
                            </button>
                        </div>

                        <%
                            }
                        %>
                        <%--end--%>
                        <%--
                        <table type="button" class="result accordion">
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
                                    <td class="title1"><input type="radio" id="carSelectRadio" name="drivers2"/></td>
                                    <td>**司机</td>
                                    <td>运送货物*次</td>
                                </tr>
                                <tr>
                                    <td class="title1"><input type="radio" name="drivers2"/></td>
                                    <td>**司机</td>
                                    <td>运送货物*次</td>
                                </tr>
                                <tr>
                                    <td class="title1"><input type="radio" name="drivers2"/></td>
                                    <td>**司机</td>
                                    <td>运送货物*次</td>
                                </tr>
                            </table>
                            <button class="apply" type="submit" onclick="hintInfo_agree()">同意申请</button>
                        </div>
--%>
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
                </div>

                <div id="intransit" style="width:80%">
                    <hr class="hr_style3"/>
                    <label class="resultstitle">运输中订单</label><br/>
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

                        <%--start--%>

                        <%
                            List<Map<String, Object>> transitOrders = orderService.getOrderInfoByOwnerId(ownerId, Order.STATUS_IN_TRANSIT);
                            for (Map<String, Object> transitOrderMap : transitOrders) {
                        %>
                        <table type="button" class="result accordion">
                            <tr>
                                <td class="title1"><%=transitOrderMap.get("type")%>
                                </td>
                                <td class="title2"><%=transitOrderMap.get("goods")%>
                                </td>
                                <td class="title3"><%=transitOrderMap.get("weight")%>
                                </td>
                                <td class="title4"><%=((String) transitOrderMap.get("departure")).split("\\|")[0]%>
                                </td>
                                <td class="title5"><%=((String) transitOrderMap.get("target")).split("\\|")[0]%>
                                </td>
                                <td class="title6"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date((long) transitOrderMap.get("createTime")))%>
                                </td>
                            </tr>
                        </table>
                        <div class="panel">
                            <table class="details">
                                <tr>
                                    <td>发货详细地址</td>
                                    <td><%=((String) transitOrderMap.get("departure")).split("\\|")[1]%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>收货详细地址</td>
                                    <td><%=((String) transitOrderMap.get("target")).split("\\|")[1]%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>备注</td>
                                    <td><%=transitOrderMap.get("remark")%>
                                    </td>
                                </tr>
                                <tr>

                                </tr>
                            </table>
                            <ul class="timeline" style="margin-top:10px;width:80%">

                                <%--start--%>

                                <%
                                    List<Logistics> logisticsList = logisticsService.getLogistics((int) transitOrderMap.get("id"));
                                    for (Logistics logistics : logisticsList) {
                                %>

                                <li class="timeline-green">

                                    <div class="timeline-time">

                                        <span class="date"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date(logistics.getCreateTime()))%></span>

                                        <span class="time"
                                              style="margin-top:-10px"><%=new SimpleDateFormat("HH-mm").format(new Date(logistics.getCreateTime()))%></span>

                                    </div>

                                    <div class="timeline-icon"><i class="icon-time"></i></div>

                                    <div class="timeline-body">

                                        <div class="timeline-content">
                                            <p align="left"><%=logistics.getInfo()%>
                                            </p>
                                        </div>
                                    </div>

                                </li>
                                <%
                                    }
                                %>
                                <%--end--%>
                                <%--                                <li class="timeline-green">

                                                                    <div class="timeline-time">

                                                                        <span class="date">4/17/13</span>

                                                                        <span class="time" style="margin-top:-10px">12:11</span>

                                                                    </div>

                                                                    <div class="timeline-icon"><i class="icon-time"></i></div>

                                                                    <div class="timeline-body">

                                                                        <div class="timeline-content">
                                                                            <p align="left">从XXX地发往XXX地</p>
                                                                        </div>

                                                                    </div>

                                                                </li>--%>

                            </ul>
                            <button class="apply" type="submit" onclick="javascript:finishOrder(<%=transitOrderMap.get("id")%>)">
                                确认送达
                            </button>
                        </div>
                        <%
                            }
                        %>
                        <%--end--%>
                    </div>

                    <div id="historyords">
                        <hr class="hr_style3"/>
                        <label class="resultstitle">历史订单</label><br/>
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

                            <%--start--%>
                            <%
                                List<Map<String, Object>> finishOrderList = orderService.getOrderInfoByOwnerId(ownerId, Order.STATUS_FINALLY);
                                for (Map<String, Object> finishMap : finishOrderList) {

                                    Map<String, Object> carInfo = orderService.getCarInfoForOrder((int)finishMap.get("id"));
                            %>
                            <table type="button" class="result accordion">
                                <tr>
                                    <td class="title1"><%=finishMap.get("type")%>
                                    </td>
                                    <td class="title2"><%=finishMap.get("goods")%>
                                    </td>
                                    <td class="title3"><%=finishMap.get("weight")%>
                                    </td>
                                    <td class="title4"><%=((String) finishMap.get("departure")).split("\\|")[0]%>
                                    </td>
                                    <td class="title5"><%=((String) finishMap.get("target")).split("\\|")[0]%>
                                    </td>
                                    <td class="title6"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date((long) finishMap.get("createTime")))%>
                                    </td>
                                </tr>
                            </table>
                            <div class="panel">
                                <table class="details">
                                    <tr>
                                        <td>发货详细地址</td>
                                        <td><%=((String) finishMap.get("departure")).split("\\|")[1]%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>收货详细地址</td>
                                        <td><%=((String) finishMap.get("target")).split("\\|")[1]%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>司机名称</td>
                                        <td><%=carInfo.get("name")%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>司机联系方式</td>
                                        <td><%=carInfo.get("phone")%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>备注</td>
                                        <td><%=finishMap.get("remark")%>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <%
                                }
                            %>
                            <%--end--%>
                            <%--
                            <table type="button" class="result accordion">
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
                                        <td>司机名称</td>
                                        <td>***</td>
                                    </tr>
                                    <tr>
                                        <td>司机联系方式</td>
                                        <td>***</td>
                                    </tr>
                                    <tr>
                                        <td>备注</td>
                                        <td>***</td>
                                    </tr>
                                </table>
                            </div>
--%>
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
                    </div>

                </div>

                <br/>

                <div>

                    <div align="center">
                    </div>    <!--结果表结束-->

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

    <!-- END PAGE LEVEL PLUGINS -->

    <!-- BEGIN PAGE LEVEL SCRIPTS -->

    <script src="javascript/CookieUtils.js" type="text/javascript"></script>
    <script src="javascript/common_utils.js" type="text/javascript"></script>
    <script src="javascript/deleteOrder.js" type="text/javascript"></script>
    <script src="javascript/myorder.js" type="text/javascript"></script>
</body>
</html>

