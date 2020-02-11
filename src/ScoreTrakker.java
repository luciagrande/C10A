import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ScoreTrakker {
	private ArrayList<Student> students= new ArrayList<Student>();

	public void loadDataFromFile(String name) throws IOException{
		FileReader reader = new FileReader(name);
		Scanner in = new Scanner(reader);
		while(in.hasNext()) {
			Student student = new Student();

			student.setName(in.next() +" " + in.next());
			student.setScore(in.nextInt());
			
			students.add(student);
		}
		
		in.close();
		reader.close();
	}

	public void printInOrder() {
		Collections.sort(students);
		for (Student x : students) {
			System.out.println(x);
		}
	}

	public void processFiles()  {
		try {
			loadDataFromFile("scores.txt");
			printInOrder();
		}
		catch(IOException e) {
			e.getCause();
			System.out.println(e);
		}
	}


	public static void main(String[] args) {
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}
}
