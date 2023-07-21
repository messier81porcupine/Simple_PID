public class Controller {
    
    double currentState = 0; //Current state of the system being controlled
    double setPoint = 50; //Desired state of the system
    double error = setPoint - currentState; //Error value of the current state; how far currentState is from the desired state (setPoint)
    double prevError = 0; //Error value from the previous iteration
    double cError = 0; //Cumulative error tally; all the errors added up over all iterations
    double errorRate = 0; //Rate of change of the error (has no time relation in this example but would in practice)
    //currentTime
    //prevTime
    //elapsedTime
    //If you use have in your PID make sure to initialize the above 3 variables

    double P = 0.1; //P value for tuning; multiplied by the error
    double I = 0.1; //I value for tuning; multiplied by the cumulative error
    double D = 0.1; //D value for tuning; multiplied by the error rate of change
    double output = 0; //How much the currentState should change this iteration based upon the P, I, & D values; P * error + I * cError + D * errorRate
    int iterations = 1; //Just counts how many loops the controller has run

    public void runController(){
        while (error != 0 ) {
            //elapsedTime = currentTime - prevTime

            currentState += output; //Update the currentState using output; output is from the previous iteration except on the first iteration where it is 0

            error = setPoint - currentState; //Recalculate the error for the new iteration
            cError += error; // Add to the cumulative error tally
            errorRate = (error - prevError); /*Calculate the rate of change of the error; this example can ignore time as it is irrelevant in getting one number to become another, and instead I can use the difference in iterations which is always 1
            If you are keeping time you will need to divide this value by the elapsed time as shown below*/
            //errorRate = (error - prevError)/elapsedTime

            output = P * error + I * cError + D * errorRate; //Calculate the output to add to the current state
            
            System.out.println(error + ", " + prevError +  ", " + currentState + "," + errorRate + ", " + output + ", " + iterations); //Debug Log separated by commas for easy separation in spreadsheet software
            //System.out.println("Error " + error + "\nPrevError" + prevError +  "\nCurrentState " + currentState + "\nErrorRate " + errorRate + "\nOutput " + output ); //Debug Log easy to read in terminal; remove the '\n' to make it one line

            //Make sure to keep these lines below the Debug Log lines as they are just set up for the next iteration; everything would work fine if they were before the Log, but it would make the log give improper values
            prevError = error; //Set prevError to what the error just was
            iterations += 1; //Increase iterations
            //prevTime = currentTime
        }
    }
}
