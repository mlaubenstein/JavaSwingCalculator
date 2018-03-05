package de.marvin.operations;


public class Logarithm extends Operation
{
    public float calculate()
    {
        {
            for (float value: this.operands){

                this.result = (float) Math.log(value);
            }
            return this.result;
        }
    }
    public String sign()
    {
        return "log";
    }

}
