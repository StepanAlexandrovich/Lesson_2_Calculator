package java.android.lesson_2_calculator;

public class Logic {
    private String a,b,action,result;
    private String text = "";

    /////// helpers to calculation ///////
    private float floatValue(String value){ return Float.parseFloat(value);  }

    private float action(String action,float a,float b){
        if(action.equals("+")){ return a + b;  }
        if(action.equals("-")){ return a - b;  }
        if(action.equals("X")){ return a * b;  }
        if(action.equals("/")){ return a / b;  }
        return 0;
    }
    //////////////////////////////////////////////

    void inputNumber(String number){
        if(a==null){
            a = number;
            //text += number;
            text = a;
        }else

        if(action==null){
            a+=number;
            text += number;
        }else

        if(b == null){
            b = number;
            text += number;
        }else

        if(result==null){
            b+=number;
            text += number;
        }
    }

    void inputAction(String action){
        if(a!=null&&this.action==null){
            this.action = action;
            text += " " + this.action + " ";
        }
    }

    void result(){
        if(a!=null&&action!=null&&b!=null){
            text += " = "+action(action,floatValue(a),floatValue(b));

            a = null;
            action = null;
            b = null;
        }
    }

    ///////// outPut ///////////////
    String getText(){ return text; }

}
