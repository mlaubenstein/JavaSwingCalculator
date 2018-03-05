package de.marvin.operations;

public class Subtraction extends Operation
{
    public float calculate() {
        for (float value : this.operands) {
            this.result -= value;
        }
        return this.result;
    }
    public String sign()
    {
        return "-";
    }
}
