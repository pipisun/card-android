package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Shift+F9 to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);
//        }
        String image = getRefImage("playnow.png");
        System.out.println(image);
    }
    public static String getRefImage(String refImgName) throws Exception {

        File file = new File(System.getProperty("user.dir") + "/screenshot/" + refImgName);
        Path path = file.toPath();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(path));
    }
}