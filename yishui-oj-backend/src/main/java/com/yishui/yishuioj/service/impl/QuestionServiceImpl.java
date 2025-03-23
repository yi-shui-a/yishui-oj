package com.yishui.yishuioj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yishui.yishuioj.mapper.QuestionMapper;
import com.yishui.yishuioj.model.entity.Question;
import com.yishui.yishuioj.service.QuestionService;
import org.springframework.stereotype.Service;

/**
* @author a1480
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2025-03-23 19:14:57
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

}




