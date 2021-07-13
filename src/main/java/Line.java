
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.regex.Pattern;

public class Line {
    private char[] charArray;

    private boolean line;

    public boolean getLine() {
        return this.line;
    }


    private static final Logger LOGGER = LogManager.getLogger(Line.class);

    public Line(String string) {
       checkStringParameters(string);
    }

    private void checkStringParameters(String string) {
        charArray = string.toCharArray();
        checkLatinCharactersOrNot(string);
        if (checkIfTheStringIsEmpty(string) == true &&
                 searchForSingleCharacters(charArray) == true) {
             LOGGER.debug("The string consists of Latin characters and / or numbers and does not contain duplicate characters");
               this.line = true;
        } else {this.line = false;}

    }

    private boolean checkIfTheStringIsEmpty(String string){
        if (string == "") {
            LOGGER.debug("There are no Latin characters and numbers in the string");
            return false;
        }else return true;

    }

    private void checkLatinCharactersOrNot(String string){
        Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
        if(!p.matcher(string).matches()){
            LOGGER.debug("There are no Latin characters and numbers in the string");
        }
    }

    private boolean searchForSingleCharacters(char[] charArray){
        for(int i = 0; i< charArray.length-1; i++){
            for (int j = i+1; j< charArray.length; j++){
                if(charArray[i] == charArray[j]){
                    LOGGER.debug("There are duplicate characters in the string");
                    return false;
                }
            }
        }
        return true;
    }




}