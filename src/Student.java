//Authors: Liam Morrissey and Lucy Grande

public class Student implements Comparable<Student>{
	private String name;
	private Integer score;

	@Override
	public String toString() {
		return name + " " + score;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	//Comparison with respect to score
	@Override
	public int compareTo(Student o) {
		return score - o.getScore();
	}



}
