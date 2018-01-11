var password;
var phone;
var goods;
var address_province;
var address_city;
var address_block;
var address;

function checkPassword() {
    if ( null != password && password.length > 0 ) {
        return true;
    }
    alert("请输入修改后的密码");
    return false;
}
function checkPhone() {
    if ( null != phone && phone.length > 0 ) {
        return true;
    }
    alert("请输入修改后的联系方式");
    return false;
}
function checkProvince() {
    if ( null != address_province && address_province.length > 0 ) {
        return true;
    }
    alert("请输入常用发货地址——省");
    return false;
}
function checkCity() {
    if( null != address_city && address_city.length > 0 ) {
        return true;
    }
    alert("请输入常用发货地址——市");
    return false;
}
function checkBlock() {
    if( null != address_block && address_block.length > 0 ) {
        return true;
    }
    alert("请输入常用发货地址——区");
    return false;
}
function checkAddress() {
    if( null != address && address.length > 0 ) {
        return true;
    }
    alert("请输入常用发货地址——详细地址");
    return false;
}

function submit() {
    password = $.trim($('#register_password').val());
    phone = $.trim($('#register_phone').val());
    goods = $.trim($('#goods_list').val());
    address_province = $.trim($('#province').val());
    address_city = $.trim($('#city').val());
    address_block = $.trim($('#block').val());
    address = $.trim($('#address_details').val());
    address = address_province + address_city + address_block + address;

    if ( checkPassword() && checkPhone() && checkProvince() && checkCity() && checkBlock() && checkAddress() ) {
        $.ajax({
            type: 'POST',
            url: '/info/updateInOwner',
            data: 'phone=' + phone+'&password='+password+'&address='+address+'&goods='+goods,
            async: false,
            success: function (data) {
                if (data.result=="true"){
                    window.location.href = "home.jsp";
                }else{
                    alert(data.reason.toString());
                }
            }
        });
    } else {
        return false;
    }
}


$(function () {

    //提交修改信息
    $('#saveInfo').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submit();
//        }, 300);
    });
});