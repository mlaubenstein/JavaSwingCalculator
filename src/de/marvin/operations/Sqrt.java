package de.marvin.operations;

public class Sqrt extends Operation{
    public float calculate()
    {
        {
            for (float value: this.operands){

                this.result = (float) Math.sqrt(value);
            }
            return this.result;
        }
    }
    public String sign()
    {
        return "sqrt";
    }

}
