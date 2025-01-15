using System;
using System.Collections.Generic;
using System.Text; 

public class HelloWorld
{
    public static void Main(string[] args)
    {
        Console.WriteLine (OldPhonePad("222 2 22#"));
        Console.WriteLine (OldPhonePad("33#"));
        Console.WriteLine (OldPhonePad("227*#"));
        Console.WriteLine (OldPhonePad("4433555 555666#"));
        Console.WriteLine (OldPhonePad("8 88777444666*664#"));
    }

    private static void initialisePhoneKeyCharMap(){
        phoneKeyCharMap["1"] = "&";
        phoneKeyCharMap["11"] = "'";
        phoneKeyCharMap["111"] = "(";
        phoneKeyCharMap["2"] = "A";
        phoneKeyCharMap["22"] = "B";
        phoneKeyCharMap["222"] = "C";
        phoneKeyCharMap["3"] = "D";
        phoneKeyCharMap["33"] = "E";
        phoneKeyCharMap["333"] = "F";
        phoneKeyCharMap["4"] = "G";
        phoneKeyCharMap["44"] = "H";
        phoneKeyCharMap["444"] = "I";
        phoneKeyCharMap["5"] = "J";
        phoneKeyCharMap["55"] = "K";
        phoneKeyCharMap["555"] = "L";
        phoneKeyCharMap["6"] = "M";
        phoneKeyCharMap["66"] = "N";
        phoneKeyCharMap["666"] = "O";
        phoneKeyCharMap["7"] = "P";
        phoneKeyCharMap["77"] = "Q";
        phoneKeyCharMap["777"] = "R";
        phoneKeyCharMap["7777"] = "S";
        phoneKeyCharMap["8"] = "T";
        phoneKeyCharMap["88"] = "U";
        phoneKeyCharMap["888"] = "V";
        phoneKeyCharMap["9"] = "W";
        phoneKeyCharMap["99"] = "X";
        phoneKeyCharMap["999"] = "Y";
        phoneKeyCharMap["9999"] = "Z";
        phoneKeyCharMap["*"] = "";
        phoneKeyCharMap["0"] = " ";
        phoneKeyCharMap["#"] = "";
    }
    
    public static string OldPhonePad(string input) {
        Dictionary<string, string> phoneKeyCharMap = new Dictionary<string, string>();
        initialisePhoneKeyCharMap(phoneKeyCharMap);
        StringBuilder s = new StringBuilder();
        int start = 0;
        int end = 0;
        bool errorOccured = false;
        while(end+1<input.Length && !errorOccured){
            if(input[end+1]==' ' || input[end+1]=='#' || input[end+1]!=input[end]){
                string charPart = input.Substring(start, end+1-start);
                if(phoneKeyCharMap.ContainsKey(charPart)){
                    if(charPart=="*"){
                        s.Remove(s.Length - 1, 1);
                    }
                    else{
                        s.Append(phoneKeyCharMap[charPart]);
                    }
                }
                else{
                    Console.WriteLine("$Error Occured");
                    errorOccured = true;
                }
                start = (input[end+1]==' ' || input[end+1]=='#') ? end+2 : end+1;
                end = (input[end+1]==' ' || input[end+1]=='#') ? end+2 : end+1;
            }
            else{
                end++;
            }
        }
        return errorOccured ? "Error in Input" : s.ToString();
    }
}