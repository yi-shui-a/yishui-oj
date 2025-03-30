package com.yishui.yishuiojcodesandbox;

import com.yishui.yishuiojcodesandbox.model.ExecuteCodeRequest;
import com.yishui.yishuiojcodesandbox.model.ExecuteCodeResponse;


/**
 * 代码沙箱接口定义
 *
 */
public interface CodeSandbox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
