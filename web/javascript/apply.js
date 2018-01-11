<!--检查用户是否是司机类型-->
function checkType(){
    if (null!=getCookie("userType")&&getCookie("userType")=="1"){
        return true;
    }
    return false;
}

/*<!--获取司机编号-->
function getCarId(orderId){
    $.ajax({
        type: 'POST',
        url: '/order/getCarId',
        data: orderId,
        async: false,
        success: function(data){
            console.log(data);
            return data;//返回司机编号
        }
    });
}*/

function apply(orderId){
    if(checkType()){
    // if(true){
        alert("apply");
        var carId=getCookie("userId");
        // var carId=1;
        // orderId=1;
        $.ajax({
            type: 'POST',
            url: '/apply/insertApply',//申请订单
            data: 'orderId='+ orderId +'&carId='+ carId,
            async: false,
            success: function(data){
                if(data.toString() == "true"){
                    alert("您已成功申请一个订单，等待货主确认");
                    window.location.href = "MyOrder_driver.jsp";
                }
                else alert("申请订单失败");
            }
        });
    }
    else{
        confirm("您不能申请此订单");
    }
}

/*$(function () {
    //提交注册
    alert("aa");
    $('#apply').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        apply(1);
//        }, 300);
    });
});*/
