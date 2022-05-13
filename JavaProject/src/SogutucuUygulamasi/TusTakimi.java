package SogutucuUygulamasi;

import java.util.Scanner;

public class TusTakimi implements ITusTakimi{
    @Override
    public int veriAl() {
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }
}
