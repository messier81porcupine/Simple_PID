public class autoTuner {
    int testIterations = 1;
    int controllerIterations = 0; //Tracks how many times the controller ran
    Controller controller = new Controller(); //Create object controller of Controller.java class
    public void runAutoTune(){
        while (testIterations < 10){
            controllerIterations = 0;
            controllerIterations = controller.runController(); //Use above object to access runController() method

            System.out.println(controllerIterations);
            testIterations ++; //Increment testIterations


    }
}

}
