function changeCheckCode() {
  var checkCode=  document.getElementsByName("checkCode");
  var t=Math.random();
  for(var i=0;i<checkCode.length;i++){
      checkCode[i].src= "/CheckCode/create?t=" + t;
  }
}