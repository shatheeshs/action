/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author satrlk
 */
public class UpdateHandler {

   public static final String path_bash = "C:\\Program Files\\Git\\git-bash.exe";

   // Create a file Output.txt where git-bash prints the results
   public static final String path_file_output_git_bash
           = "C:\\IFS\\test.txt";

   public static void main(String[] args) {
      // Path to your repository
      String path_repository = "cd C:/Users/Utente/Documents/Repository-SVN-Git/Bookkeeper";
      // Git command you want to run
      String git_command = "git ls-files | grep .java | wc -l";
            Properties prop = new Properties();
        
            
      String command = path_repository + " && " + git_command + " > " + path_file_output_git_bash;
      
      BashHandler b = BashHandler.getInstance();
      b.setRepositoryPath("test");
      System.out.println(b.getRepositoryPath());

//      runCommand(command);

   }
   

   public static void runCommand(String command) {
      try {
         ProcessBuilder processBuilder = new ProcessBuilder();
         processBuilder.command(path_bash, "-c", command);

         Process process = processBuilder.start();

         int exitVal = process.waitFor();
         if (exitVal == 0) {
            System.out.println(" --- Command run successfully");
            System.out.println(" --- Output = " + readFileTxt());

         } else {
            System.out.println(" --- Command run unsuccessfully");
         }
      } catch (IOException | InterruptedException e) {
         System.out.println(" --- Interruption in RunCommand: " + e);
         // Restore interrupted state
         Thread.currentThread().interrupt();
      }
   }

   public static String readFileTxt() {
      String data = null;
      try {
         File myObj = new File(path_file_output_git_bash);
         Scanner myReader = new Scanner(myObj);
         while (myReader.hasNextLine()) {
            data = myReader.nextLine();
         }
         myReader.close();
      } catch (FileNotFoundException e) {
         System.out.println(" --- An error occurred");
         e.printStackTrace();
      }
      return data;
   }
}
