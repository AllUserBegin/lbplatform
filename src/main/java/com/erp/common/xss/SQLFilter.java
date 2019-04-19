package com.erp.common.xss;


import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SQL过滤
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-01 16:16
 */
public class SQLFilter {


          //非法字符
    private static String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str) throws  Exception{
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();



        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new Exception("包含非法字符");
            }
        }

        return str;
    }


    /*
       判断是否有常见的SQL关键字
       true 表示参数存在SQL注入风险
       false 表示参数不存在SQL注入风险
     */
    public  static  Boolean sqlStrFilter(String str)
    {
        if(StringUtils.isBlank(str)){
            return null;
        }
        str = str.toUpperCase();

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword)>0){
                return  true;
            }
        }
        return  false;
    }

    private static final String REGX = "!|！|@|◎|#|＃|(\\$)|￥|%|％|(\\^)|……|(\\&)|※|(\\*)|×|(\\()|（|(\\))|）|_|——|(\\+)|＋|(\\|)|§ ";
    /**
     * 对非法字符进行检测
     *
     * @param sInput
     * @return
     *  true 表示参数不包含非法字符
     *  false 表示参数包含非法字符
     */
    public static Boolean isIllegalStr(String sInput) {

        if (sInput == null || sInput.trim().length() == 0) {
            return false;
        }
        sInput = sInput.trim();
        Pattern compile = Pattern.compile(REGX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(sInput);
        return matcher.find();
    }

}
