package io.github.lantice3720;

import java.util.regex.Pattern;

public class Fx {

    public static boolean isNumeric(String str){
        if(str == null){
            return false;
        }
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
