package com.yishui.yishuioj.judge.strategy;

import com.yishui.yishuioj.model.dto.questionSubmit.JudgeInfo;

/**
 * 判题策略接口
 *
 * @author yishui
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
