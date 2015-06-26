import netscape.security.PrivilegeTable;

import java.util.StringTokenizer;

public class WrapExercise {


    public String wrapString(String stringToWrap, int wrapLength) {
        validateWrappingLength(wrapLength);

        String wrappedBuffer = "";
        while (stringToWrap.length() > wrapLength) {
            int splitPoint = calculateSplitPointFor(stringToWrap, wrapLength);
            wrappedBuffer += stringToWrap.substring(0, splitPoint) + "\n";
            if (stringToWrap.charAt(splitPoint) != ' ') {
                stringToWrap = stringToWrap.substring(splitPoint).trim();
            } else {
                stringToWrap = stringToWrap.substring(splitPoint+1);
            }
        }
        wrappedBuffer += stringToWrap;

        return wrappedBuffer;
    }

    private int calculateSplitPointFor(String stringToWrap, int wrapLength) {
        int splitPoint = wrapLength;
        if (stringToWrap.charAt(splitPoint) != ' ') {
            splitPoint = stringToWrap.indexOf(' ');
            splitPoint = splitPoint == -1 || splitPoint > wrapLength ? wrapLength : splitPoint;
        }
        return splitPoint;
    }


    private void validateWrappingLength(int wrapLength) {
        if (wrapLength <= 0) {
            throw new IllegalArgumentException();
        }
    }


    private String wrap(String s, int n) {
        if(s.length() <= n)
            return  s;
        else
        {
            int split = s.lastIndexOf("", n);
            if(split == -1){
                split = n;
                        return s.substring(0,split).trim() + "\n" + wrap(s.substring(split).trim(),n);
            }
        }
    }


}
