package DZ4.exceptions;

/**
 * Class to generate exception while parse integer
 */
public class MyArrayDataException extends Exception {
    /**
     * Exception in row position
     */
    private final int row;
    /**
     * Exception in column position
     */
    private final int column;
    /**
     * initiate Exception value
     */
    private final String value;

    /**
     * Class Constructor
     *
     * @param message String message of Exception
     * @param value   the value that triggered the exception
     * @param row     Exception in row position
     * @param column  Exception in column position
     * @param cause   NumberFormatException
     */
    public MyArrayDataException(String message, String value, int row, int column, Throwable cause) {
        super(message, cause);
        this.value = value;
        this.row = row;
        this.column = column;
    }

    //region Fields Getters
    public String getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    //endregion

}
