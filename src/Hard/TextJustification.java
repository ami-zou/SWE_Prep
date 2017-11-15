package Hard;
import java.util.ArrayList;
import java.util.List;
/*
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16

[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 */

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justified = new ArrayList<String>();
        justifiedLine(words, 0, maxWidth, justified);
        return justified;
    }

    public static void justifiedLine(String[] words, int start, int maxWidth, List<String> justified){
        StringBuilder line = new StringBuilder();
                //String[] line = new String[maxWidth];
        StringBuilder temp = new StringBuilder();
        int numOfWords = 0;
        boolean isLastLine =false;
        //Iterate through the list
        for(int i = start ; i < words.length; i ++){
            //Test if it contains last character
            if(i == words.length-1) isLastLine = true;
            char[] word = words[i].toCharArray();
            //line.append(word);
            //Pick as many words as possible
            temp.append(word);
            /*
            System.out.println("\niteration "+i);
            System.out.println("line length: " + temp.length());
            System.out.println("word length: " + word.length);
            System.out.println("line + word length: " + temp.length()+word.length);
            */
            if(temp.length()+word.length > maxWidth){
                //System.out.println("execute");
                break;
            }else{
                numOfWords++;
                continue;
            }
        }
        if(isLastLine){  //If so, left justified
            for(int i = start; i < start+numOfWords; i ++ ) {
                line.append(words[i]);
            }
        }else{
            //Compute how many extra spaces, and how they are spread out
            int length = line.length();
            int space = (int) Math.floor((maxWidth-length)/numOfWords-1);
            int firstSpace = (maxWidth-length) - space*(numOfWords-2);

            //Iterate through the line and add extra space
            for(int i = start; i < start+numOfWords; i ++){
                line.append(words[i]);
                int j;
                if(i==start){
                    j = firstSpace;
                }else if (i==start+numOfWords) {
                    j = 0;
                }else{
                    j = space;
                }
                while(j > 0 ){
                    line.append(' ');
                    j --;
                }
            }
        }

        //Add the line to return list
        justified.add(line.toString());

        //Call it recursively
        /*
        System.out.println("start+numofwords: " + start + numOfWords);
        System.out.println("words.length: " + words.length);
        */
        if(start+numOfWords < words.length){
            justifiedLine(words, start+numOfWords, maxWidth, justified);
        }
    }

    public static void main(String[] args){
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println("TextJustification:");
        int L = 16;
        List<String> justified = fullJustify(words, L);
        for(int i = 0; i < justified.size(); i ++){
            System.out.println("iteration: " + i);
            System.out.println('\n'+justified.get(i));
        }

    }

}
