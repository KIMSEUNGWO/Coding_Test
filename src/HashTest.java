public class HashTest {

    private static final String TEST_STRING = "http://localhost:8080/";
    private static final int COUNTER = 1000000000;
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        doIt();
        long endTime = System.currentTimeMillis();

        System.out.println("전체 걸린시간 : " + (endTime - startTime) + "/ms");
        System.out.println("----------------------------------------");
        long startTime2 = System.currentTimeMillis();
        doIt2();
        long endTime2 = System.currentTimeMillis();

        System.out.println("전체 걸린시간 : " + (endTime2 - startTime2) + "/ms");
    }

    private static void doIt() {
        for (int i = 0; i < COUNTER; i++) {
             String a = TEST_STRING + " FIRST_TEST_VALUE_STRING";
             a += "SECOND_TEST_VALUE_STRING";
        }
    }

    private static void doIt2() {
        for (int i = 0; i < COUNTER; i++) {
            String a = "http://localhost:8080/" + " FIRST_TEST_VALUE_STRING";
            a += "SECOND_TEST_VALUE_STRING";
        }
    }

}
