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

		// find total number of shapes
		int nlines = 5;
//		while (in.hasNextLine()) {
//			nlines++;
//			in.nextLine();
//		}
		
		String shapeType;
		int redComponent;
		int greenComponent;
		int blueComponent;
		boolean isFilled;
		
		double x;
		double y;
		double halfWidth;
		double halfHeight;
		
		double rad1;
		double rad2;
		
//		double x1;
//		double y1;
//		double x2;
//		double y2;
//		double x3;
//		double y3;
//		double[] xCoords;
//		double[] yCoords;
		
		// iterate over all of the shapes and add them to StdDraw

		for (int i = 0; i < nlines; i++) {

			shapeType = in.next();
			redComponent = in.nextInt();
			greenComponent = in.nextInt();
			blueComponent = in.nextInt();
			isFilled = in.nextBoolean();
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);

			if (shapeType.equals("rectangle")) {
				x = in.nextDouble();
				y = in.nextDouble();
				halfWidth = in.nextDouble();
				halfHeight = in.nextDouble();
				if (isFilled) {
					StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
				} else {
					StdDraw.rectangle(x, y, halfWidth, halfHeight);
				}
			} else if (shapeType.equals("ellipse")) {
				x = in.nextDouble();
				y = in.nextDouble();
				rad1 = in.nextDouble();
				rad2 = in.nextDouble();
				if (isFilled) {
					StdDraw.filledEllipse(x, y, rad1, rad2);
				} else {
					StdDraw.ellipse(x, y, rad1, rad2);
				}
			} else if (shapeType.equals("triangle")) {
				double x1 = in.nextDouble();
				double y1 = in.nextDouble();
				double x2 = in.nextDouble();
				double y2 = in.nextDouble();
				double x3 = in.nextDouble();
				double y3 = in.nextDouble();
				double[] xCoords = { x1, x2, x3 };
				double[] yCoords = { y1, y2, y3 };
				if (isFilled) {
					StdDraw.filledPolygon(xCoords, yCoords);
				} else {
					StdDraw.polygon(xCoords, yCoords);
				}

			}
			
		}

	}
}
