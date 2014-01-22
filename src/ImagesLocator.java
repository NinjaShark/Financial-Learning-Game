/**
 * ImagesLocator.java
 * 
 * This class is used to retrieve the images when project is exported as a .jar
 *
 * @author http://forums.sun.com/thread.jspa?threadID=290536&tstart=28095
 */

import javax.swing.*;

/**
* Load images from correct place (directory or JAR file) into GUI.
*/
public class ImagesLocator
{
/**
* Load image from correct place (directory or JAR file).
*
* @param imageName name of image to be loaded (with no path)
* @return loaded image
*/
    public static ImageIcon getImage(String imageName)
    {
        ClassLoader cl = ImagesLocator.class.getClassLoader();
        ImageIcon i = new ImageIcon(cl.getResource(imageName));
        return i;
    }

}
