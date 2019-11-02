package com.ge.exercise2;

public class ArrayQuadrantUtil<E extends Object> {
    
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    // The input data.
    E[][] data;

    public ArrayQuadrantUtil(E[][] data) {
        this.data = data;
    }

    /**
     * Description : Generic method which invokes specific method based on the
     * 'operationType' input.
     * 
     * @param row,
     *            the row number.
     * @param column,
     *            the column number.
     * @param quadrantSize,
     *            the size of the quadrant.
     * @param operationType,
     *            the type of operation (i.e, 1, 2 or 3).
     * @return an array containing quadrant values.
     */
    public Object[] getQuadrantValues(int row, int column, int quadrantSize, int operationType) {
        Object[] result = null;
        if(row < 0 || row >= data.length) {
            logger.error("Invalid row number.");
            System.exit(0);
        }
        if(column < 0 || column >= data.length) {
            logger.error("Invalid column number.");
            System.exit(0);
        } 
        if(quadrantSize < 0 || quadrantSize > data.length) {
            logger.error("Invalid quadrant size.");
            System.exit(0);
        }
        switch (operationType) {
            case 1:
                result = getQuadrantValuesForOperation1(row, column, quadrantSize);
                break;
            case 2:
                result = getQuadrantValuesForOperation2(row, column, quadrantSize);
                break;
            case 3:
                result = getQuadrantValuesForOperation3(row, column, quadrantSize);
                break;
            default:
                System.err.println("Please select a valid operation.");
        }
        return result;
    }
    
    /**
     * Description: Returns all of the values in a specific row in order of
     * appearance (left to right). If the last row/column is
     * passed, the values from beginning are returned.
     * 
     * @param row,
     *            the row number.
     * @param column,
     *            the column number.
     * @param quadrantSize,
     *            the size of the quadrant.
     * @return an Object array containing quadrant values.
     * 
     */
    private Object[] getQuadrantValuesForOperation1(int row, int column, int quadrantSize) {
        Object[] result = new Object[quadrantSize];
        int resultArrayIndex = 0, columnCounter = 1;
        for (int i = column; (i < column + quadrantSize && columnCounter <= quadrantSize); i++) {
            if (i > data.length - 1) {
                i = 0;
            }
            result[resultArrayIndex] = data[row][i];
            resultArrayIndex++;
            columnCounter++;
        }
        return result;
    }

    /**
     * Description: 2. Return all of the values in a specific column in order of
     * appearance (top to bottom). If the last row/column is
     * passed, the values from beginning are returned.
     * 
     * @param row,
     *            the row number.
     * @param column,
     *            the column number.
     * @param quadrantSize,
     *            the size of the quadrant.
     * @return an Object array containing quadrant values.
     * 
     */
    private Object[] getQuadrantValuesForOperation2(int row, int column, int quadrantSize) {
        Object[] result = new Object[quadrantSize];
        int resultArrayIndex = 0, rowCounter = 1;
        for (int i = row; (i < row + quadrantSize && rowCounter <= quadrantSize); i++) {
            if (i > data.length - 1) {
                i = 0;
            }
            result[resultArrayIndex] = data[i][column];
            resultArrayIndex++;
            rowCounter++;
        }
        return result;
    }

    /**
     * Description: Return all of the values in a specific quadrant in order of
     * appearance (left to right, top to bottom). If the last row/column is
     * passed, the values from beginning are returned.
     * 
     * @param row,
     *            the row number.
     * @param column,
     *            the column number.
     * @param quadrantSize,
     *            the size of the quadrant.
     * @return an Object array containing quadrant values.
     * 
     */
    private Object[] getQuadrantValuesForOperation3(int row, int column, int quadrantSize) {
        Object[] result = new Object[quadrantSize];
        int resultArrayIndex = 0, rowCounter = 1;
        for (int i = row; (i < (row + quadrantSize) && rowCounter <= quadrantSize/2); i++) {
            int columnCounter = 1;
            if (i > data.length - 1) {
                i = 0;
            }
            for (int j = column; (j < (column + quadrantSize) && columnCounter <= quadrantSize/2); j++) {
                if (j > data.length - 1) {
                    j = 0;
                }
                result[resultArrayIndex] = data[i][j];
                resultArrayIndex++;
                columnCounter++;
            }
            rowCounter++;
        }
        return result;
    }

}