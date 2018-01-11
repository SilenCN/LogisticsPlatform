

function postApply(id) {
    var radionum=document.getElementsByName("drivers"+id);
    for(var i=0;i<radionum.length;i++){
        if (radionum[i].checked){
            var carId=radionum[i].value;
            commitApply(carId,id);
            return;
        }
    }
}

function commitApply(carId,orderId) {
    $.ajax({
        type: 'POST',
        url: '/apply/updateApplyStatus',
        data: 'carId=' +carId+"&orderId="+orderId,
        async: false,
        success: function (data) {
            if (data=="true"){
                window.location.href = "MyOrder_shipper.jsp";
            }
        }
    });
}
function finishOrder(orderId) {
    $.ajax({
        type: 'POST',
        url: '/order/updateOrderById',
        data: 'id=' +orderId,
        async: false,
        success: function (data) {
            if (data=="true"){
                window.location.href = "MyOrder_shipper.jsp";
            }
        }
    });
}