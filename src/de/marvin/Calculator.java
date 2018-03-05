package de.marvin;



import de.marvin.operations.Operation;
import de.marvin.operations.OperationFactory;

import java.util.ArrayList;
import java.util.List;

public class Calculator
{

    private List<Object> inputValues = new ArrayList<>();
    private List<Object> inputCharacters = new ArrayList<>();
    private List<Object>inputSave = new ArrayList<>();
    private static String Mnumber = null;
    private int round = 0;
    private int i =0;
    private float operand;


    @Override
    public String toString()
    {
        StringBuilder tmpString = new StringBuilder();

        for (Object value : this.inputCharacters) {
            tmpString.append(value);
        }
        return tmpString.toString();
    }

    private String tmpInputNumber = "";

    public void addInput(char input)
    {
        this.inputCharacters.add(input);
        if (InputBoolean.isNumber(input) || InputBoolean.isDot(input))
        {
            tmpInputNumber +=input;
        }
        else if (InputBoolean.isOperation(input) )
        {
            if (!tmpInputNumber.isEmpty()){
                float number = Float.parseFloat(tmpInputNumber);
                inputValues.add(number);
                tmpInputNumber = "";
            }
            if (inputValues.get(inputValues.size()-1) instanceof Operation)
            {
                inputValues.remove(inputValues.size()-1);
            }

            // hier musste aus dem String jetzt ne Zahl machen.
            inputValues.add(OperationFactory.operationFromSign(input));
        } else if (InputBoolean.isEndDelimiter(input)){
            if (!tmpInputNumber.isEmpty()){
                float number = Float.parseFloat(tmpInputNumber);
                inputValues.add(number);
                tmpInputNumber = "";
            }
        }
        else if (InputBoolean.isClear(input))
        {
            // clear screen remove all data
            inputValues.clear();

        }
        else if (InputBoolean.isSpecialOperation(input))
        {
            if (!tmpInputNumber.isEmpty()){
                float number = Float.parseFloat(tmpInputNumber);
                inputValues.add(number);
                tmpInputNumber = "";}

            inputValues.add(OperationFactory.operationFromSign(input));

           //return String.valueOf(result);
        }
    }







    public String calculateResult() {
        this.addInput('=');

        float result;
        result = 0.0f;

        if(i==0) {
             operand = 0.0f;
            i++;
        }
        Operation lastOperation = null;

        for (Object value: this.inputValues) {
            if (value instanceof Operation){
                lastOperation = (Operation) value;


            } else if (value instanceof  Float){
                // zahl

                if( lastOperation!=null){
                    lastOperation.pushOperand(operand);
                    lastOperation.pushOperand((float)value);
                    result = lastOperation.calculate();
                    operand = result;
                } else {
                    operand = (float)value;
                }
            }
        }

        inputValues.clear();
        inputCharacters.clear();
        inputCharacters.add(0, result);
        inputValues.add(0, result);
        inputSave.add(round, result);
        round++;


        return String.valueOf(result);

    }



    public void inputSaveFunction(float MNumber) {


        float m;
        m = 0.0f;


        if (MNumber == 1 || MNumber == 2 || MNumber == 3 || MNumber == 4 ) {
            if (MNumber == 1) {
                m = (float) inputSave.get(0);
            } else if (MNumber == 2) {
                m = (float) inputSave.get(1);
            } else if (MNumber == 3) {
                m = (float) inputSave.get(2);
            } else {
                m = (float) inputSave.get(3);
            }

            Mnumber = Float.toString(m);



            inputCharacters.add(0, m);
            inputValues.add(0, m);
        }

    }

    public void clear()
    {

        inputValues.clear();
        inputCharacters.clear();

    }

    public static String getMNumber()
    {
        return Mnumber;
    }

}
