package com.ccsi;

public class Main {

    public static void main(String[] args) {
	    String s="    -00001234577a78";
        System.out.println(myAtoi(s));
    }
    //Implement atoi to convert a string to an integer.
    //Hint:Carefully consider all possible input cases. if you want a challenge,please do not see below and ask
    //yourself what are the possible input cases.
    //1.my method
    public static int myAtoi(String str){
        if(str==null||str.length()==0)return 0;
        long res=0;
        char c='+';
        int index=0;
        while(str.charAt(index)==' ')index++;
        if(!"+-0123456789".contains(String.valueOf(str.charAt(index))))return 0;
        else{
            if(str.charAt(index)=='-'){
                c='-';
                index++;
            }else if(str.charAt(index)=='+'){
                c='+';
                index++;
            }

            while("0123456789".contains(String.valueOf(str.charAt(index)))){
                res=res*10+(str.charAt(index)-'0');
                index++;
            }
        }
        if(res>Integer.MAX_VALUE){
            if(c=='-')return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }else {
            if(c=='-')return -(int)res;
            else return (int)res;
        }
    }
    //2.
    public static int myAtoi1(String str){
        if(str==null||str.length()==0)return 0;
        str=str.trim();
        if(str.length()==0)return 0;
        int sign=1;
        int index=0;
        if(str.charAt(index)=='-'){
            sign=-1;
            index++;
        }else if(str.charAt(index)=='+'){
            sign=1;
            index++;
        }
        long res=0;
        for (; index <str.length() ; index++) {
            if(str.charAt(index)<'0'||str.charAt(index)>'9')break;
            res=res*10+(str.charAt(index)-'0');
            if(res>Integer.MAX_VALUE)break;
        }
        if(res*sign>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(res*sign<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (int)res*sign;
    }
}
