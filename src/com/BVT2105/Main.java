package com.BVT2105;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	System.out.println(solutions(0,0,1));
    System.out.println(findZip("all zip files are zipped"));
    System.out.println(checkPerfect(496));
    System.out.println(flipEndCharts("Cat, dog, and mouse."));
    System.out.println(isValidHexCode("#CD5C5C"));
    System.out.println(same(new Integer[]{9,8,7,6},new Integer[]{4,4,3,1}));
    System.out.println(isKaprekar(22222));
    System.out.println(longestZero("01100001011000"));
    System.out.println(nextPrime(100));
    System.out.println(rightTriangle(145,105,100));
    }

    // №1: Эта функция считает количество действительных решений квадратного уравнения ax^2+bx+c=0 , где a,b,с - коэффы
    public static String solutions(double a, double b, double c) {
        double D = b*b-4*a*c;
        if(a == 0 && b == 0 && c == 0) return "solution: x - any number";
        else if(a == 0 && b == 0 || D < 0) return "0";
        else if(a == 0 || D == 0) return "1";
        else return "2";
    }

    // №2: Эта функция возвращает позицию второго вхождения "zip" в строку, или -1 если второго вхождения не происходит
    public static int findZip(String a) {
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) == 'z' && a.charAt(i + 1) == 'i' && a.charAt(i + 2) == 'p') {
                a = a.substring(i + 2);
                for (int j = 0; j < a.length(); j++)
                    if (a.charAt(j) == 'z' && a.charAt(j + 1) == 'i' && a.charAt(j + 2) == 'p') return i + 2 + j;
                    return -1;

            }
        return -2;
    }

    // №3: Эта функция проверяет, является ли целое число совершенным(его можно записать через сумму его множителей)
    public static boolean checkPerfect(int x) {
        int y = 0;
        for (int i = 1; i < x; i++) if(x % i == 0) y +=i;
        return x == y;
    }

    // №4: Эта функция возвращает строку, меняя первый и последний символ местами,
    // Если символов <2, возвращает несовместимо, если символы совпадают, то два - это пара
    public static String flipEndCharts(String newStr) {
        if(newStr.length() < 2) return "incompatible";
        else if(newStr.charAt(0) == newStr.charAt(newStr.length()-1)) return "two is a pair";
        else return newStr.charAt(newStr.length()-1) + newStr.substring(1,  newStr.length()-1) + newStr.charAt(0);
    }

    // №5: Эта функция проверяет, является ли строка допустимым шестнадцатеричным кодом(начинается с #,
    // имеет длину 6 символов, и допустимые символы 0-9, и буквы A-F, буквы могут быть прописными и строчными
    public static boolean isValidHexCode(String code) {
        if (code.charAt(0) != '#' || code.length() != 7) return false; // Первичная проверка на первые два условия
        for(int i = 1; i < 7; i++) {                                    // Проверка на соответствие символов через их
            if( ((int) code.charAt(i) < 48 || (int) code.charAt(i) > 57) // Значения в таблице ASCII
                    && ((int) code.charAt(i) < 65 || (int) code.charAt(i) > 70)
                    && ((int) code.charAt(i) < 97 || (int) code.charAt(i) > 102)) return false;
        }
        return true;
    }

    // №6: Эта функция проверяет равны ли кол-ва уникальных элементов в двух массивах
    public static boolean same(Integer[] arr1, Integer[] arr2) {
        Set<Integer> uniqKeys1 = new HashSet<Integer>(Arrays.asList(arr1));
        Set<Integer> uniqKeys2 = new HashSet<Integer>(Arrays.asList(arr2));
        return uniqKeys1.size() == uniqKeys2.size();
    }

    // №7: Эта функция проверяет, является ли положительное целое число n числом Капрекара, то есть число, которое
    // после возведения в квадрат и разбиения на две лексикографические части равно сумме двух полученных новых чисел
    public static boolean isKaprekar(Integer n) {
        String x = "" + n*n;
        if(x.length() == 1) return n*n == n;
        return (Integer.parseInt(x.substring(0, x.length()/2)) + Integer.parseInt(x.substring((x.length())/2)) == n);
        // Данный метод будет работать независимо от четного или нечетного кол-ва чисел в строке
    }

    // №8: Эта функция возвращает самую длинную последовательность последовательных нулей в двоичной строке
    public static String longestZero(String str) {
        int maxLength = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                int k = 1;
                for (int j = i+1; j < str.length(); j++) {
                    if (str.charAt(j) == str.charAt(i)) k++;
                    else break;
                }
                maxLength = Math.max(k, maxLength);
            }
        }
        return new String(new char[maxLength]).replace('\0', '0');
    }

    // №9: Эта функция возвращает следующее простое число, если заданное число не простое, если число простое вернуть его
    public static int nextPrime(int n) {
        boolean flag = true;
        for (int i = n; i < n+10000; i++) {
            for (int j = 2; j < i-1; j++)
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            if(flag) return i;
            else flag = true;
        }
        return -1;
    }

    // №10: Эта функция определяет, являются ли три числа x,y,z ребрами прямоугольного треугольника
    public static boolean rightTriangle(int x, int y, int z) {
        int maxRight1 = Math.max(x,y);
        int minRight1 = Math.min(x,y);
        int maxRight = Math.max(maxRight1, z);
        int minRight = Math.min(maxRight1, z);
        if( maxRight > minRight + minRight1) return false;
        return maxRight*maxRight == minRight*minRight + minRight1*minRight1;
    }
}
