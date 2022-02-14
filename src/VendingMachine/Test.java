package VendingMachine;

import java.io.IOException;

public class Test
{
    public static void main(String[] args) throws IOException
    {
        VendingUI vu = new VendingUI();
        vu.printMenu();
        vu.menuSelect();
        vu.menuRun();
    }
}
