package VendingMachine;

import java.io.IOException;

public class KitTest {

    public void KitRun()
    {
        CheckKit ck = new CheckKit();

        try {
            ck.dateOfBirth();
            ck.checkSymptoms();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ck.ageCalc();
    }
}
