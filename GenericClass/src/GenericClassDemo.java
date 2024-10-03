/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author vamsi
 */
//Generic Class of Array Type
class Test<T>{
    T[] data = (T[]) new Object[10];
    //data creates datatype Array of size 10
    int length=0;
   public void append(T var){
        data[length++]=var;
   }
   public void display(){
       for(T x: data){
          if(x!=null){
           System.out.println(x);}
       }
   }
   
}

//Generic class with non-array object type
class Test2<T>{
    private T var;
    
    public void setVar(T val1){
        var = val1;
    }
    public T getVar(){
        return var;
    }
    
       }

//Test is generic but test3 only takes String datatype so not generic(subtype Generic class)
class  Test3 extends Test<String>{
    
    public void show(String val1){
        System.out.print(val1);
    }
    
}
//Test is generic 
class  Test4<T> extends Test<T> {
    
    public void show(T val1){
        System.out.print(val1);
    }
    
}

interface A{}
class B implements A{}

//bounded types(can only use datatype or childs of class  mentioned here all child classes of Number class can be used
//have to use extends for interface as well
class Test6<T extends Number,A> {
    
}



class  Test5{
    
    //Generic method
    public <T> void show(T val1){
        System.out.println(val1);
    }
    //Generic method with array parameter
    public <T> void show(T[] var){
        for(T x: var){
            System.out.println(x);
        }
    }
    //variable arguement with combination of bounded type(lower bound - child classes can be used
    public <E extends Number> void boundedType(E... var){
        for(E x: var){
            System.out.println(x);
        }
    }
    
     
    public void fun(Test<?> var){
        var.display();
    }
}
    


//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------
public class GenericClassDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Test<String> ob1 = new Test<>();
        //String
        ob1.append("Hello");
        ob1.append("World");
        ob1.display();
        //Integer
        Test<Integer> ob2 = new Test<>();
        ob2.append(1);
        ob2.display();
        
        
        //Non array generic class
        Test2<Integer> ob3 = new Test2<>();
        ob3.setVar(25);
        System.out.println(ob3.getVar());
          //No parameters can work with any data
        Test ob4 = new Test();
        ob4.append("Hello");
        ob4.append(10);
        ob4.display();
        
        //calling non generic class extending from generic class
        Test3 ob5 = new Test3();
        // error since 1 is int ob5.show(1);
        ob5.show("Hello this is not a generic class");
        
        Test4 ob6 = new Test4();
        ob6.show("Hello this is  a generic class");
        ob6.show(1);
        
        Test4<String> ob7 = new Test4();
        // Error since we fixed the type as String ob7.show(1);
        
        Test5 ob8 = new Test5();
        ob8.show(1);
        ob8.show("hello");
        
        ob8.show(new String[] {"hello", "krishna"}); 
        ob8.show(new Integer[]{1,2});
        
        Test<String> ob9 = new Test<>();
        ob9.append("This is for wild card method unbounded type");
        ob8.fun(ob9);
        
        
        
        
    }
    
}
