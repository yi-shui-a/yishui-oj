package com.yishui.yishuioj.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yishui.yishuioj.model.dto.question.QuestionQueryRequest;
import com.yishui.yishuioj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.yishui.yishuioj.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.yishui.yishuioj.model.entity.Post;
import com.yishui.yishuioj.model.entity.Question;
import com.yishui.yishuioj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yishui.yishuioj.model.entity.User;
import com.yishui.yishuioj.model.vo.QuestionSubmitVO;
import com.yishui.yishuioj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);


    /**
     * 获取题目提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目提交封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
