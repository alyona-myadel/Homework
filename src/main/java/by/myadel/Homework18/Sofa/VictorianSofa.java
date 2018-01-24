package by.myadel.Homework18.Sofa;

public class VictorianSofa implements Sofa {
    @Override
    public void name() {
        System.out.println( "Victorian sofa" );
    }

    @Override
    public void style() {
        System.out.println( "Victorian" );
    }

    @Override
    public void numberOfSeats() {
        System.out.println( "two of seats" );
    }
}
