package de.marvin;

public class InputBoolean {
    public static boolean isClear(char input)
    {
        return input == '#';
    }



    public static boolean isNumber(char input)
    {
        try
        {
            Integer.parseInt(""+input);
            return true;
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }
    }


    public static boolean isDot(char input)
    {
        return input == '.';
    }


    public static boolean isEndDelimiter(char input){
        return input == '=';
    }


    public static boolean isOperation(char input)
    {
        return input == '+' || input == '/' || input == '*' || input == '-';
    }
    public static boolean isSpecialOperation(char input)
    {
        return input == 'l' || input == '√' || input == '^';
    }


}
