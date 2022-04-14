package com.rachein.demo.result;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 8:52
 */
public class CodeMsg {

    private int code;

    private String msg;

    //通用：
    public static CodeMsg SUCCESS = new CodeMsg(200, "success");
    public static CodeMsg BIND_ERROR = new CodeMsg(50001, "参数错误!");
    public static CodeMsg ERROR_SERVER = new CodeMsg(50002, "服务器错误!");
    public static CodeMsg LOGIN_CHECK = new CodeMsg(50003, "请先登录!");
    public static CodeMsg PERMISSION_ERROR = new CodeMsg(50004, "权限不足！");
    public static CodeMsg ACCOUNT_NOT_EXITED = new CodeMsg(50005, "账号不存在！");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(50006, "密码错误！");
    public static CodeMsg ROLE_ERROR = new CodeMsg(50008, "此角色不在此权限分组内！");

    //课程 -> code:502xx
    public static CodeMsg COURSE_NOT_EXITED = new CodeMsg(50201, "课程不存在！");
    public static CodeMsg COURSE_REPEAT = new CodeMsg(50202, "不可以重复选择此课程！");
    public static CodeMsg EMPTY_COURSE_LIST = new CodeMsg(50203, "你还没有选课哦！");
    public static CodeMsg EMPTY_STUDENT_LIST_COURSE = new CodeMsg(50203, "该课程还没人选择");
    public static CodeMsg USER_NOT_EXITED = new CodeMsg(50204, "没有找到匹配的人员");




    public CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回带参数的错误码
     * @param args
     * @return
     */
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}