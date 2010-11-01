package jp.lnc.label_decoration_sample.ui;

import jp.lnc.label_decoration_sample.DemoDecoratorManager;
import jp.lnc.label_decoration_sample.DemoResourcePropertiesManager;
import jp.lnc.label_decoration_sample.ui.decorator.DemoDecorator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;


/**
 * @author balajik
 * 
 * Class that implements FileProperty page
 *
 */
public class DemoFilePropertyPage extends PropertyPage
{
  private IResource resource_;
  private IProject project_;
  
  private Button setReadOnlyButton_;
  private Text prefixText_;
  private Text suffixText_;
  
  private boolean readOnlyButtonSelected_ = false;
  private String prefixNameValue_ = "";
  private String suffixNameValue_ = "";
  
  
  /**
	 * Constructor for DemoFilePropertyPage.
	 */
	public DemoFilePropertyPage()
	{
		super();
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(Composite)
	 * Function to create the controls. 
   */
	protected Control createContents(Composite arg0)
	{
    Composite parent = GuiFactory.getInstance().createComposite (arg0, 1);
    resource_ = (IResource) getElement();
    project_ = resource_.getProject();
    
    IWorkbenchWindow w = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    
    StringBuffer information = new StringBuffer 
      ("The resource " + resource_.getName() + "'s property \n ");
    information.append ("can be changed using this property page"); 
    Label informationLabel = new Label (parent, SWT.NONE);
    informationLabel.setText (information.toString());
    
    // Spacer
    Label spacer = new Label (parent, SWT.NONE);
    spacer.setText ("");
    
    // Create button for setting read only attribute.
    createReadOnlyOption (parent);
    
    // Prefix Text
    Composite child = GuiFactory.getInstance().createComposite (
      parent, 2);
    createPrefixText(child);   
    
    // Suffix Text
    Composite child2 = GuiFactory.getInstance().createComposite (
      parent, 2);
    createSuffixText(child2);   
    
    return parent;

  }
  
  /**
   * Create Read Only Button
   */ 
  private void createReadOnlyOption(Composite main)
  {
    setReadOnlyButton_ = new Button(main, SWT.CHECK);
    setReadOnlyButton_.setText ("Busy Resource ");
    boolean readOnly = resource_.isReadOnly();
    setReadOnlyButton_.setSelection (readOnly);
  }
  
  /**
   * Create Prefix Name Text Box 
   */ 
  private void createPrefixText(Composite main)
  {
    Label label = new Label(main, SWT.NONE);
    label.setText("Prefix Value ");
    
    prefixText_ = GuiFactory.getInstance().createTextField (main);
    
    String prefixValue = DemoResourcePropertiesManager.getPrefix(resource_);
    if (prefixValue == null)
    {
      prefixValue = "";
    }
    prefixText_.setText(prefixValue);
  }
  
  /**
   * Create Suffix Name Text Box 
   */ 
  private void createSuffixText(Composite main)
  {
    Label label = new Label(main, SWT.NONE);
    label.setText("Suffix Value ");
    
    suffixText_ = GuiFactory.getInstance().createTextField (main);
    
    String suffixValue = DemoResourcePropertiesManager.getSuffix(resource_);
    if (suffixValue == null)
    {
      suffixValue = "";
    }
    suffixText_.setText(suffixValue);
  }
  
  /**
   * Function to handle the ok button
   */ 
  public boolean performOk ()
  {
    DemoDecorator demoDecorator = DemoDecorator.getDemoDecorator();
    // To perform decoration with Image Caching
    // DemoDecoratorWithImageCaching demoDecorator = 
    //  DemoDecoratorWithImageCaching.getDemoDecorator();
    if(demoDecorator == null)
    {
      return true;
    }
    readOnlyButtonSelected_ = setReadOnlyButton_.getSelection();
    prefixNameValue_ = prefixText_.getText();
    suffixNameValue_ = suffixText_.getText();
    
    if (readOnlyButtonSelected_)
    {
      // Make the file read only
      resource_.setReadOnly (true);
    }
    else
    {
      resource_.setReadOnly (false);
    }
  
    if (readOnlyButtonSelected_)
    {
      // Update the persistent Property
      updatePersistentProperty ("Busy", "true");
    }
    else
    {
      updatePersistentProperty ("Busy", "false");
    }
    
    if(prefixNameValue_ != null && prefixNameValue_.length() != 0)
    {
      // Update the owner Persistent Property
      updatePersistentProperty ("Prefix", prefixNameValue_);  
    }
    else
    {
      updatePersistentProperty ("Prefix", null);  
    }
    
    if(suffixNameValue_ != null && suffixNameValue_.length() != 0)
    {
      // Update the owner Persistent Property
      updatePersistentProperty ("Suffix", suffixNameValue_);  
    }
    else
    {
      updatePersistentProperty ("Suffix", null);  
    }
    
    DemoDecoratorManager.addSuccessResources (resource_);
    
    // Refresh the label decorations... Change it to DemoDecoratorWithImageCaching if image caching should be used
    DemoDecorator.getDemoDecorator().refresh();
    // For Image Caching ... Change it to following
    // DemoDecoratorWithImageCaching.getDemoDecorator().refresh();
    return true;
  }
  
  /**
   * Function to handle APply button press
   */ 
  protected void performApply ()
  {
    MessageDialog.openInformation (getShell(), "Decorations", 
      "Press OK in the File Property page to decorate resources with the current Preference");
  }
  
  /**
   * Update the Persistent property
   */ 
  private void updatePersistentProperty (String qualifiedName,
    String qualifiedValue)
  {
    DemoResourcePropertiesManager.addPersistentProperty (resource_,
      qualifiedName, qualifiedValue);
  
  }
  
  /**
   * Function to handle default
   */ 
  protected void performDefaults ()
  {
    // Set the System login id 
    prefixText_.setText("Prefix");
    suffixText_.setText("Suffix");
  }
}

