class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<String> stack = new Stack<>();
        int index = 0;
        while(index < len){
            String token = tokens[index];
            Boolean isOperand = isTokenOperand(token);
            if(isOperand){
                Integer result = calculate(stack, token);
                stack.push(String.valueOf(result));
            } else {
               stack.push(tokens[index]); 
            }
            index = index + 1;
        }
        return Integer.parseInt(stack.pop());
    }
    
    private Boolean isTokenOperand(String token){
        if(token.equals("+")
          || token.equals("-")
          || token.equals("*")
          || token.equals("/")){
           return true; 
        }
        return false;
    }
    
    private Integer calculate(Stack<String> stack, String token){
        Integer operand1 = Integer.parseInt(stack.pop());
        Integer operand2 = Integer.parseInt(stack.pop());
        System.out.println("operand1 "+operand1+" operand2 "+operand2+" token "+token);
        switch (token){
            case "+":
                return operand1 + operand2;
            case "-":
                return operand2 - operand1;
            case "/":
                return operand2 / operand1;
            case "*":
                return operand1 * operand2;    
                
        }
        return null;
    }
}