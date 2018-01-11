function applyUtils(orderId,carId) {
    $.ajax({
        type: 'POST',
        url: '/apply/updateApplyStatus',
        data: 'orderId=' + orderId + '&carId' + carId,
        async: false,
        success: function (data) {
            if (data == "true") {//成功
                window.location.href = "myorders.html";
            }
        }
    });
}