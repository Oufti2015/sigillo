package sst.sigillo.tools;

import java.io.IOException;

import sst.common.file.output.OutputFile;

public class CssCreator {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Start...");
        try {
            try (OutputFile output = new OutputFile("sigillo-th.css")) {
                String char1[] = { "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
                String char2[] = { "2", "6", "A", "E" };
                int k = 1;
                for (int i = 0; i < char1.length; i++) {
                    for (int j = 0; j < char2.length; j++) {
                        output.println(".th" + k++ + " {");
                        output.println("\theight: 50px;");
                        output.println("\tbackground-color: #0000" + char1[i] + char2[j] + ";");
                        output.println("\tcolor: white;");
                        output.println("}");
                        output.println("");
                    }
                }
            }
            try (OutputFile output = new OutputFile("sigillo-tb.css")) {
                String char1[] = { "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
                String char2[] = { "2", "6", "A", "E" };
                // String char1[] = { "D", "C", "B", "A", "9", "8", "7", "6",
                // "5", "4", "3" };
                // String char2[] = { "E", "A", "6", "2" };
                int k = 1;
                for (int i = 0; i < char1.length; i++) {
                    for (int j = 0; j < char2.length; j++) {
                        output.println("td.b" + k++ + " {");
                        output.println("\theight: 30px;");
                        output.println("\twidth: 100%;");
                        output.println("\tvertical-align: middle;");
                        output.println("\tbackground-color: #FFFF" + char1[i] + char2[j] + ";");
                        output.println("\tcolor: black;");
                        output.println("}");
                        output.println("");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("...End");
    }
}
