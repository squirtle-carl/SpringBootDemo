package com.squirtle.test.main.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 字符串工具类
 * @date 2024/11/22
 */
public class StringUtils {
    private static final Map<Character,Character> map = new HashMap<>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};
    public static boolean isValidBrackets(String s) {
        if(!s.isEmpty() && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)){
                stack.addLast(c);
            } else if(!map.get(stack.removeLast()).equals(c)) {
                return false;
            }
        }
        return stack.size() == 1;
    }
    public static void main(String[] args) {
        System.out.println(StringUtils.isValidBrackets("([])"));
    }
}
