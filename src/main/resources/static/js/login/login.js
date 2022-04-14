$(function (){
    $(".regForm").hide();

    //页面加载完毕后
    // *点击密码框旁边的表情进行密码的隐藏或显示
    $(".password-view").click(function () {
        var passView = $(this);
        var password = $(".Login_password input");
        if(passView.html() == '(❁´◡`❁)'){
            //此时是显示密码，所以接下来的操作是隐藏密码
            password.prop("type","password");
            passView.html('(✿◡‿◡)');
        }else{
            password.prop("type","text");
            passView.html('(❁´◡`❁)');
        }
    });

    //点击账号输入框右侧的 ‘x’ 进行清空username输入框
    $(".emptyUsername svg").click(function(){
        $(".Login_username input").val("");
    })

    //点击choice进行显示不同的表单
    $(".choice2").click(function () {
        $(".regForm").show();
        $(".login_form").hide();
        $(".choice1 a").css({"font-weight":"400","font-size":"14px"});
        $(".choice2 a").css({"font-weight":"600","font-size":"17px"});
        $(".choice1 .Login_Blue_under").hide();
        $(".choice2 .Login_Blue_under").show();
    })
    $(".choice1").click(function () {

        $(".regForm").hide();
        $(".login_form").show();
        $(".choice1 a").css({"font-weight":"600","font-size":"17px"});
        $(".choice2 a").css({"font-weight":"400","font-size":"14px"});
        $(".choice2 .Login_Blue_under").hide();
        $(".choice1 .Login_Blue_under").show();
    })



})



