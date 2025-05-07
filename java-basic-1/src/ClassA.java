public class ClassA {
	String name="classA";
	
	public static void main(String arsg[]){
		ClassA clss_a=new ClassA();

		System.out.println(clss_a.name);
	}

	ClassA(){
		System.out.println("Constructor ClassA");

		// InnerClassBSub b=new InnerClassBSub();
		// System.out.println(b.name);
		// System.out.println(b.value);
		// b.printValue();
        InnerClassDSub d=new InnerClassDSub();
        System.out.println(d.name);
        System.out.println(d.value);
        d.printValue();
	}
	
	class InnerClassB{
		int value=0;
		String name="Inner ClassB";
		
		InnerClassB(){
			System.out.println("constractor ClassB");
			value=50;
		}

		void printValue(){
			System.out.println("value is:"+value);
		}
		
	} //inner ClassB end

	class InnerClassBSub extends InnerClassB{
		InnerClassBSub(){
			super();
			name="InnnerClassBSub";
		}
	}

    class InnerClassD {
        int value=0;
        String name="Inner ClassD";
        
        InnerClassD(){
            System.out.println("constractor ClassD");
            value=100;
        }

        void printValue(){
            System.out.println("value is:"+value);
        }
    }

    public class InnerClassDSub extends InnerClassD{
        InnerClassDSub(){
            super();
            name="InnnerClassDSub";
        }
    
        
    }
}