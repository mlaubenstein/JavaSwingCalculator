package de.marvin.operations;

public class Division extends Operation
{
    public float calculate()
    {
        for (int i = 0; i<this.operands.size(); i++){
            if (i==0) {
                result = this.operands.get(i);
            } else {
                this.result /= this.operands.get(i);
            }
        }
        return this.result;
    }

    public String sign()
    {
        return "/";
    }
}
