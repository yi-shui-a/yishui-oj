package com.yishui.yishuioj.controller;

import com.yishui.yishuioj.common.BaseResponse;
import com.yishui.yishuioj.common.ErrorCode;
import com.yishui.yishuioj.common.ResultUtils;
import com.yishui.yishuioj.exception.BusinessException;
import com.yishui.yishuioj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.yishui.yishuioj.model.entity.User;
import com.yishui.yishuioj.service.QuestionSubmitService;
import com.yishui.yishuioj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * 
 * 
 */
@RestController
@RequestMapping("/post_thumb")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录的id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

}
