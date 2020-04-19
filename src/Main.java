import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import padl.creator.classfile.CompleteClassFileCreator;
import padl.generator.helper.ModelGenerator;
import padl.kernel.ICodeLevelModel;
import padl.kernel.IIdiomLevelModel;
import padl.kernel.exception.CreationException;
import padl.kernel.impl.Factory;

public class Main {

	public static void main(String[] args) {

		String path = "D://pravesh//Concordia//2020-Winter//SOEN-6461-SDM//project//v5.2//CPL//bin//util//lang/";
		String aName = "deliverable3";
		String[] someSources = new String[] { path };

		String root = "D://pravesh//Concordia//2020-Winter//SOEN-6461-SDM//project//v5.2//POM Tests//data//java.lang.jar";
		String jdkroot = "D://pravesh//Concordia//2020-Winter//SOEN-6461-SDM//project//v5.2//POM Tests//data//jdk102.jar";
		String dddforums = "D://pravesh//Concordia//2020-Winter//SOEN-6461-SDM//project//v5.2//POM Tests//data//DDDDfroums.jar";
		String log4jJar = "D://tmp//log4j-1.2.17.jar";
		String actorID = "java.lang.LinkageError";

		try (FileOutputStream FS = new FileOutputStream("plantuml.txt", true);
				BufferedOutputStream BS = new BufferedOutputStream(FS);
				PrintStream output = new PrintStream(BS)) {

			System.out.println("Start");
			PlantUMLVisitor fgVisitor = new PlantUMLVisitor();
			PlantUMLVisitor.printobj = output;
//		IIdiomLevelModel model = ModelGenerator.generateModelFromJAR(log4jJar);

			IIdiomLevelModel model = ModelGenerator.generateModelFromClassFilesDirectory(
					"D://pravesh//Concordia//2020-Winter//SOEN-6461-SDM//project//v5.2//PADL//bin//padl//");
			model.walk(fgVisitor);
			System.out.println("End");
		} catch (IOException e) {
			System.out.println("Source not available.");
		}

	}

}
