package de.marvin.operations;

import java.util.ArrayList;
import java.util.List;

public class Operation
{

    List<Float> operands = new ArrayList<>();

    protected float result;

    @Override
    public String toString(){
        StringBuilder out= new StringBuilder("(");

        for (float value:operands){
            out.append(String.valueOf(value));
        }
        out.append(this.sign()).append(")");
        return out.toString();
    }

    public void pushOperand(float operand){
        this.operands.add(operand);
    }

    public String sign(){
        return "";
    }

    public float calculate(){
        return 0.0f;
    }

}
