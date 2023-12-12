package com.lsl.packageofdemotsal.java21;

public class PatternMatchingExample {
    public static void main(String[] args) {
        String obj = "Hello, World!";

        // Old way without pattern matching
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Length of the string: " + str.length());
        } else {
            System.out.println("Not a String");
        }

        int a=4;
        switch (a) {
        case 4 : System.out.println("Length of the string: " );
        default : System.out.println("Not a String");
        }
        switch (a) {
        case 4 -> System.out.println("Length of the string: " );
        default -> System.out.println("Not a String");
        }
        
        // New way with pattern matching for switch
        switch (obj) {
            //case String s -> System.out.println("Length of the string: " + s.length());
            default -> System.out.println("Not a String");
        }
    }
}
