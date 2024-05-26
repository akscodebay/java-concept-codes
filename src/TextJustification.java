import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> stringList = new ArrayList<>(0);
        StringBuilder temp = new StringBuilder(words[0]);
        int spaceCount = 0;
        for (int i = 1; i < words.length; i++) {
            if((temp+" "+words[i]).length()>maxWidth){
                int spacesRequired = maxWidth-temp.length();
                int extraSpace  = 0;
                int remainder = 0;
                if(spaceCount != 0){
                    extraSpace  = spacesRequired/spaceCount;
                    remainder = spacesRequired%spaceCount;
                    stringList.add(getStringBuilder(extraSpace, temp, remainder).toString());
                }
                else {
                    extraSpacesAppender(spacesRequired, temp);
                    stringList.add(temp.toString());
                }
                temp = new StringBuilder();
                temp.append(words[i]);
                spaceCount = 0;
                continue;
            }
            temp.append(" ");
            temp.append(words[i]);
            spaceCount++;
        }
        extraSpacesAppender(maxWidth-temp.length(), temp);
        stringList.add(temp.toString());
        return stringList;
    }

    private static StringBuilder getStringBuilder(int extraSpace, StringBuilder temp, int remainder) {
        StringBuilder justifiedLine = new StringBuilder();
        StringBuilder extraSpaces = new StringBuilder();
        extraSpacesAppender(extraSpace, extraSpaces);
        for (int j = 0; j < temp.length(); j++) {
            justifiedLine.append(temp.charAt(j));
            if(temp.charAt(j)==' '){
                justifiedLine.append(extraSpaces);
                if(remainder >0){
                    justifiedLine.append(" ");
                    remainder--;
                }
            }
        }
        return justifiedLine;
    }

    private static void extraSpacesAppender(int extraSpace, StringBuilder extraSpaces) {
        while(extraSpace !=0){
            extraSpaces.append(" ");
            extraSpace--;
        }
    }


    public static void main(String[] args) {
        String[] str = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(new TextJustification().fullJustify(str, 16));
    }
}
