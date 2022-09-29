package ovinger.oving6;

import java.util.ArrayList;


public final class Matrise {
    

    private ArrayList<ArrayList<Integer>> A;

    public Matrise(ArrayList<ArrayList<Integer>> A) {
        this.A = new ArrayList<ArrayList<Integer>>(A);
        validMatrix(A);
    }

    private void validMatrix(ArrayList<ArrayList<Integer>> matrix) {
        try {
            int n_columns = matrix.get(0).size();
            for (ArrayList<Integer> row : matrix) {
                if (row.size() != n_columns)
                    throw new IllegalArgumentException("Matrices must have rows of the same length");
            }
            
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Matrix cannot be zero size");
        }
        
    }

    private void matrixSameSize(ArrayList<ArrayList<Integer>> matrix) {
        int A_n_rows = A.size();
        int A_n_cols = A.get(0).size();

        int M_n_rows = matrix.size();
        int M_n_cols = matrix.get(0).size();

        if (A_n_rows != M_n_rows || A_n_cols != M_n_cols)
            throw new IllegalArgumentException("Matrices must be the same size");
    }

    private void matrixCanBeMultiplied(ArrayList<ArrayList<Integer>> matrix) {
        int A_n_cols = A.get(0).size();
        int M_n_rows = matrix.size();

        if (A_n_cols != M_n_rows)
            throw new IllegalArgumentException("Matrices are not on the mxn nxm form");
    }

    //Iterate through all columns in a row, creating a new arrayList
    //for each one. Add the value to their respective new columns
    //Iterate through the rest of the rows, adding each element
    //to their respective columns
    private ArrayList<ArrayList<Integer>> transposeArray(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> transposed = new ArrayList<ArrayList<Integer>>();
        
        for (int row_index = 0; row_index < matrix.size(); row_index++) {

            ArrayList<Integer> row = matrix.get(row_index);
            for (int column_index = 0; column_index < row.size(); column_index++) {
                
                if (row_index == 0) {
                    ArrayList<Integer> new_column = new ArrayList<>();
                    transposed.add(new_column);
                }

                ArrayList<Integer> column_to_add_to = transposed.get(column_index);
                column_to_add_to.add(row.get(column_index));
            }       
        }
    
        return new ArrayList<>(transposed);
    }

    public ArrayList<ArrayList<Integer>> transpose() {
        return new ArrayList<>(transposeArray(A));
    }

    public ArrayList<ArrayList<Integer>> add(ArrayList<ArrayList<Integer>> B) {
        validMatrix(B);
        matrixSameSize(B);

        ArrayList<ArrayList<Integer>> summed = new ArrayList<ArrayList<Integer>>();

        for (int row_index = 0; row_index < A.size(); row_index++) {
            ArrayList<Integer> A_row = A.get(row_index);
            ArrayList<Integer> B_row = B.get(row_index);
            summed.add(new ArrayList<>());

            for (int column_index = 0; column_index < A_row.size(); column_index++) {
                Integer a = A_row.get(column_index);
                Integer b = B_row.get(column_index);
                summed.get(row_index).add(a + b);
            }
        }

        // printMatrix(summed);
        return new ArrayList<>(summed);
    }

    private int getProductForIndex(ArrayList<Integer> row, ArrayList<Integer> col) {
        int product = 0;
        for (int i = 0; i < row.size(); i++) {
            product += row.get(i) * col.get(i); 
        }

        return product;
    }

    public ArrayList<ArrayList<Integer>> multiply(ArrayList<ArrayList<Integer>> B) {
        matrixCanBeMultiplied(B);
        printMatrix(B);

        B = transposeArray(B);
        printMatrix(B);

        ArrayList<ArrayList<Integer>> product = new ArrayList<ArrayList<Integer>>();

        int product_row_count = A.size();
        int product_col_count = B.size();
        // System.out.println(product_row_count + " " + product_col_count);

        for (int row_index = 0; row_index < product_row_count; row_index++) {
            ArrayList<Integer> A_row = A.get(row_index);
            ArrayList<Integer> product_row = new ArrayList<>();
            
            for (int col_index = 0; col_index < product_col_count; col_index++) {
                ArrayList<Integer> B_col = B.get(col_index);
                product_row.add(getProductForIndex(A_row, B_col));
            }

            product.add(product_row);
        }

        printMatrix(product);
        return new ArrayList<>(product);
    }

    private void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        matrix.stream().forEach(row -> System.out.println(row));
        System.out.println('\n');
    }

}
