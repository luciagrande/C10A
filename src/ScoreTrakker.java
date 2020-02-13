//Author: Liam Morrissey and Lucy Grande
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ScoreTrakker {
	private ArrayList<Student> students= new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"}; 

	public void loadDataFromFile(String name) throws FileNotFoundException //if file isn't present, throw this exception
	{
		FileReader reader = new FileReader(name); //This is where error is thrown if file not found
		Scanner in = new Scanner(reader);
		while(in.hasNext()) {
			Student student = new Student();

			student.setName(in.next() +" " + in.next());
			String score = in.next();
			//try catch to handle non integer values
			try {
				student.setScore(Integer.parseInt(score)) ;
				students.add(student);
			} catch(NumberFormatException e) {
				System.out.println("Incorrect format for "+student.getName()+" not a valid score: "+score);
			}

		}

		in.close();
	}

	public void printInOrder() {
		//sorts the student with the defined comparable
		Collections.sort(students);
		for (Student x : students) {
			System.out.println(x);
		}
	}

	//Method for getting students from files
	public void processFiles()  {
		//Loads from all files provided
		for (String x : files) {
			try {
				loadDataFromFile(x);
				printInOrder();
				System.out.println();
			}
			//catches files that don't exist
			catch(FileNotFoundException e) {
				System.out.println("Can't open file: "+x);
			}
		}

	}


	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}
}
