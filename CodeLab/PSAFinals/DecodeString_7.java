import java.util.Stack;

public class DecodeString_7 {
        public String decodeString(String s) {

            String str = "";
            Stack<Integer> countStack = new Stack<Integer>();
            Stack<String> stringStack = new Stack<String>();
            int index = 0;


            while(index < s.length()){
                if(Character.isDigit(s.charAt(index))){
                    int count = 0;
                    while(Character.isDigit(s.charAt(index))){
                        count = count * 10 + (s.charAt(index) - '0');
                        index++;
                    }
                    countStack.push(count);
                }

                else if(s.charAt(index) == '['){
                    stringStack.push(str);
                    str = "";
                    index++;
                }

                else if(s.charAt(index) == ']'){
                    StringBuilder builder = new StringBuilder(stringStack.pop());
                    int counter = countStack.pop();
                    for(int j = 0; j < counter; j++){
                        builder.append(str);
                    }
                    str = builder.toString();
                    index++;
                }

                else {
                    str += s.charAt(index);
                    index++;
                }

            }
            return str;

        }

}
