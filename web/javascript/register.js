var name;
var password;
var rePassword;
var checkCode;
var type = 1;


function checkName() {
    if (null == name || name == "") {
        alert("请输入用户名");
        return false;
    }
    return true;
}

function checkPassword() {
    if (null == password || password == "") {
        alert("请输入密码");
        return false;
    }
    return reCheckPassword();
}

function reCheckPassword() {
    if (null == rePassword || rePassword == "") {
        alert("请再次输入密码");
        return false;
    }
    return rePassword == password;
}

function checkCodeStatus() {
    if (null == checkCode || checkCode == "") {
        alert("请输入验证码");
        return false;
    } else if (checkCode.length != 4) {
        alert("验证码错误");
        return false
    }
    return true;
}

function register() {
    $.ajax({
        type: 'POST',
        url: '/user/create',
        data: 'name=' + name + "&password=" + password + "&type=" + type + "&checkCode=" + checkCode,
        async: false,
        success: function (data) {
            console.log(data);
            //  var obj=JSON.parse(data);

            console.log(data.result);
            if (data.result == "true") {
                if (type == 1) {
                    window.location.href = "driver_details.html";
                } else {
                    window.location.href = "shipper_details.html"
                }
            } else {
                alert(data.reason);
            }
        }
    });
    return false;
}

function submitData() {
    name = $.trim($('#txt_username').val());
    password = $.trim($('#register_password').val());
    rePassword = $.trim($('#rePassword').val());
    if (document.getElementById("RadioCarType").checked) {
        type = 1;
    } else {
        type = 2;
    }
    checkCode = $.trim($('#loginCheckCode').val())

    if (checkName() && checkPassword() && checkCodeStatus()) {
        register();
    }

}


$(function () {
    $('#register-submit-btn').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submitData();
//        }, 300);

    });
});

