import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import padl.generator.helper.ModelGenerator;
import padl.kernel.IIdiomLevelModel;

public class Main {

	public static void main(String[] args) {

		try (FileOutputStream FS = new FileOutputStream("plantuml.txt", true);
				BufferedOutputStream BS = new BufferedOutputStream(FS);
				PrintStream output = new PrintStream(BS)) {

			System.out.println("Start");
			PlantUMLVisitor fgVisitor = new PlantUMLVisitor();
			PlantUMLVisitor.printobj = output;

			IIdiomLevelModel model = ModelGenerator
					.generateModelFromClassFilesDirectory("C://Users//Harmanjeet Singh//git//v5.2//PADL//bin//padl//");
			model.walk(fgVisitor);
			System.out.println("End");
		} catch (IOException e) {
			System.out.println("Source not available.");
		}

	}

}
