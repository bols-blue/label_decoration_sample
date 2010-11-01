package jp.lnc.label_decoration_sample.ui.decorator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

/**
 * Set of images that are used for decorating resources are maintained
 * here. This acts as a image registry and hence there is a single copy
 * of the image files floating around the project. 
 * 
 */
public class DemoImages
{
  /**
   * Lock Image Descriptor
   */ 
  private static final ImageDescriptor lockDescriptor = ImageDescriptor.
    createFromFile (DemoDecorator.class, "lock.gif");
  
  /**
   * Dirty Image Descriptor
   */ 
  private static final ImageDescriptor dirtyDescriptor = ImageDescriptor.
    createFromFile (DemoDecorator.class, "checkout.gif");
  
  /**
   * Extract Image Descriptor
   */ 
  private static final ImageDescriptor extractDescriptor = ImageDescriptor.
    createFromFile (DemoDecorator.class, "extract.gif");
    
  /**
   * Key Image Descriptor
   */ 
  private static final ImageDescriptor keyDescriptor = ImageDescriptor.
    createFromFile (DemoDecorator.class, "key.gif");
    
  
  /**
   * Constructor for DemoImages.
   */
  public DemoImages()
  {
    super();
  }

  /**
   * Get the lock image data
   * 
   * @return image data for the lock flag
   */   
  public ImageData getLockImageData()
  {
    return lockDescriptor.getImageData();
  }
  
  /**
   * Get the dirty flag image data
   * 
   * @return iamge data for the dirty flag
   */ 
  public ImageData getDirtyImageData()
  {
    return dirtyDescriptor.getImageData();
  }

  /**
   * Get the extract image data
   * 
   * @return image data for the extract flag
   * 
   */   
  public ImageData getExtractImageData()
  {
    return extractDescriptor.getImageData();
  }
  
  /**
   * Get the key image data
   * 
   * @return image data for the extract flag
   * 
   */   
  public ImageData getKeyImageData()
  {
    return keyDescriptor.getImageData();
  }
  
  /**
   * Get the image data depending on the key
   * 
   * @return image data 
   * 
   */ 
  public ImageData getImageData(String imageKey)
  {
    if (imageKey.equals("Lock"))
    {
      return getLockImageData();
    }
    if (imageKey.equals("Dirty"))
    {
      return getDirtyImageData();
    }
    if (imageKey.equals("Extract"))
    {
      return getExtractImageData();
    }
    if (imageKey.equals ("Owner"))
    {
      return getLockImageData();
    }
    return null;
  }
   
 // public ImageDescriptor 

}
