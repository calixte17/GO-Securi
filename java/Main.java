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
        File dir = new File("C:\\Users\\a.dupont\\Documents\\GO-Securi\\java\\file");
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

            else if (doc.getPath().contains("staff.txt")){
                str = "";
                while (obj.hasNextLine()){
                    str += str == "" ? obj.nextLine() : "," + obj.nextLine();
                }
                
                String[] parts = str.split(",");
                for (String part : parts) {
                    lAgent.add(part);
                }
            }
            else{
                str = "";
                while (obj.hasNextLine()){
                    str += str == "" ? obj.nextLine() : "," + obj.nextLine();
                }
                
                String[] parts = str.split(",");
                for (String part : parts) {
                    lFiche.add(part);
                }
                String NameAgent=parts[1].toLowerCase().charAt(0)+parts[0].toLowerCase();
                PrintWriter writer = new PrintWriter("C:\\Users\\a.dupont\\Documents\\GO-Securi\\java\\"+NameAgent+".html");
                lFiche.remove(parts[0]);
                lFiche.remove(parts[1]);
                lFiche.remove(parts[2]);
                lFiche.remove(parts[3]);
                //header
                writer.println("<!doctype html>\n<html lang='fr'>\n<head>\n<meta charset='utf-8'>\n<title>Titre de la page</title>\n<link rel='stylesheet' href='style.css'>\n<script src='script.js'></script>\n </head>\n<body>");
                writer.println("<div style='height:50%'>");

                writer.println("<div class='boxName'>");
                writer.println("<a>"+parts[0]+"<a>");
                writer.println("</div>");
                writer.println("<img class='imgAgent' src='img\\"+NameAgent+".png'/>");
                writer.println("</div>");
                //body
                writer.println("<div class='container listeEquipement'>");
                
              
                writer.println("<h2>Equipements </h2>");
                for (String ficheAgent : lFiche){
                    writer.println("<div class='Equipement'><a>"+ficheAgent+"<a></div>");
                }
              
                writer.println("</div>");
                //footer
                writer.println("\n </body> \n </html>");
                writer.close();
                lFiche.removeAll(lFiche);
            }
        }
        // génération html
        PrintWriter writer = new PrintWriter("C:\\Users\\a.dupont\\Documents\\GO-Securi\\java\\index.html");
        //header
        writer.println("<!doctype html>\n<html lang='fr'>\n<head>\n<meta charset='utf-8'>\n<title>Titre de la page</title>\n<link rel='stylesheet' href='style.css'>\n<script src='script.js'></script>\n</head>\n<body>");
        //body
        writer.println("<h1>Projet MSPR</h1>");
        writer.println("<div class='container'>");
        writer.println("<div class='listeAgents'>");
        writer.println("<h2>Liste de nos agents :</h2>");
        //liste des agents 
        writer.println("<ul>");
        for (String agent : lAgent  ){
        	
            writer.println("<li><a href='"+ agent +".html'>"+agent+"<a></li>");
        	
        }
        writer.println("</ul>");
        writer.println("</div>");
        writer.println("</div>");
        //footer
        writer.println("\n </body> \n </html>");
        writer.close();
    }
}


