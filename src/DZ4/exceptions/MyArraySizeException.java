package DZ4.exceptions;

/**
 * Class to generate exception while checking array sizes
 */
public class MyArraySizeException extends Exception {
    /**
     * Rows amount
     */
    private final int rows;
    /**
     * Columns amount
     */
    private final int columns;

    /**
     * Class Constructor
     *
     * @param message Exception message
     * @param rows    Rows amount
     * @param columns Columns amount
     */
    public MyArraySizeException(String message, int rows, int columns) {
        super(message);
        this.rows = rows;
        this.columns = columns;
    }

    //region    Fields Getters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    //endregion
}
