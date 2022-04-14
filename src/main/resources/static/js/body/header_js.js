// 点击搜索框进行：
//     1.长度+
//     2.提问框动态隐藏
//     3.显示提示栏
//     4.SVG变蓝色
$(function () {
    $("#header_search").click(function () {
        var headerSearch = $("#header_search");
        var searchTip = $(".search_Tip");
        var searchSubmit = $(".search_submit");
        var search_svg = $(".header_search_SearchInput_div svg");
        searchSubmit.css({"opacity":"0","display":"none"});
        search_svg.css({"right":"-460px","color":"rgb(0,102,255)"});
        searchTip.css({"display":"block","top":"48px"});
        headerSearch.css({"width":"470px","border-color":"rgb(130,141,163)","background-color":"white"});
        searchTip.animate({opacity:'1'},200);
    })
    $("#header_search").blur(function () {
        var headerSearch = $("#header_search");
        var searchTip = $(".search_Tip");
        var searchSubmit = $(".search_submit");
        var search_svg = $(".header_search_SearchInput_div svg");
        headerSearch.css({"background-color":"rgb(246,246,246)","border-color":"rgb(235,235,235)"});
        searchSubmit.css("display","block");
        search_svg.css({"color":"rgb(162,170,186)"});
        searchSubmit.animate({opacity:'1'},500);
        headerSearch.animate({width:'390px'},"fast");
        search_svg.animate({right:'-366px'},"fast");
        searchTip.animate({opacity:'0',top:'38px'},"fast",function () {
            $(this).css("display","none");
        });

    })




})