public class Polydrome {
    public static void main(String[] args) {
        String s1 = "А роза упала на лапу Азора";
        String s2 = "А роза упала";
        System.out.println(s1+" "+ isPolydrome(s1));
        System.out.println(s2+" "+ isPolydrome(s2));

    }
    private static Boolean isPolydrome(String str){
        return str.toLowerCase().replaceAll(" ", "")
                .equals(new StringBuilder(str).reverse().toString().toLowerCase().replaceAll(" ", ""));
    }
}
