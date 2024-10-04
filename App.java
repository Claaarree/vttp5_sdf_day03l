import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import people.Person;
import service.CSVManangement;

public class App {
    public static void main(String[] args) throws IOException {
    //arg[0] arg[1] arg[2]
    //arg[0] "c:\data"
    //arg[1] myfile.txt
    //c:\datamyfile.txt
    //windows: c:\data\myfile.tx

    String dirPath = args[0];
    String fileName = args[1];

    // e.g c:/data/myfile.txt

    String dirPathFileName = dirPath + File.separator + fileName;

    // //check if directory exists
    // //if directory does not exist, create the directory (folder)
    // File directory = new File(dirPath);

    // if (directory.exists()) {
    //     System.out.println("Directory" + directory.toString() + "has already been created.");
    // } else {
    //     directory.mkdir();
    // }

    // File file = new File(dirPathFileName);

    // if (file.exists()) {
    //     System.out.println("File" + file.toString() + "has already been created.");
    // } else {
    //     file.createNewFile();
    // }

    // Console console = System.console();
    // String keyboardInput = console.readLine("Enter/Input a sentence: ");

    
    // //First method to read and write file
    // //Use Filewriter
    // //1. Use console to read in a string od text (sentence)
    // //2. Use FileWriter to write the content to the file

    // // FileWriter fw = new FileWriter(file, true);
    // // //boolean append means that if file will be updated if I try to write to the same file
    // // //otherwise the file will be overwritten
    // // fw.write(keyboardInput);
    // // fw.flush();
    // // fw.close();


    // // //Use FileReader to read the file

    // // FileReader fr = new FileReader(file);
    // // int dataRead = fr.read();
    // // while (dataRead != -1) {
    // //     System.out.println((char) dataRead);
    // //     dataRead = fr.read();
    // // }
    // // fr.close();


    // //Second method 
    // //Use bufferedWriter to write to file is faster than FileWriter for huge stream of data
    // // FileWriter fwb = new FileWriter(file, true);
    // // BufferedWriter bw = new BufferedWriter(fwb);
    // // bw.append(keyboardInput);
    // // bw.flush();
    // // bw.close();

    // // //Use BufferedReader to read file content

    // // try (FileReader frb = new FileReader(file)) {
    // //     try (BufferedReader br = new BufferedReader(frb)) {
    // //         String line = "";
    // //         while ((line = br.readLine()) != null) {
    // //             System.out.println(line);
    // //         }
    // //     }
    
    
    // // }
    // //no need to close if using try-catch block 
    // // br.close();
    // // fr.close();


    // //Third method 
    // //Use FileOutputStream to write to file
    // // FileOutputStream fos = new FileOutputStream(file, true);
    // // byte[] byteContent = keyboardInput.getBytes();
    // // fos.write(byteContent);
    // // fos.flush();
    // // fos.close();

    // // //Use FileInputStream to read the file
    // // FileInputStream fis = new FileInputStream(file);
    // // int contentRead = 0;
    // // while ((contentRead = fis.read()) != -1) {
    // //     System.out.println((char) contentRead);
    // // }
    // // fis.close();


    // //Fourth example (Decorator pattern)
    // // Use FileOutputStream and DataOutputStream to write to file
    // FileOutputStream fosd = new FileOutputStream(file, true);
    // DataOutputStream dos = new DataOutputStream(fosd);
    // byte[] byteContentD = keyboardInput.getBytes();
    // dos.write(byteContentD);
    // dos.flush();
    // dos.close();
    // fosd.close();

    // // Use FileInputStream and DataInputStream to read the file
    // FileInputStream fisd = new FileInputStream(file);
    // DataInputStream dis = new DataInputStream(fisd);
    // int disContent = 0;
    // while ((disContent = dis.read()) != -1) {
    //     System.out.print((char) disContent);
    // }
    // dis.close();
    // fisd.close();


    
    // //Fifth example (Decorator pattern)
    // // Use FileOutputStream and GZipOutputStream to write to file
    // FileOutputStream fosg = new FileOutputStream(file, true);
    // GZIPOutputStream gos = new GZIPOutputStream(fosg);
    // byte[] byteContentG = keyboardInput.getBytes();
    // gos.write(byteContentG);
    // gos.flush();
    // gos.close();
    // fosg.close();

    // // Use FileInputStream and DataInputStream to read the file
    // FileInputStream fisg = new FileInputStream(file);
    // GZIPInputStream gis = new GZIPInputStream(fisd);
    // int gisContent = 0;
    // while ((gisContent = gis.read()) != -1) {
    //     System.out.print((char) gisContent);
    // }
    // gis.close();
    // fisg.close();


    List<Person> persons = new ArrayList<>();    
    
    CSVManangement csv = new CSVManangement();
        csv.readCSV(dirPathFileName);


        //menu
        //1.Enter new Person details
        //2.save to file (Prompt for new csv file name)
        //3.Quit and terminate program

        Console consoleSelection = System.console();
        Integer selection = 0;
        while (selection != 3) {
        System.out.println("Welcome! Please select an option from the menu below:");
        System.out.println("1. Enter new Person details");
        System.out.println("2. Save to new csv file");
        System.out.println("3. Quit and terminate the program");
        selection = Integer.parseInt(consoleSelection.readLine(">>>"));

        switch (selection) {
            case 1:
                Console con1 = System.console();
                String personName = con1.readLine("Enter person name: ");
                String personRegion = con1.readLine("Enter region/area: ");
                Integer personYear = Integer.parseInt(con1.readLine("Enter year of birth: ").trim());

                Person p = new Person(personName, personRegion, personYear);
                persons.add(p);
                break;

            case 2:
            Console con2 = System.console();
            String newFilename = con2.readLine("Please Enter new file name:");
            CSVManangement csvm = new CSVManangement();
            csvm.writeCSV(dirPath + File.separator + newFilename, persons);
            break;


        }

        


        }
    }
    

}