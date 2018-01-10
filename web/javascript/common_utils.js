
function exitLogin() {
    console.log("退出");
    delCookie("userId");
    delCookie("userType");
    confirm("提示：您已成功退出账号！");
    document.location.href="/";
}

function checkLoginStatus() {
    if (null==getCookie("userId")||getCookie("userId")==""){
        document.location.href="/";
        return false;
    }else {
        return true;
    }
}

$(function () {
    checkLoginStatus();
});
