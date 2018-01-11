function delOrder(id) {
    $.ajax({
        type: 'POST',
        url: '/OrderInfo/deleteOrderInfo',
        data: 'id='+id,
        async: false,
        success: function(data){
            if(data.toString() == "true") {//删除订单成功
                //删除成功提示框
                confirm("提示：您已成功删除一个订单!");
                window.location.href = "MyOrder_shipper.jsp";
            }
        }
    });
}