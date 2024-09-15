package 프로그래머스.component;

public class Confirm {

    public static void confirm(Object[][] confirmResult, Object[][] myResult) {
        System.out.println();
        System.out.println("예상한 결과 : " + print(confirmResult));
        System.out.println("내 결과 : " + print(myResult));
        System.out.println("정답 결과 : " +  compare(confirmResult, myResult));

        System.out.println();
    }
    public static void confirm(Object[] confirmResult, Object[] myResult) {
        System.out.println();
        System.out.println("예상한 결과 : " + print(confirmResult));
        System.out.println("내 결과 : " + print(myResult));
        System.out.println("정답 결과 : " +  compare(confirmResult, myResult));
        System.out.println();
    }

    public static void confirm(Object confirmResult, Object myResult) {
        System.out.println("예상한 결과 : " + confirmResult);
        System.out.println("내 결과 : " + myResult);
        System.out.println("정답 결과 : " +  confirmResult.equals(myResult));
        System.out.println();
    }

    private static boolean compare(Object[][] confirmResult, Object[][] myResult) {
        if (confirmResult.length != myResult.length) return false;

        for (int i = 0; i < confirmResult.length; i++) {
            if (!compare(confirmResult[i], myResult[i])) return false;
        }
        return true;
    }
    private static boolean compare(Object[] confirmResult, Object[] myResult) {
        if (confirmResult.length != myResult.length) return false;

        for (int i = 0; i < confirmResult.length; i++) {
            if (!confirmResult[i].equals(myResult[i])) return false;
        }
        return true;
    }

    private static String print(Object[][] objects) {
        StringBuilder temp = new StringBuilder("[");
        for (int i = 0; i < objects.length; i++) {

            temp.append(print(objects[i]));
            if (i == objects.length - 1) break;
            temp.append(", ");
        }
        return temp.append("]").toString();
    }

    private static String print(Object[] objects) {
        StringBuilder temp = new StringBuilder("[");
        for (int i = 0; i < objects.length; i++) {

            temp.append(objects[i]);
            if (i == objects.length - 1) break;
            temp.append(", ");
        }
        return temp.append("]").toString();
    }

}
