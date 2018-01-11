function showGoodsName(goodsid) {
    var goodsname;
    switch (goodsid) {
        case 1:
            goodsname="机械设备";
            break;
        case 2:
            goodsname="家具";
            break;
        case 3:
            goodsname="食品";
            break;
        case 4:
            goodsname="生鲜";
            break;
        case 5:
            goodsname="家禽";
            break;
        case 6:
            goodsname="电子产品";
            break;
        case 7:
            goodsname="衣服饰品";
            break;
        case 8:
            goodsname="其他";
            break;
    }
    return goodsname;
}