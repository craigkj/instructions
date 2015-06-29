package instructions;

public class InstructionMessage {

    private int instructionType;
    private int productCode;
    private int quantity;
    private int uom;
    private int timeStamp;

    public InstructionMessage(int instructionType, int productCode, int quantity, int uom, int timeStamp) {
        this.instructionType = instructionType;
        this.productCode = productCode;
        this.quantity = quantity;
        this.uom = uom;
        this.timeStamp = timeStamp;
    }

    public int getInstructionType() {
        return this.instructionType;
    }

    public void setInstructionType(int instructionType) {
        this.instructionType = instructionType;
    }

    public int getProductCode() {
        return this.productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUOM() {
        return this.uom;
    }

    public void setUOM(int uom) {
        this.uom = uom;
    }

    public int getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String toString() {
        return "InstructionType: " + instructionType + " Product Code " + productCode;
    }

}
