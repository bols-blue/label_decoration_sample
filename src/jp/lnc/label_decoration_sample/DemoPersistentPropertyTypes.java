package jp.lnc.label_decoration_sample;

import org.eclipse.core.runtime.QualifiedName;

/**
 * @author balajik
 *
 * Utility class to maintain persistent property names and 
 * assosiated Qualified names
 *
 */
public class DemoPersistentPropertyTypes
{
  private static DemoPersistentPropertyTypes instance_;
  
 /**
  * Busy Qualified Name 
  */ 
  private QualifiedName busyQualifiedName_;
  
  /**
   * Prefix Qualified Name
   */ 
  private QualifiedName prefixQualifiedName_;
  
  /**
   * Suffix Qualified Name
   */ 
  private QualifiedName suffixQualifiedName_;
  
  /**
   * Constructor for DemoResourcePersistentProperty.
   */
  private DemoPersistentPropertyTypes()
  {
    // Allocate memory for all the qualified name 
    prefixQualifiedName_ = new QualifiedName("DemoDecorator", "Prefix");
    busyQualifiedName_ = new QualifiedName("DemoDecorator", "Busy");
    suffixQualifiedName_ = new QualifiedName("DemoDecorator", "Suffix");
  }
  
  public static DemoPersistentPropertyTypes getInstance()
  {
    if (instance_ == null)
    {
      instance_ = new DemoPersistentPropertyTypes();
    }
    return instance_;
  }
  
  /**
   * Get the Busy Qualified name 
   */ 
  public QualifiedName getBusyQualifiedName()
  {
    return busyQualifiedName_;
  }
  
  /**
   * Get the Prefix qualified name
   */ 
  public QualifiedName getPrefixQualifiedName()
  {
    return prefixQualifiedName_;
  }
  
  /**
   * Get the Suffix Qualifier name
   */ 
  public QualifiedName getSuffixQualifiedName()
  {
    return suffixQualifiedName_;
  }
  
  /**
   * Get the qualified name given the local name
   * 
   * @param localName local name of the qualified name
   * @return Qualified Name
   * 
   */ 
  public QualifiedName getQualifiedName(String localName)
  {
    if(localName.equals("Busy"))
    {
      return busyQualifiedName_;
    }
    else
    {
      if(localName.equals("Prefix"))
      { 
        return prefixQualifiedName_;
      }
      else
      {
        if(localName.equals("Suffix"))
        {
          return suffixQualifiedName_;
        }
      }
    }
    return null;
  }
}
