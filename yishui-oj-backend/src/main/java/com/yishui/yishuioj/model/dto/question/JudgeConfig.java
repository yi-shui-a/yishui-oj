package com.yishui.yishuioj.model.dto.question;

import lombok.Data;

/**
 * 判题配置
 */

@Data
public class JudgeConfig {

//    {
//        "timeLimit": 1000,
//            "memoryLimit": 1000,
//            "stackLimit": 1000
//    }

    /**
     * 时间限制 ( ms )
     *
     */
    private Long timeLimit;

    /**
     * 内存限制 ( KB )
     *
     */
    private Long memoryLimit;

    /**
     * 堆栈限制 ( KB )
     *
     */
    private String stackLimit;
}
