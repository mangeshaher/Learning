package dfs;

import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        boolean bool = s.length()%2==0 ? true : false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c== '{' || c=='['){
                st.push(c);
            }
            else{
                if(c=='}'){
                    if(!st.isEmpty() && st.peek()=='{'){
                        st.pop();
                    }
                    else{
                        bool = false;
                        break;
                    }
                }
                if(c==']'){
                    if(!st.isEmpty() && st.peek()=='['){
                        st.pop();
                    }
                    else{
                        bool = false;
                        break;
                    }
                }
                if(c==')'){
                    if(!st.isEmpty() && st.peek()=='('){
                        st.pop();
                    }
                    else{
                        bool = false;
                        break;
                    }
                }
            }
        }
        return st.isEmpty() ? bool : false;
    }
}
