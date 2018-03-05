package de.marvin.operations;

public class Potenz extends Operation{

    public float calculate()
    {


        {


            for (float value: this.operands){
                this.result = value*value;
            }
            return this.result;
        }
    }
    public String sign()
    {
        return "^2";
    }

}
