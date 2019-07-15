package utilities;

public class VytrackUtilities {




    /**
     * This method will put on pause execution
     *
     * @param seconds
     */
    public static void waitPlease(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
