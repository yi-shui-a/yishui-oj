package com.yishui.yishuioj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yishui.yishuioj.common.ErrorCode;
import com.yishui.yishuioj.exception.BusinessException;
import com.yishui.yishuioj.model.dto.questionSubmit.JudgeInfo;
import com.yishui.yishuioj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.yishui.yishuioj.model.entity.Question;
import com.yishui.yishuioj.model.entity.QuestionSubmit;
import com.yishui.yishuioj.model.entity.QuestionSubmit;
import com.yishui.yishuioj.model.entity.User;
import com.yishui.yishuioj.service.PostService;
import com.yishui.yishuioj.service.QuestionService;
import com.yishui.yishuioj.service.QuestionSubmitService;
import com.yishui.yishuioj.service.QuestionSubmitService;
import com.yishui.yishuioj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author a1480
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2025-03-23 20:47:30
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{

    @Resource
    private QuestionService questionService;


    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        // todo 校验编程语言是否合法
        Long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }

        // 是否已题目提交
        long userId = loginUser.getId();
        // 每个用户串行题目提交
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(questionSubmitAddRequest.getLanguage());
        // todo 设置初始状态
        questionSubmit.setStatus(0);
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if(!save){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"数据插入失败");
        }
        return questionSubmit.getId();
    }

}




