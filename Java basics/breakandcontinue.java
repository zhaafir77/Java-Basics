public class breakandcontinue {
    public static void main(String[] args) {
        
        //using break loop
        for (int i=0;i<5;i++){
            System.out.println(i);
            System.out.println("Code with Usman");
            if(i==2){
                System.out.println("End the loop");
                break;
            }
       }
        for (int i=0;i<5;i++){
            if(i==2){
                System.out.println("End the loop");
                continue;
            }
            System.out.println(i);
            System.out.println("Code with Usman");
    }
    
}
}
