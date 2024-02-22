package com.example.dsalgo.ch4stacks;

import org.springframework.stereotype.Service;

import java.util.Stack;

/**
 * @author Hardeep Singh
 */
@Service
public class StackProblems {

    public int evaluatePostfix(String str){
       Stack<Integer> stack = new Stack<>();

       for(int i = 0; i< str.length(); i++){
           char c = str.charAt(i);
           if(Character.isDigit(c)){
               stack.push(c - '0');
           } else {
               int val1 = stack.pop();
               int val2 = stack.pop();
               if(c == '+'){
                 stack.push(val1 + val2);
               } else if(c == '-'){
                   stack.push(val2 - val1);
               } else if(c == '*'){
                   stack.push(val2 * val1);
               } else if(c == '/'){
                   stack.push(val2 / val1);
               }
           }
       }
       return stack.pop();
    }

    public static int precedence(char ch){
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public String infixToPostfix(String str){
        String result = new String();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result = result + c;
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '('){
                    result = result + stack.pop();
                }
            } else {
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    result = result + stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result = result + stack.pop();
        }
        return result;
    }

    // string - ()()((() - 4 ()()
    public int longestValidString(String str){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }

                if(!stack.isEmpty()){
                    int length = i - stack.peek();
                    if(length > result){
                        result = length;
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        return result;
    }

    public boolean hasDuplicateParenthesis(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            if(c == ')'){
                char top = stack.peek();
                stack.pop();
                int elementsInside = 0;
                while(top != '('){
                    top = stack.peek();
                    stack.pop();
                    elementsInside++;
                }
                if(elementsInside < 1){
                    return true;
                }
            } else {
                stack.push(c);
            }
        }
        return false;
    }

    public void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int top = stack.pop();
            sortStack(stack);
            sortedInsert(stack, top);
        }
    }

    private void sortedInsert(Stack<Integer> stack, int top) {
        if(stack.isEmpty() || top > stack.peek()){
            stack.push(top);
            return;
        }

        // if top is greater, remove and recur
        int temp = stack.pop();
        sortedInsert(stack, top);

        // push back temp item
        stack.push(temp);

    }

    public void towerOfHanoi(String source, String helper, String destination, int n){
        if(n == 1){
            System.out.println("transfer disk " + n + "from " + source + "to " +destination);
            return;
        }
        towerOfHanoi(source, destination, helper, n-1);
        System.out.println("transfer disk " + n + "from " + source + "to " +destination);
        towerOfHanoi(helper,destination ,source, n-1);
    }
}
