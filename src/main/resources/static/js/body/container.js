$(function () {
    var time = 0;
    var currentPage = 1;
    // alert("1231");
    $(window).scroll(function () {
        //判断计时器是否处于关闭状态
        if (time == 0) {
            time = 2; //设定间隔时间（秒）
            //启动计时器，倒计时time秒后自动关闭计时器。
            var index = setInterval(function () {
                time--;
                if (time == 0) {
                    clearInterval(index);
                }
            }, 1000);
            // alert('按钮事件被触发');
            var scrollT = $(window).scrollTop();
            var pageH = $(document.body).height();
            // alert(scrollT);
            // alert("body-Height = " + pageH);
            // alert(arrivedAtBottom());
            if(arrivedAtBottom()){
                currentPage++;
                $.get("Questions/findAll",{currentPage:currentPage},function (data) {
                    for(var i = 0; i<data



                        .length; i++){
                        var li1 = "";
                        // alert(2);
                        if(data[i].topicImg != null){
                            var li = '<div class="you" style="overflow: hidden;height: 220px;">\n' +
                                '                <h4>' + data[i].topic + '</h4>\n' +
                                '                <img src=" '+ data[i].topicImg +' " alt="">\n' +
                                '                <p> ' + data[i].container + '\n' +
                                '                <span class="diji">阅读全文</span></p>\n' +
                                '                <div class="pinxuan">\n' +
                                // '                    <div class="ty"><div class="jiantou1"></div></div>\n' +
                                '                    <div class="zt">赞同</div>\n' +
                                '                    <div class="ty1"><div class="jiantou2"></div></div>\n' +
                                '                    <div class="pinglun">\n' +
                                '                        <ul>\n' +
                                '                            <li>添加评论</li>\n' +
                                '                            <li>分享</li>\n' +
                                '                            <li>收藏</li>\n' +
                                '                            <li>喜欢</li>\n' +
                                '                            <li>举报</li>\n' +
                                '                            <li>...</li>\n' +
                                '                        </ul>\n' +
                                '                    </div>\n' +
                                '                </div>\n' +
                                '            </div>'

                        }else{
                            var li = '<div class="wu">\n' +
                            '            <h4 style="clear: both;">' + data[i].topic +'</h4>\n' +
                            '           <p> ' + data[i].container + '\n' +
                            '               <span class="diji">阅读全文</span></p>\n' +
                            '            <div class="pinxuan" style="margin-top: 10px;">\n' +
                            '                <div class="ty"><div class="jiantou1"></div></div>\n' +
                            '                <div class="zt">赞同</div>\n' +
                            '                <div class="ty1"><div class="jiantou2"></div></div>\n' +
                            '                <div class="pinglun">\n' +
                            '                    <ul>\n' +
                            '                        <li>添加评论</li>\n' +
                            '                        <li>分享</li>\n' +
                            '                        <li>收藏</li>\n' +
                            '                        <li>喜欢</li>\n' +
                            '                        <li>举报</li>\n' +
                            '                        <li>...</li>\n' +
                            '                    </ul>\n' +
                            '                </div>\n' +
                            '            </div>\n' +
                            '        </div>'
                            }
                        li1+=li;
                        $(".Box_container").append(li1);
                    }
                })
            }
        }
    })

    var arrivedAtBottom = function () {
        var scrollT = $(window).scrollTop();
        var pageH = $(document.body).height();

        return scrollT / pageH > 0.3;
    }


})