package jp.lnc.label_decoration_sample;


/**
 * Simple Logger utility to log information
 */ 

import org.eclipse.core.runtime.Status;

public class Logger
{
  public static void logError(String message, Throwable throwable)
  {
	  Activator.getDefault().getLog().log(
      new DcoretionStatus(Status.ERROR, message, throwable));
  }
  
  public static void logError(Throwable throwable)
  {
	  Activator.getDefault().getLog().log(
      new DcoretionStatus(Status.ERROR, throwable.getMessage(), throwable));
  }  
  
  public static void logInfo(String message)
  {
	  Activator.getDefault().getLog().log(
      new DcoretionStatus(Status.INFO, message));
  }  
}
