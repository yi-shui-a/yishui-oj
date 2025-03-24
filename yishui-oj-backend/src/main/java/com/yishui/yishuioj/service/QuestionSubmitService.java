package com.yishui.yishuioj.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yishui.yishuioj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.yishui.yishuioj.model.entity.Post;
import com.yishui.yishuioj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yishui.yishuioj.model.entity.User;

/**
* @author a1480
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-03-23 20:47:30
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {


    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
