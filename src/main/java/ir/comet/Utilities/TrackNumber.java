package ir.comet.Utilities;

import java.util.Date;

/**
 * Created by Mohammad on 5/20/2017.
 */
public class TrackNumber {

    public String generate(long customerId){
        String trackNumber=customerId+"CMT"+new Date().getTime();
        return trackNumber;
    }
}
