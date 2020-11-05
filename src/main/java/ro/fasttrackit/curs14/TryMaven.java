package ro.fasttrackit.curs14;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class TryMaven {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Maven");

        String asciiArt = FigletFont.convertOneLine("Stefan");
        System.out.println(asciiArt);
    }
}
