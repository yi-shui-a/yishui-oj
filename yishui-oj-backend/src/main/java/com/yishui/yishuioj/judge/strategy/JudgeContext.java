package com.yishui.yishuioj.judge.strategy;


import com.yishui.yishuioj.model.dto.question.JudgeCase;
import com.yishui.yishuioj.judge.codesandbox.model.JudgeInfo;
import com.yishui.yishuioj.model.entity.Question;
import com.yishui.yishuioj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 判题上下文 (用于定义在策略中传递的参数)
 *
 * @author yishui
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
