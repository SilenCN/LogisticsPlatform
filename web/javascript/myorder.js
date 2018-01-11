function getOwnerUnApplyOrder() {
    var unApplyLayout = document.getElementById("unApply_layout");
    unApplyLayout.innerHTML = "";
    $.ajax({
        type: 'POST',
        url: '/OrderInfo/getOwnerOrder',
        data: 'status=' + 1,
        async: false,
        success: function (data) {
            unApplyLayout.innerText = unApplyLayout.innerHTML + "" +
                "<hr class=\"hr_style3\" />\n" +
                "            \t<label class=\"resultstitle\">待申请订单</label>\n" +
                "                \n" +
                "                <div>\t<!--表头-->\n" +
                "                    <table class=\"tableheader\">\n" +
                "                        <tr>\n" +
                "                            <td class=\"title1\">货物类型</td>\n" +
                "                            <td class=\"title2\">货物名称</td>\n" +
                "                            <td class=\"title3\">重量</td>\n" +
                "                            <td class=\"title4\">出发地</td>\n" +
                "                            <td class=\"title5\">目的地</td>\n" +
                "                            <td class=\"title6\">发货时间</td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "            \t</div>";
            for (var i in data) {
                unApplyLayout.innerHTML = unApplyLayout.innerHTML +
                    "                <div align=\"center\">\n" +
                    "                    <table  type=\"button\" class=\"result accordion\">\n" +
                    "                        <tr>\n" +
                    "                            <td class=\"title1\">" + data[i].type + "</td>\n" +
                    "                            <td class=\"title2\">" + data[i].goods + "</td>\n" +
                    "                            <td class=\"title3\">" + data[i].weight + "</td>\n" +
                    "                            <td class=\"title4\">" + data[i].departure.toString().split("|")[0] + "</td>\n" +
                    "                            <td class=\"title5\">" + data[i].target.toString().split("|")[0] + "</td>\n" +
                    "                            <td class=\"title6\">" + date("y-m-d", data[i].createTime.toString()) + "</td>\n" +
                    "                        </tr>\n" +
                    "                \t</table>\n" +
                    "                \t<div class=\"panel\">\n" +
                    "                        <table class=\"details\">\n" +
                    "                            <tr>\n" +
                    "                                <td>发货详细地址</td>\n" +
                    "                                <td>" + data[i].departure.toString().split("|")[1] + "</td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <td>收货详细地址</td>\n" +
                    "                                <td>" + "+data[i].target.toString().split(" | ")[1]+" + "</td>\n" +
                    "                            </tr>\n" +
                    "                            <tr>\n" +
                    "                                <td>备注</td>\n" +
                    "                                <td>" + data[i].remark + "</td>\n" +
                    "                            </tr>\n" +
                    "                        </table>\n" +
                    "                        <button class=\"apply\" type=\"submit\" onclick=\"" + "javascript:delOrder(data[i].id);" + "\">删除订单</button>\n" +
                    "                \t</div>";
            }
        }
    });
}

function getOwnerApplyOrder() {
    var applyLayout = document.getElementById("noconfirmation");
    applyLayout.innerHTML = "";
    applyLayout.innerHTML = applyLayout.innerHTML + "" +
        "<hr class=\"hr_style3\"/>\n" +
        "                    <label class=\"resultstitle\">待确认订单</label><br/>\n" +
        "\n" +
        "                    <div>    <!--表头-->\n" +
        "                        <table class=\"tableheader\">\n" +
        "                            <tr>\n" +
        "                                <td class=\"title1\">货物类型</td>\n" +
        "                                <td class=\"title2\">货物名称</td>\n" +
        "                                <td class=\"title3\">重量</td>\n" +
        "                                <td class=\"title4\">出发地</td>\n" +
        "                                <td class=\"title5\">目的地</td>\n" +
        "                                <td class=\"title6\">发货时间</td>\n" +
        "                            </tr>\n" +
        "                        </table>\n" +
        "                    </div>";
    $.ajax({
        type: 'POST',
        url: '/OrderInfo/getOwnerOrder',
        data: 'status=' + 2,
        async: false,
        success: function (data) {
            for (var i in data) {
                applyLayout.innerHTML = applyLayout.innerText + "" +
                    "<div align=\"center\">\n" +
                    "                        <table type=\"button\" class=\"result accordion\">\n" +
                    "                            <tr>\n" +
                    "                                <td class=\"title1\">" + data[i].type + "</td>\n" +
                    "                                <td class=\"title2\">" + data[i].goods + "</td>\n" +
                    "                                <td class=\"title3\">" + data[i].weight + "</td>\n" +
                    "                                <td class=\"title4\">" + data[i].departure.toString().split("|")[0] + "</td>\n" +
                    "                                <td class=\"title5\">" + data[i].target.toString().split("|")[0] + "</td>\n" +
                    "                                <td class=\"title6\">" + date("y-m-d", data[i].createTime.toString()) + "</td>\n" +
                    "                            </tr>\n" +
                    "                        </table>\n";

                $.ajax({
                    type: 'POST',
                    url: '/apply/getApplyCarInfoList',
                    data: 'orderId=' + data[i].orderId.toString(),
                    async: false,
                    success: function (apply) {
                        applyLayout.innerHTML = applyLayout.innerText + "" +
                            "                        <div class=\"panel\">\n" +
                            "                            <table class=\"details\">\n" +
                            "                                <tr>\n" +
                            "                                    <td class=\"title1\"><input type=\"radio\" name=\"drivers1\"/></td>\n" +
                            "                                    <td>**司机</td>\n" +
                            "                                    <td>运送货物*次</td>\n" +
                            "                                </tr>\n" +
                            "                                <tr>\n" +
                            "                                    <td class=\"title1\"><input type=\"radio\" name=\"drivers1\"/></td>\n" +
                            "                                    <td>**司机</td>\n" +
                            "                                    <td>运送货物*次</td>\n" +
                            "                                </tr>\n" +
                            "                                <tr>\n" +
                            "                                    <td class=\"title1\"><input type=\"radio\" name=\"drivers1\"/></td>\n" +
                            "                                    <td>**司机</td>\n" +
                            "                                    <td>运送货物*次</td>\n" +
                            "                                </tr>\n" +
                            "                            </table>\n" +
                            "                            <button class=\"apply\" type=\"submit\" onclick=\"hintInfo_agree()\">同意申请</button>\n" +
                            "                        </div>";
                    }
                });

            }

        }
    });
}