package _04_Crazy_Digital_Painting;

import java.awt.Color;

public class CrazyDigitalPainting {
    // 1. Create two final static integers for the width and height of the display.
final static int WIDTH=1000;
final static int HEIGHT = 1000;

    // 2. Create a 2D array of Color objects. You will need to import
    //    java.awt.Color. Initialize the size of the array using the 
    //    integers created in step 1.
static Color[][] colors2d = new Color[WIDTH][HEIGHT];


    public CrazyDigitalPainting() {
        // 3. Open the crazy_digital_painting.png file and look at the image.
for(int x = 0; x<colors2d.length;x++) {
	for(int y = 0; y<colors2d.length;y++) {
	colors2d[x][y] = new Color((x^y)%256,(x*y)%256,(y^x)%256);	
	}
}

        // 4. Iterate through the 2D array and initialize each Color object
        //    to a new color. The sample image was created using the following 
        //    pattern:
        //    colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);

        // 5. Come up with your own pattern to make a cool crazy image.

        // 6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 
        //    to show off your picture.
    }

    public static void main(String[] args) {
        new CrazyDigitalPainting();
        new ColorArrayDisplayer().displayColorsAsImage(colors2d);;
        
    }
}
