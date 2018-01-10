function exitLogin() {
    console.log("退出");
    delCookie("userId");
    delCookie("userType");
    document.location.href="/";
}

