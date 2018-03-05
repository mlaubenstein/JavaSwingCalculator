package de.marvin.operations;

public class Addition  extends Operation
{
    public float calculate()
    {
        for (float value: this.operands){
            this.result += value;
        }
        return this.result;
    }
    public String sign()
    {
        return "DuArsch";
    }


}
