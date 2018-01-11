var name;
var password;
var checkCode;

function checkName() {
    if (null!=name&&name.length>0){
        return true;
    }
    alert("请输入用户名");
    return false;
}
function checkPassword() {
    if (null!=password&&password.length>0){
        return true;
    }
    alert("请输入密码");
    return false;
}

function checkCodeStatus() {
    if (null!=checkCode&&checkCode.length==4){
        return true;
    }
    alert("请输入验证码");
    return false;
}
function checkInfoStatus() {
    $.ajax({
        type: 'POST',
        url: '/user/checkImprovedInfo',
        data: 't=' +Math.random(),
        async: false,
        success: function (data) {
            if (data=="true"){
                window.location.href = "home.jsp";
            }else{
                if (getCookie("userType")=="1"){
                    window.location.href="driver_details.html";
                }else {
                    window.location.href="shipper_details.html";
                }
            }
        }
    });
}
function submit() {
    name = $.trim($('#login_input_username').val());
    password = $.trim($('#login_input_password').val());
    checkCode = $.trim($('#login_input_checkcode').val());

    if (checkName() && checkPassword() && checkCodeStatus()) {
        $.ajax({
            type: 'POST',
            url: '/user/login',
            data: 'name=' + name+'&password='+password+'&checkCode='+checkCode,
            async: false,
            success: function (data) {
                if (data.result=="true"){
                    checkInfoStatus();
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
    //提交注册
    $('#login_submit_button').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submit();
//        }, 300);

    });
});
