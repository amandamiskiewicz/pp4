package pl.amiskiewicz.creditcard;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String name= "Amanda";
        Double digit= 2.2;

        greet(name);

    }
    static void greet(String name){
        var helloMassage= String.format("Hello %s", name);
        System.out.println(helloMassage);
    }
}