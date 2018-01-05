var phone;
var phoneStatus;
var password;
var rePassword;
var passwordStatus;
var checkCode;
var codeStatus;

function checkPhone() {
    if (phone == "") {
        alert("请输入手机号码！");
        return false;
    } else {
        $.ajax({
            type: 'POST',
            url: '/check/CheckPhone',
            data: 'phone=' + phone,
            async: false,
            success: function (flg) {
                if (flg == "true") {
                    phoneStatus = true;
                } else {
                    phoneStatus = false;
                }
            }
        });
        if (!phoneStatus) {
            alert("手机号码格式不正确！");
        }else{
            $.ajax({
                type: 'POST',
                url: '/CheckPhoneExistServlet',
                data: 'phone=' + phone,
                async: false,
                success: function (flg) {
                    if (flg == "true") {
                        phoneStatus = true;
                    } else {
                        phoneStatus = false;
                        alert("手机号码已存在！");
                    }
                }
            });
        }
        return phoneStatus;
    }
}

function checkPassword() {
    if (password == "") {
        alert("请输入密码！");
        return false;
    } else {
        if (password.toString().length < 6) {
            alert("密码位数过低！")
            return false;
        } else if (password.toString().search("[a-zA-Z]") < 0) {
            alert("密码过于简单！")
        } else {
            return checkRePassword();
        }
    }
}

function checkRePassword() {
    if (rePassword == "") {
        alert("请再次输入密码！");
        return false;
    } else {
        if (rePassword != password) {
            alert("两次输入的密码不正确！");
            return false;
        } else {
            passwordStatus = true;
            return true;
        }
    }
}

function checkCodeStatus() {

    if (checkCode == "") {
        alert("请输入验证码！");
        return false;
    } else {
        $.ajax({
            type: 'POST',
            url: '/CheckCode',
            data: 'code=' + checkCode,
            async: false,
            success: function (flg) {
                if (flg == "true") {
                    codeStatus = true;
                } else {
                    codeStatus = false;
                }
            }
        });
        if (!codeStatus) {
            alert("验证码输入错误！");
        }
        return codeStatus;
    }
}

function submitRegister() {
    phone = $.trim($('#txt_username').val());
    password = $.trim($('#txt_password').val());
    rePassword = $.trim($('#txt_repassword').val());
    checkCode = $.trim($('#txt_vcode').val());
    if (checkPhone() && checkPassword() && checkCodeStatus()) {
        $.ajax({
            type: 'POST',
            url: '/RegisterServlet',
            data: 'phone=' + phone+'&password='+password,
            async: false,
            success: function (flg) {
                alert("注册成功！")
            }
        });
    } else {
        return false;
    }
}

function changeCode() {
    document.getElementById("vcode").src = "/CreateCheckCode?t=" + Math.random();
}


/*
$(function () {
    //提交注册
    $('#Login_Submit').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submit();
//        }, 300);

    });
});*/
