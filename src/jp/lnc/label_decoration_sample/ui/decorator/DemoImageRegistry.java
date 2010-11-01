package jp.lnc.label_decoration_sample.ui.decorator;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @author balajik
 *
 * Image registry for Resources. This class is a utility class to get
 * the image given the image key. 
 * 
 */ 
public class DemoImageRegistry
{
  private ImageRegistry imageRegistry;

	/**
	 * Constructor for DemoImageRegistry.
	 */
	public DemoImageRegistry()
	{
		if (imageRegistry == null)
    {
      imageRegistry = new ImageRegistry();
    }
	}
  
  /**
   * Get the image from image registry given the key
   *
   * @param key Image key
   * @return Image
   */  
  public Image getImage(String key)
  {
    return imageRegistry.get(key);
  }
  
  /**
   * Assosiate the image with image key
   * 
   * @param key Image key
   * @param image Image to be assosiated with image key
   * 
   */ 
  public void setImage(String key, Image image)
  {
    imageRegistry.put(key, image);
  }
}
