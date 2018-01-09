<!--未完成-->
var type;
var departure;
var target;
var page;

function checkDeparture() {
    if(null!=departure ){
        return true;
    }
    alert("请选择出发地");
    return false;
}
function checkTarget() {
    if(null!=target ){
        return true;
    }
    alert("请选择目的地");
    return false;
}
function checkType() {
    if(!=type ){
        return true;
    }
    alert("请选择货物类型");
    return false;
}
<!-- 提交搜索条件 -->
function submit() {
    alert("dxgx");
    departure= $.trim($('#startplace').val());
    target = $.trim($('#destination').val());
    // type = $.trim($('#goodstype').val());
    type=1;
    page = 1;

     departure='河北省';
     target='河北省';
     type=1;
    if(checkDeparture() && checkTarget() && checkType()){
    // if(checkDeparture() && checkTarget()){
        alert("2");
        $.ajax({
            type: 'POST',
            url: '/OrderInfo/searchOrderInfo',//搜索获取订单信息
            data: 'type='+ type +'&departure='+ departure +'&target='+target +'&page='+page,
            async: false,
            success: function(data){
                console.log(data);
                // console.log(data.)
                var isSuccess=data["result"];
                var html='';

                for(var i in data){
                    console.log(data[i].orderInfo);
                }
                if(isSuccess > 1){
                    for( var j=0 ;j<isSuccess; j++){
                        html+='<th><td>'+isSuccess[j].name+'</td></th>';
                    }
                    var table = '<table>'+html +'</table>';
                    $("result").show();
                }else{
                    $("result").hide();
                }
            }
        });
    }
}


$(function () {
    //提交注册

    alert("x");
    $('#serch').bind("click", function () {
        //防止重复提交
        // submitBtnAvailability('disable');
//    	setTimeout(function(){
        submit();
//        }, 300);

    });
});


