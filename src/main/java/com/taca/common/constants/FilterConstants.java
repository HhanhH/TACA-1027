package com.taca.common.constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 芳华 on 2017/10/17.
 */
public class FilterConstants {
    public static List<String> getUnFilterList(){
        List<String> unfilterList= Arrays.asList("mobile/task/","mobile/goods/","mobile/notice/","mobile/login","mobile/register","mobile/rest/");
        return unfilterList;
    }
    public static boolean isContainsUrl(List<String> list,String url){
        for(String item :list){
            if(url.contains(item))
                return true;
        }
        return false;
    }
}
