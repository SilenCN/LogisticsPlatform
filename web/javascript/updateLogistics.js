function updateLogistics(orderId,info){
    $.ajax({
        type: 'POST',
        url: '/logistics/insertLogistics',
        data: 'orderId=' +orderId +'&info=' +info,
        async: false,
        success: function(data){
            if(data.toString()=="true") {//物流更新成功
                //申请成功提示框，返回
                confirm("提示：您已更新一个订单的物流信息!");
                window.location.href = "myorders_.html";
            }
        }
    });
}