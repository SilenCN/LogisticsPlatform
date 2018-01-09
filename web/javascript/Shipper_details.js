var phone;
var address;
var goods;

function checkPhone() {
    if (null != phone && (phone.toString().trim().length == 11 || phone.toString().trim().length == 8)) {
        return true;
    }
    alert("请输入联系电话");
    return false;
}

function checkAddress() {
    if (null != address && address.toString().trim().length > 10) {
        return true;
    }
    alert("请输入您的详细地址");
    return false;
}


function submit() {
    phone = $.trim($('#shipper_info_pone').val());
    address = $.trim($('#shipper_info_address').val());
    goods = $.trim($('#goods_list').val());
    if (goods == 0) {
        alert("请选择常用货物类型");
        return false;
    }


    if (checkPhone() && checkAddress()) {
        postData();
        return false;
    }
}

function postData() {
    $.ajax({
        type: 'POST',
        url: '/info/fillInOwnerInfo',
        data: 'phone=' + phone + "&address=" + address + "&goods=" + goods,
        async: false,
        success: function (data) {
            console.log(data);
            //  var obj=JSON.parse(data);
            if (data.toString() =="true") {
                window.location.href="page1.html";
            } else {
                alert("完善信息出错");
            }
        }
    });
}

$(function () {
    $('#shipper-detail-submit-bn').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submit();
//        }, 300);

    });
});
