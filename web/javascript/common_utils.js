
function exitLogin() {
    console.log("退出");
    delCookie("userId");
    delCookie("userType");
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
