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
        List<Equipement> lEquipement = new Vector<Equipement>();
        List<String> lFiche = new Vector<String>();
        //File doc = new File("test.txt");
        File dir = new File(".\\java\\file");
        File[] FileSearch = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
        }  });
        
        File liste = new File(".\\java\\file\\liste.txt");
        Scanner listetxt = new Scanner(liste);
            str = "";
            while (listetxt.hasNextLine()){
                str += str == "" ? listetxt.nextLine() : "," + listetxt.nextLine();
            }
            
            String[] parts = str.split(",");
          
            for (String part : parts) {
                String[] equipement = part.split("\t");
                String cat = equipement[0];
               
               for(String equip : equipement) {
            	   if(equip != cat) {
            	   Equipement stuff = new Equipement(cat,equip);
            	   lEquipement.add(stuff);
            	   }
               }
            }
            listetxt.close();
        for (File doc : FileSearch) {

            Scanner obj = new Scanner(doc);
             if (doc.getPath().contains("liste.txt")){}
            else if (doc.getPath().contains("staff.txt")){
                str = "";
                while (obj.hasNextLine()){
                    str += str == "" ? obj.nextLine() : "," + obj.nextLine();
                }
                
                 parts = str.split(",");
                for (String part : parts) {
                    lAgent.add(part);
                }
            }
            else{
                str = "";
                while (obj.hasNextLine()){
                    str += str == "" ? obj.nextLine() : "," + obj.nextLine();
                }
                
                 parts = str.split(",");
                for (String part : parts) {
                    lFiche.add(part);
                }
                String NameAgent=parts[1].toLowerCase().charAt(0)+parts[0].toLowerCase();
                PrintWriter writer = new PrintWriter(".\\java\\"+NameAgent+".html");
                lFiche.remove(parts[0]);
                lFiche.remove(parts[1]);
                lFiche.remove(parts[2]);
                lFiche.remove(parts[3]);
                //header
                writer.println("<!doctype html>\n<html lang='fr'>\n<head>\n<meta charset='utf-8'>\n<title>"+parts[0]+" "+parts[1] +"</title>\n<link rel='stylesheet' href='style.css'>\n<script src='script.js'></script>\n </head>\n<body>");
                writer.println("<div style='height:50%'>");

                writer.println("<div class='boxName'>");
                writer.println("<a>"+parts[0]+"<a>");
                writer.println("</div>");
                writer.println("<img class='imgAgent' style='padding:10px' src='img\\"+NameAgent+".jpg'/>");
                writer.println("</div>");
                //body
                writer.println("<div class='container listeEquipement'>");
                
              
                writer.println("<h2>Equipements </h2>");
                for (String ficheAgent : lFiche){
                	for(Equipement equip : lEquipement){
                		if(equip.id.contains(ficheAgent)) {
                			writer.println("<div class='Equipement'><a>"+equip.Name+"<a></div>");
                		}
                	}
                	
                }
              
                writer.println("</div>");
                //footer
                writer.println("\n </body> \n </html>");
                writer.close();
                lFiche.removeAll(lFiche);
                obj.close();
            }
        }
        java.util.Collections.sort(lAgent);
        // génération html
        PrintWriter writer = new PrintWriter(".\\java\\index.html");
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




