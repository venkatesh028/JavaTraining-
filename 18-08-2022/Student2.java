public class Student2 extends Percentage {
    private int mark1;
    private int mark2;
    private int mark3;
    private int mark4;
    
    public Student2(int mark1, int mark2, int mark3, int mark4) {
	this.mark1 = mark1;
	this.mark2 = mark2;
	this.mark3 = mark3;
	this.mark4 = mark4;
    }

    public int getPercentage() {
	return mark1+mark2+mark3+mark4;
    }
}
