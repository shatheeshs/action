   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifs.action;

/**
 *
 * @author satrlk
 */
import org.openide.windows.OnShowing;
import org.openide.modules.ModuleInstall;

@OnShowing
public class BasePlugin extends ModuleInstall implements Runnable{

   @Override
   public void run() {
      System.out.println("Action Plugin Loaded....");
   }
}
