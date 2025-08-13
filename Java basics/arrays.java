public class arrays {
    public static void main(String[] args) {
        // Classroom of 500 students
        int [] marks = new int[5];
        marks [0] = 100;
        marks [1] = 10;
        marks [2] = 1000;
        marks [3] = 1;
        marks [4] = 300;
        System.out.println(marks[4]);
        System.out.println(marks.length);
        System.out.println("-------");
        //similiar work can also be done by
        double [] mark = {10.0f,1f,1.0f,100.0,1f,300f};  // Any type of data can be array
        System.out.println(mark[4]);
        System.out.println("-------");
        //How to dispaly an array either by above method individually one by one or usinng for loop
        for (int i = mark.length -1; i>=0;i--){   //printing in reverse order
            System.out.println(mark[i]);
        }
        System.out.println("-------");
        //using for each loop only in new version
        for (int element: marks){
            System.out.println(element);
        }
    }
    
}
