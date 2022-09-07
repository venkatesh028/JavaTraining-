class GrandFather {
    public void property1(){
	System.out.println("GrandFather Property1");
    }

    public void property2(){
	System.out.println("GrandFather Property2");
    }
}

class Father extends GrandFather {
    public void property3() {
        System.out.println("Father Property3");
    }
    
    public void property4() {
        System.out.println("Father Property4");
    }
    
}

class Son extends Father {
         
}

public class Property {
    public static void main(String[] args) {
	Son property = new Son();
        
        property.property1();
	property.property2();
	property.property3();
	property.property4();
    } 
}