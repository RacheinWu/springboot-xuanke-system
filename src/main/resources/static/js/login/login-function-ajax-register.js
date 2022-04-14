$(function () {

    $(".form-reg-email").blur(checkValue_email);
    $(".password-reg1 input").blur(checkValue_password1);
    $(".password-reg2 input").blur(checkPassword2);
    $(".password-reg1 .login-span").click(afterOn);
    $(".password-reg2 .login-span").click(afterOn);
    $(".div-email-input-reg .login-span").click(afterOn);
    $(".regForm").submit(ajax_submit);
    $(".login_form").submit(ajax_submit_login);


})
// AJAX
function ajax_submit() {
    //当表单提交时，校验所有方法
    if(checkPassword2() && checkValue_password1() && checkPassword2()){
        let email = $(".form-reg-email").val();
                let password = $(".password-reg1 input").val();
                let emailType = $(".select-email-type").val();
        $.post("/User/register",{email:email+ "@"+ emailType,password:password},function (data) {
            if(data.flag){
                location.href = '/zhihu.html';
                return true;
                // alert()
            }else{
                $(".form-reg-email").css("border-color","red");
                $(".div-email-input-reg .login-span").html(data.errorMsg);
            }
        })
    }
    return false;
}

function ajax_submit_login() {
    let username = $(".Login_username input").val();
    let password = $(".Login_password input").val();

    $.post(
        {
            url: "/user/login",
            dateType:'json',
            async:false,
            headers:{'Content-Type':'application/json;charset=utf8'},
            data:JSON.stringify({
                "username": username,
                "password": password
            }),
            success:function (data) {

                alert(data.code)
                alert(data.msg)
                location.href = '/index.html';
                return true;
            }
        }
    );

    // $.get(
    //     {
    //         url: "/course/get/all",
    //         success:function (data) {
    //             alert(data.code)
    //             alert(data.msg)
    //             alert(data.data[0].id)
    //         }
    //
    //     }
    // );

}

//jsp: 不想让后端程序员去学习 javaScript
//非常乱套:


function afterOn() {
   $(this).html("");
}


function checkValue_email() {
    let email_input = $(".form-reg-email");
    //获取注册邮箱的值：
    var value = email_input.val();
    //定义正则表达式:
    var regular = /^\w{8,20}$/;
    let flag = regular.test(value);
    //判断是否合乎规则
    if(flag){
        //注册合乎规则
        email_input.css("border-color","rgb(9,187,7)");
        return true;
    }else{
        //注册格式不合乎规则
        email_input.css("border-color","red");
        email_input.next().html("请至少设置8位字符组合！");
        return false;
    }
}

function checkValue_password1() {
    //获取注册邮箱的值：
    let password1_input = $(".password-reg1 input");
    var value = password1_input.val();
    //定义正则表达式:
    var regular = /^\w{8,20}$/;
    //判断是否合乎规则
    let flag = regular.test(value);
    //进行视觉提示：
    if(flag){
        //注册合乎规则
        password1_input.css("border-color","rgb(9,187,7)");
        return true;
    }else{
        //注册格式不合乎规则
        password1_input.css("border-color","red");
        password1_input.next().html("请至少设置8位字符组合！");
        return false;
    }
}

function checkPassword2() {
    let password2_input= $(".password-reg2 input");
    let password2 = password2_input.val();
    let password1 = $(".password-reg1 input").val();
    if(password1 != password2){
        //密码不一致
        password2_input.css("border-color","red");
        password2_input.next().html("密码不一致！");
        return false;
    }else{
        // 密码一致
        password2_input.css("border-color","");
        return true;
    }

}