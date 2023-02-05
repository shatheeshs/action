/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifs.action;

import static com.ifs.action.BaseActionTopComponent.PROP;
import java.io.IOException;

/**
 *
 * @author satrlk
 */
public class BashHandler {

   public static String BASH_PATH = "C:\\Program Files\\Git\\git-bash.exe";

   private String repositoryPath = "";

   private static BashHandler instance;

   public static BashHandler getInstance() {
      if (instance == null) {
         instance = new BashHandler();
      }
      return instance;
   }

   private BashHandler() {
      init();
   }

   private void init() {
      BASH_PATH = PROP.getProperty("BASH_PATH");
   }

   public String getRepositoryPath() {
      return repositoryPath;
   }

   public void setRepositoryPath(String repositoryPath) {
      this.repositoryPath = repositoryPath;
   }

   public void runCommand(String command) {
      try {
         ProcessBuilder processBuilder = new ProcessBuilder();
         processBuilder.command(BASH_PATH, "-c", command);

         Process process = processBuilder.start();

         int exitVal = process.waitFor();
         if (exitVal == 0) {
            System.out.println(" --- Command run successfully");

         } else {
            System.out.println(" --- Command run unsuccessfully");
         }
      } catch (IOException | InterruptedException e) {
         System.out.println(" --- Interruption in RunCommand: " + e);
         Thread.currentThread().interrupt();
      }
   }

}
