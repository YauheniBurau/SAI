package core.old;

import java.util.HashMap;

/**
 * Data object for storing normalized data information to byte size cluster
 * Created by anonymous on 16.03.2019.
 */
public class DataDefault {
    private String name = "empty";
    private DataStructureEnum structureType = DataStructureEnum.DEFAULT;
    private DataTypeEnum dataType = DataTypeEnum.DEFAULT;
    private int rows = 0;
    private int columns = 0;
    private int rowsMax = 0;
    private int columnsMax = 0;
    private byte[][] data = null;
    private HashMap<Integer, String> rowNames = null;

    /**
     * constructor
     * @param structureType
     * @param dataType
     * @param columnsMax
     */
    public DataDefault(DataStructureEnum structureType, DataTypeEnum dataType, int columnsMax, String name) {
        this.structureType = structureType;
        this.dataType = dataType;
        if(columnsMax<=0){ this.columnsMax = 1;}
        else{this.columnsMax = columnsMax;}
        this.rowsMax = dataType.value();
        this.rows = dataType.value();
        this.data = new byte[this.rowsMax][this.columnsMax];
        this.name = name;
        this.rowNames = dataType.rowNames();
    }

    /**
     * add new row values
     * @param values
     * @return
     */
    public boolean add(byte... values){
        boolean result = true;
        byte[] vals = values.clone();
        if(this.columns == this.columnsMax){
            // TODO: create new data array with increased size of columnsMax and copy old data to new data array
        }
        if(vals.length!=this.rowsMax){ result = false;}
        else{
            int i = 0;
            for (byte v :values) {
                this.data[i][this.columns] = v;
                i+=1;
            }
            this.columns+=1;
        }
        return result;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String getName() {
        return name;
    }

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public byte getData(int row, int column) {
        return this.data[row][column];
    }

}
