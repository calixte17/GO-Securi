import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String str = "";
        List<String> lAgent = new Vector<String>();
        List<String> lEquipement = new Vector<String>();
        List<String> lFiche = new Vector<String>();
        //File doc = new File("test.txt");
        File dir = new File("C:\\Users\\c.flory\\Documents\\java\\file");
        File[] FileSearch = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
        }  });
        for (File doc : FileSearch) {

            Scanner obj = new Scanner(doc);
            
            if (doc.getPath().contains("equipement.txt")){
                str = "";
                while (obj.hasNextLine()){
                    str += str == "" ? obj.nextLine() : "," + obj.nextLine();
                }
                
                String[] parts = str.split(",");
                for (String part : parts) {
                    lEquipement.add(part);
                }
            }

            else if (doc.getPath().contains("fiche_agent.txt")){
                str = "";
                while (obj.hasNextLine()){
                    str += str == "" ? obj.nextLine() : "," + obj.nextLine();
                }
                
                String[] parts = str.split(",");
                for (String part : parts) {
                    lFiche.add(part);
                }
            }

            else if (doc.getPath().contains("agent.txt")){
                str = "";
                while (obj.hasNextLine()){
                    str += str == "" ? obj.nextLine() : "," + obj.nextLine();
                }
                
                String[] parts = str.split(",");
                for (String part : parts) {
                    lAgent.add(part);
                }
            }
        }

        PrintWriter writer = new PrintWriter("test2.html");
        //header
        writer.println("<!doctype html>\n<html lang='fr'>\n<head>\n<meta charset='utf-8'>\n<title>Titre de la page</title>\n<link rel='stylesheet' href='style.css'>\n<script src='script.js'></script>\n</head>\n<body>");
        //body
        writer.println("<div class='container'>");
        writer.println("<ul>");
        for (String agent : lAgent){
            writer.println("<li><a href='#'>"+agent+"<a></li>");
        }
        writer.println("</ul>");
        writer.println("</div>");
        //footer
        writer.println("\n </body> \n </html>");
        writer.close();
    }
}


