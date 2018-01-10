var type;
var departure;
var target;
var goods;
var deliveryTime;
var remark;
var weight;

//货物名称是否填写
function checkGoods() {
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
    if(-1!=type ){
        return true;
    }
    alert("请填写货物类型");
    return false;
}

//重量是否填写
function checkWeight() {
    if(0!=weight ){
        return true;
    }
    alert("填写货物重量");
    return false;
}

function checkDeliveryTime() {
    if(0!=deliveryTime){
        return true;
    }
    alert("请输入发货时间");
    return false;
}

<!-- 提交搜索条件 -->
function submit() {

    //获取用户输入的货物信息
    type = $.trim($('#goodstype').val());  //货物类型
    goods = $.trim($('#name').val());  //货物名称
    departure = $.trim($('#startplace').val());  //出发地
    target = $.trim($('#destination').val());   //目的地
    deliveryTime = $.trim($('#deliveryTime').val());  //发货时间
    weight = $.trim($('#weight').val());    //货物重量
    remark = "";

    /* var orderinfo=new Object();
     orderinfo.type=type;
     orderinfo.goods=goods;
     orderinfo.departure=departure;
     orderinfo.target=target;
     orderinfo.deliveryTime=deliveryTime;
     orderinfo.weight=weight;
     orderinfo.remark="";*/

    /*alert(type);
    alert(goods);
    alert(departure);
    alert(target);
    alert(deliveryTime);
    alert(weight);*/
    // alert(orderinfo.departure);

    if (checkDeparture() && checkTarget() && checkType() && checkGoods() && checkWeight() && checkDeliveryTime()) {
        release();
    }
    return false;
}
        // if(checkDeparture() && checkTarget()){
function release(){
    $.ajax({
        type: 'POST',
        url: '/OrderInfo/insertOrderInfo',
        data: 'type=' +type +'&goods='+goods +'&departure='+departure +'&target='+target +'&deliveryTime='+deliveryTime+'&weight='+weight+'&remark='+remark,
        async: false,
        success: function(data){
            console.log(data);
            alert("4");
            if(data.toString()=="true") {//插入成功
                //申请成功提示框，返回
                confirm("提示：您已成功申请一个订单!");
                window.location.href = "home.html";
            }
        }
    });

}


$(function () {
    //发布订单
    $('#release').bind("click", function () {
        //防止重复提交
        //submitBtnAvailability('disable');
//    	setTimeout(function(){
        alert("y");
        submit();
//        }, 300);
    });
});


