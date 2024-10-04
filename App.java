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
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

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


        CSVManangement csv = new CSVManangement();
        csv.readCSV(dirPathFileName);


    }
    

}