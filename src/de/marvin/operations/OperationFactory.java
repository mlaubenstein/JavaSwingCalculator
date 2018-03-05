package de.marvin.operations;

public class OperationFactory {
    public static Operation operationFromSign(char sign){
        switch (sign){
            case '+':
                return new Addition();
            case '-':
                return new Subtraction();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
            case 'l':
                return new Logarithm();
            case '^':
                return new Potenz();
            case '√':
                return new Sqrt();
                default:

                throw new RuntimeException("Invalid Operation Sign!");
        }
    }
}
