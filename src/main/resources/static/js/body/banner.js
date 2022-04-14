$(function () {
    $.get("/User/index",function (data) {
        $(".header_userImg img").prop("src",data.userImg);
    })



})