package com.rachein.demo.excpetors;

import com.rachein.demo.result.CodeMsg;
import lombok.Getter;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 8:51
 */
@Getter
public class GlobalException extends RuntimeException{

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }
}
