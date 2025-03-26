package com.yishui.yishuioj.judge;

import com.yishui.yishuioj.model.entity.QuestionSubmit;
import com.yishui.yishuioj.model.vo.QuestionSubmitVO;

/**
 * 判题服务
 */
public interface JudgeService {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
