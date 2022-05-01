package java.android.lesson_2_calculator;

public class Logic {
    private String a,b,action,result;
    private String text = "";
    private boolean dotA,dotB; // защита от ввода второй точки в числе a или b
    private boolean dot = false; // защита от ввода знака ( + - X / ) или (=) после точки

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

        if(a==null) {
            if(number.equals(".") || number.equals("0")){ return; }
            a = number;
            text = "";
        } else

        if(action==null) {
            if(dotA && number.equals(".")){ return; }

            a+=number;
            if(number.equals(".")){ dotA = true; }
        } else

        if(b == null) {
            if(number.equals(".") || number.equals("0")){ return; }
            b = number;
        } else

        if(result==null) {
            if(dotB && number.equals(".")){ return; }

            b+=number;
            if(number.equals(".")){ dotB = true; }
        }

        if(number.equals(".")){ dot = true;  } // защита от ввода знака ( + - X / ) или (=) после точки
        else                  { dot = false; }

        text += number;
    }

    void inputAction(String action){
        if(a!=null&&this.action==null&&!dot){
            this.action = action;
            text += " " + this.action + " ";
        }
    }

    void result(){
        if(a!=null&&action!=null&&b!=null&&!dot){
            text += " = "+action(action,floatValue(a),floatValue(b));

            a = null;
            action = null;
            b = null;
            dotA = false;
            dotB = false;
        }
    }

    ///////// outPut ///////////////
    String getText(){ return text; }

}
