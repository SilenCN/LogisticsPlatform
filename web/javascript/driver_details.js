var phone;
var carType;
var carNumber;
var transportType;

function checkPhone() {
    if (null != phone && (phone.toString().trim().length == 11 || phone.toString().trim().length == 8)) {
        return true;
    }

    alert("请输入联系电话");
    return false;
}

function checkCarNumber() {
    if (null!=carNumber&&carNumber.toString().length>5){
        return true;
    }
    alert("请输入车牌号");
    return false;
}

function checkCarType() {
    if (null!=carType&&carType!=0){
        return true;
    }
    alert("请选择货车类型");
    return false;
}
function checkTransportType() {
    if (null!=transportType&&transportType!=0){
        return true;
    }
    alert("请选择运输类型");
    return false;
}

function submit() {
    phone = $.trim($('#driver_details_phone_id').val());
    carNumber = $.trim($('#driver_details_carnumber_id').val());
    carType = $.trim($('#car_list_id').val());
    transportType = $.trim($('#goods_list_id').val());

    if (checkPhone() && checkCarNumber()&&checkCarType()&&checkTransportType()) {
        postData();
    }

    return false;
}

function postData() {
    $.ajax({
        type: 'POST',
        url: '/info/fillInCarInfo',
        data: 'phone=' + phone + "&carType=" + carType + "&carNumber=" + carNumber+"&transportType="+transportType,
        async: false,
        success: function (data) {
            console.log(data);
            //  var obj=JSON.parse(data);
            if (data.toString() == "true") {
                window.location.href = "home.html";
            } else {
                alert("完善信息出错");
            }
        }
    });
}

$(function () {
    $('#driver-details-submit-button').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submit();
//        }, 300);

    });
});
