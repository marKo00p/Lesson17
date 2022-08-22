package homeworkForLesson17;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Random;
public class Main {
    private Random random = new Random();

    @MatrixProperties(type = Integer.class, rows=3, columns=3)
    public <T extends Number> void testMatrix1(Class<T> type, int rows, int columns) {
        Integer[][] matrix = (Integer[][])Array.newInstance(type, rows, columns);

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = random.nextInt();
                System.out.printf("%-15d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        Method[] declaredMethods = main.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(MatrixProperties.class)) {
                MatrixProperties matrixProperties = method.getAnnotation(MatrixProperties.class);
                if (matrixProperties == null) {
                    continue;
                }
                try {
                   main.testMatrix1(matrixProperties.type(),matrixProperties.rows(), matrixProperties.columns());
                } catch (Exception ignored) {

                }
            }
        }
    }
}
