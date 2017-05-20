package ir.comet;

import ir.comet.Utilities.TrackNumber;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Mohammad on 5/20/2017.
 */
public class Test {

    public static void main(String[] args) {
        TrackNumber trackNumber=new TrackNumber();
        String generate = trackNumber.generate(1);
        System.out.println(generate);
    }
}
