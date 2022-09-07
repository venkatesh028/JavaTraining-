public class Student1 extends Percentage {
    private int mark1;
    private int mark2;
    private int mark3;
  
    public Student1(int mark1, int mark2, int mark3) {
	this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }
  
    public int getPercentage() {
	return mark1+mark2+mark3;
    }

}
