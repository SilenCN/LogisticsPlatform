var logistics;
function checklogistics() {
    if (null!=logistics&&logistics.toString().length>0){
        return true;
    }
    alert("请填写物流信息！");
    return false;
}


function submitLogistics(orderId) {
    logistics = $.trim($('#logistics_info').val());
    if (checklogistics()){
        $.ajax({
            type: 'POST',
            url: '/logistics/insertLogistics',
            data: 'info=' + logistics+'&orderId='+orderId,
            async: false,
            success: function (data) {
                if (data=="true"){
                    document.location.href="MyOrder_driver.jsp";
                }else{
                    alert("更新失败！");
                }
            }
        });
    }

}

$(function () {
    //提交注册
    $('#update_logistics_button').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submit();
//        }, 300);

    });
});