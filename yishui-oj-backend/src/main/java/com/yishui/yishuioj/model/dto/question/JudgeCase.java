package com.yishui.yishuioj.model.dto.question;


import lombok.Data;

/**
 * 题目用例
 */
@Data
public class JudgeCase {

//    [
//    {
//        "input": "1 2",
//            "output": "3 4"
//    },
//    {
//        "input": "1 3",
//            "output": "2 4"
//    }
//]


    /**
     * 输入用例
     *
     */
    private String input;
    /**
     * 输出用例
     *
     */
    private String output;

}
