package jp.lnc.label_decoration_sample;

import org.eclipse.core.runtime.Status;

public class DcoretionStatus extends Status
{
  public DcoretionStatus(
    int type,
    int code,
    String message,
    Throwable exception)
  {
    super(type, "hello", code, message, exception);
  }
  
  public DcoretionStatus(int code, String message)
  {
    this(code, code, message, null);
  }
  
  public DcoretionStatus(int code, String message, Throwable exception)
  {
    this(code, code, message, exception);
  }
}
