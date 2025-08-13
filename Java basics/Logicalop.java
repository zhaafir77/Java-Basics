public class Logicalop {
    public static void main(String[] args) {
        System.out.println("For logical and ");
        boolean a = true;
        boolean b = false;
        // And
        //return true only if both the conditions are true can be used on more value
        if (a && b) 
        {
            System.out.println("Y");
        }
        else{
            System.out.println("N");
        }
        System.out.println("For logical or");
        //Or
        // If any of the condition is true it will print true if both are true then it will also print true
        if (a || b)
        {
            System.out.println("Y");
        }
        else{
            System.out.println("N");
        }
        //Not
        System.out.println("Not(a) is ");
        System.out.println(!a);
        System.out.println("Not(b) is ");
        System.out.println(!b);
    }   // it will print the opposite value
    
}
