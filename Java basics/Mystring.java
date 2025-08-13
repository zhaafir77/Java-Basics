public class Mystring {
    public static void main(String[] args) {
        String sc = new String("Arhan is goat (bakri) ");
        System.out.println(sc);
        int l = sc.length();
        System.out.println(l);
        System.out.println(sc.substring(2));
        System.out.println(sc.substring(1,4));
        System.out.println(sc.replace('A','O'));
        System.out.println(sc.startsWith("Arh"));
        System.out.println(sc.endsWith("Arh"));
        System.out.println(sc.charAt(3));
        System.out.println(sc.indexOf("A"));
        System.out.println(sc.indexOf("a",4));
        System.out.println(sc.lastIndexOf("is"));
        System.out.println(sc.lastIndexOf("a",4));
        System.out.println(sc.equals("Arh"));
        System.out.println(sc.equalsIgnoreCase("Arhan is goat (bakri) "));
        String ls = sc.toLowerCase();
        System.out.println(ls);
        String Us = sc.toUpperCase();
        System.out.println(Us);

        String nonTrimmedString =  "      Arhan     ";
        System.out.println(nonTrimmedString.trim());
        //System.out.println(nonTrimmedString);



        //Escape sequence

        System.out.println("I am a java programmer \n but that's not true");
        System.out.println("I am java programmer \t but that's not true");
        System.out.println("I  am a java programmer \' but that's not true");
        System.out.println("I am a java programmer \\ but that's not true");
    }
    
}
//index starts with 0
