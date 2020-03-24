public class SoloModel {
    // Holds the value of the sum of the numbers
    // entered in the view
    private int SoloValue;

    public void addTwoNumbers(int firstNumber, int secondNumber){
        SoloValue = firstNumber + secondNumber;
    }

    public int getSoloValue(){
        return SoloValue;
    }
}