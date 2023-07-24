public class autoTuner {
    int testIterations = 1;
    int controllerIterations = 0; //Tracks how many times the controller ran
    int prevControllerIterations = 0; //Same as above but for the last run
    double bestP = 0;
    double bestI = 0;
    double bestD = 0;
    Controller controller = new Controller(); //Create object controller of Controller.java class
    public void runAutoTune(){

        while (testIterations < 10) {
            controllerIterations = controller.runController(); //Use above object to access runController() method

            if (testIterations == 1) {
                controller.P = Math.random();
                controller.I = Math.random();
                controller.D = Math.random();
            }
            else {
                if (controllerIterations > prevControllerIterations) {
                    controller.P += Math.random();
                    controller.I += Math.random();
                    controller.D += Math.random();
                } else {
                    System.out.println("BREAK: LOWER CONTROLLER ITERATIONS");
                    break;
                }
            }
            prevControllerIterations = controllerIterations;
            System.out.println(controllerIterations);
            testIterations++; //Increment testIterations


        }
        System.out.println("After " + testIterations + " iterations the AutoTuner resulted in values for P, I, & D:\n" + controller.P + "\n" + controller.I + "\n" + controller.D );
}

}
