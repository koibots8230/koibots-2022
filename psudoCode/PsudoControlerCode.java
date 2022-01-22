public class PsudoCode {
    int functionOneTrigger;
    int functionTwoTrigger;
    boolean functionOneStatus = false;

    setTriggers(File psudoControlerMap){
        //some code to manage the file
        functionOneTrigger = psudoControlerMap.functionOneButton;
        functionOneTrigger = psudoControlerMap.functionTwoButton;
    }

    main(){
        while(true){
            if(controler.getRawButton(functionOneTrigger)){
                functionOneStatus = true;
                functionOneOn();
            }else if(functionOneStatus == true){
                functionOneStatus = false;
                functionOneOff();
            }
            functionTwo(controler.getRawAxis(functionTwoTrigger));
        }
    }

    functionOneOn(){
        System.out.println("turn arm motors on");
    }
    functionOneOff(){
        System.out.println("turn arm motors off");
    }
    functionTwo(int motorPower){
        motors.set(motorPower);
    }
}
