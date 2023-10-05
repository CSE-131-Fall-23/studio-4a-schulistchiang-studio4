package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); // making Scanner with a File

		String shapeType = in.next();
		int redComponent = in.nextInt();
		int greenComponent = in.nextInt();
		int blueComponent = in.nextInt();
		boolean isFilled = in.nextBoolean();
		StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
		
		if (shapeType.equals("rectangle")) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double halfWidth = in.nextDouble();
			double halfHeight = in.nextDouble();
			if (isFilled) {
				StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
			} else {
				StdDraw.rectangle(x, y, halfWidth, halfHeight);
			}
		}
		else if (shapeType.equals("ellipse")) {
			double x = in.nextDouble();
			double y = in.nextDouble();
			double rad1 = in.nextDouble();
			double rad2 = in.nextDouble();
			if (isFilled) {
				StdDraw.filledEllipse(x, y, rad1, rad2);
			} else {
				StdDraw.ellipse(x, y, rad1, rad2);
			}
		}
		else if (shapeType.equals("triangle")) {
			double x1 = in.nextDouble();
			double y1 = in.nextDouble();
			double x2 = in.nextDouble();
			double y2 = in.nextDouble();
			double x3 = in.nextDouble();
			double y3 = in.nextDouble();
			double[] xCoords = {x1, x2, x3};
			double[] yCoords = {y1, y2, y3};
			if (isFilled) {
				StdDraw.filledPolygon(xCoords, yCoords);
			} else {
				StdDraw.polygon(xCoords, yCoords);
			}
			
		}
		
	}
}
