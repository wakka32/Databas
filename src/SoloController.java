import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model
public class SoloController {
    private SoloView theView;
    private SoloModel theModel;

    public SoloController(SoloView theView, SoloModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        // Tell the View that when ever the calculate button
        // is clicked to execute the actionPerformed method
        // in the CalculateListener inner class
        this.theView.addCalculateListener(new CalculateListener());
    }

    private class CalculateListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int firstNumber, secondNumber = 0;
            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered
            try{
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();
                theModel.addTwoNumbers(firstNumber, secondNumber);
                theView.setbody(theModel.getBody());
            }
            catch(NumberFormatException ex){
                System.out.println(ex);
                theView.displayErrorMessage("You Need to Enter 2 Integers");
            }
        }
    }
}