package com.yishui.yishuioj.judge.codesandbox.impl;

import com.yishui.yishuioj.judge.codesandbox.CodeSandbox;
import com.yishui.yishuioj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yishui.yishuioj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yishui.yishuioj.judge.codesandbox.model.JudgeInfo;
import com.yishui.yishuioj.model.enums.JudgeInfoMessageEnum;
import com.yishui.yishuioj.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 示例代码沙箱
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        String code = executeCodeRequest.getCode();
        String language = executeCodeRequest.getLanguage();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());

        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);

        System.out.println("示例代码沙箱");
        return null;
    }
}
