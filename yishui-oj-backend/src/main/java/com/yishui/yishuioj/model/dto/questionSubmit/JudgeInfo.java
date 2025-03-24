package com.yishui.yishuioj.model.dto.questionSubmit;

import lombok.Data;

/**
 * 判题信息
 */

@Data
public class JudgeInfo {

//    {
//        "message": "程序执行信息",
//            "time": 1000, // 单位为 ms
//            "memory": 1000, // 单位为 kb
//    }


    /**
     * 程序执行信息
     *
     */
    private String message;

    /**
     * 消耗内存
     *
     */
    private Long memory;

    /**
     * 消耗时间
     *
     */
    private Long time;


}
