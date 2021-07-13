import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Line {
    private final String string_final= "[A-Za-z1-9]";
    private char[] charArray;
    public Line(String string) {

        charArray = string.toCharArray();
        try {
            checkLatinCharactersOrNot(string);
            searchForSingleCharacters(charArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void checkLatinCharactersOrNot(String string) throws Exception {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
        if(!p.matcher(string).matches())
            throw new Exception("There are no Latin characters and numbers in the string");

    }


    private void searchForSingleCharacters(char[] charArray) throws Exception {
        for(int i = 0; i< charArray.length-1; i++){
            for (int j = i+1; j< charArray.length; j++){
                if(charArray[i] == charArray[j]){
                    throw new Exception("There are duplicate characters in the string");
                }
            }
        }
    }




}