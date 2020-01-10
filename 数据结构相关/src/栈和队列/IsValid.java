package 栈和队列;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：


 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。


 注意空字符串可被认为是有效字符串。
 */

/**
 * 使用栈实现
 */
public class IsValid {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (stack.isEmpty()) {
                if (temp == '(' || temp == '[' || temp == '{') {
                    stack.push(temp);
                } else {
                    return false;
                }
            } else {
                if (temp == '(' || temp == '[' || temp == '{') {
                    stack.push(temp);
                } else {
                    if (temp == ')') {
                        if (stack.pop() != '(') {
                            return false;
                        }
                    } else if (temp == ']') {
                        if (stack.pop() != '[') {
                            return false;
                        }
                    } else if (temp == '}') {
                        if (stack.pop() != '{') {
                            return false;
                        }
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
