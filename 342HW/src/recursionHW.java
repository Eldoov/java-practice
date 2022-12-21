// cs342 Homework by Zuowen Tang

public class recursionHW {

    public static int count = 0;

    public static void main(String[] args) {
        System.out.println(convert(404));
        System.out.println(convert(65535));
        System.out.println(convert(31415));
        System.out.println();
        starsReccursion(4);
        starsReccursion(7);
        starsReccursion(13);
    }

    public static String convert(int num){
        if(num < 10){
            return num+"";
        }
        return convert(num/10)+""+(num%10);
    }

    public static void starsReccursion(int n){
        starsRec1(n);
        for(int i = 0; i<2; i++){
            for(int j=0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        starsRec2(n);
        count = 0;
        System.out.println();
        return;
    }

    public static void starsRec1(int n){
        count++;
        if(count >= n){
            return;
        }
        for(int i=0; i < count; i++){
            System.out.print("*");
        }
        System.out.println();
        starsRec1(n);
    }

    public static void starsRec2(int n){
        if(n <= 0){
            return;
        }
        for(int i = 0; i<n; i++){
            System.out.print("*");
        }
        System.out.println();
        starsRec2(n-1);
    }

}
