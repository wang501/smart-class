;!function (win) {
    var smart = function(){
        this.ver = '1.0.0';
    }
    /**
     * 数据表格的父元素 固定id为table_wrap
     * 获取 表格在页面占用的高度的微调值
     **/
    smart.prototype.getDiff = function(diff){
        var diffNew = diff||55;
        var top =  $("#table_wrap").offset().top;
        return   top+diffNew;
    }
    smart.prototype.initTableParam = function(diyParam){
        var initTableParam = {
            elem: '#TreeDemo'
            ,even: true
            ,height:312 //自适应 (不准)
            ,page: {limits:[10,50,100,500]} //开启分页
            ,request: {
                pageName: 'pageNum'
                ,limitName: 'pageSize'
            }
        };

        return  $.extend(initTableParam,diyParam);
    }
    smart.prototype.open = function(title,content,width,hight,yesParam,succParam){
      let  addOrEdit ={
                type: 2,
                title:title,
                content:content,
                shade: 0.8,
                area: [width,hight ],
                btn:['确定','取消'],
                yes:yesParam,
                success:succParam
        }
        layer.open($.extend(addOrEdit,yesParam,succParam));
    }
    win.smart = new smart();
}(window)

