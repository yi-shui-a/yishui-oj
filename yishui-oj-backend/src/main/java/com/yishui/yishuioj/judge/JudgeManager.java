package com.yishui.yishuioj.judge;


import com.yishui.yishuioj.judge.strategy.DefaultJudgeStrategy;
import com.yishui.yishuioj.judge.strategy.JavaLanguageJudgeStrategy;
import com.yishui.yishuioj.judge.strategy.JudgeContext;
import com.yishui.yishuioj.judge.strategy.JudgeStrategy;
import com.yishui.yishuioj.model.dto.questionSubmit.JudgeInfo;
import com.yishui.yishuioj.model.entity.Question;
import com.yishui.yishuioj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 *
 * @author yishui
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();

        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if(language.equals("java")){
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);

    }
}
