var type;       //类型
var departure;  //出发地
var target;     //目的地
var goods;      //货物
var remark;     //备注
var weight;     //重量
var deliveryTime;//发货时间
var detail_1;   //出发地的详细地址
var detail_2;   //目的地的详细地址
var ownerId;    //货主ID
var status=1;     //订单的状态

//货物名称是否填写
function checkGoods() {
    // if(null!=goods && goods.toString().length > 0){
    if(null!=goods){
        return true;
    }
    alert("请填写货物名称");
    return false;
}

//出发地是否为填写
function checkDeparture() {
    if(null!=departure ){
        return true;
    }
    alert("请填写出发地");
    return false;
}
//目的地是否填写
function checkTarget() {
    if(null!=target ){
        return true;
    }
    alert("请填写目的地");
    return false;
}
//类型是否填写
function checkType() {
    if(null!=type && -1 ){
        return true;
    }
    alert("请填写货物类型");
    return false;
}

//重量是否填写
function checkWeight() {
    if(weight > 0 ){
        return true;
    }
    alert("填写货物重量");
    return false;
}

function checkDeliveryTime() {
    if(null!=deliverytime && deliverytime.toString().length > 0 ){
        return true;
    }
    alert("请输入发货时间");
    return false;
}

<!-- 提交搜索条件 -->
function submit() {
    //获取用户输入的货物信息
    ownerId=getCookie("userId");                    //获取货主ID
    type = $.trim($('#goodstype').val());            //货物类型
    goods = $.trim($('#name').val());                //货物名称
    departure = $.trim($('#startplace').val());      //出发地
    target = $.trim($('#destination').val());        //目的地
    deliveryTime = $.trim($('#deliveryTime').val());  //发货时间
    weight = $.trim($('#weight').val());            //货物重量
    remark = "";
    detail_1=$.trim($('#detail_1').val());
    detail_2=$.trim($('#detail_2').val());
    deliveryTime= Date.parse(deliveryTime);
    departure=departure+"|"+detail_1;
    target=target+"|"+detail_2;

    // if (checkDeparture() && checkTarget() && checkType() && checkGoods() && checkWeight() && checkDeliveryTime()) {
    if (checkDeparture() && checkTarget() && checkType() && checkGoods()){
        release();
    }
    return false;
}
function release(){
    if(release_orderInfo() && release_order()){
        alert("提示：您已成功申请一个订单!");
        window.location.href = "home.html";
    }
}
function release_order(){
    $.ajax({
        type: 'POST',
        url: '/order/insertOrder',
        data: 'ownerId='+ownerId +'&status='+status,
        async: false,
        success: function(data){
            console.log(data);
            if(data.toString()=="true") {//插入成功
                alert("success_order");
               return true;
            }
        }
    });
}

function release_orderInfo(){
    $.ajax({
        type: 'POST',
        url: '/OrderInfo/insertOrderInfo',
        data: 'type=' +type +'&goods='+goods +'&departure='+departure +'&target='+target +'&deliveryTime='+deliveryTime+'&weight='+weight+'&remark='+remark,
        async: false,
        success: function(data){
            console.log(data);
            if(data.toString()=="true") {//插入成功
                alert("success_orderInfo");
                return true;
            }
        },
        error:function(data){
            alert("fail_orderInfo");
        }
    });
}
$(function () {
    //发布订单
    $('#release').bind("click", function () {
        //防止重复提交
        //submitBtnAvailability('disable');
//    	setTimeout(function(){
        alert("10");
        submit();
//        }, 300);
    });
});


