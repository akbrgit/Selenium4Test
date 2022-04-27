import java.util.regex.*;

class PatternTest {
    public static void main(String[] args) {
        String s="weelccoomme hhoommeee";
        Pattern pattern = Pattern.compile("(.)\\1*");
        Matcher m = pattern.matcher(s);
        String output="";
        while(m.find()){
            output=output+m.group().charAt(0);
        }
        System.out.println(output); 
    }
}
