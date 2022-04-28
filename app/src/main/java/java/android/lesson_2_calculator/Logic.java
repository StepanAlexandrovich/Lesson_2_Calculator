package java.android.lesson_2_calculator;

public class Logic {
    private String a,b,action,result;
    private boolean dot = false; // защита от ввода знака ( + - X / ) или (=) после точки
    private boolean floatA = false,floatB = false; // защита от ввода второй точки в числе
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
        if(a==null){ text = ""; }

        if(a==null&&number == "."){ return; }  // защита от ввода точки первой в a
        if(a==null&&number == "0"){ return; }  // защита от ввода числа 0 первым в a

        if(action!=null&&b==null&&number == "."){ return; }  // защита от ввода точки первой в b
        if(action!=null&&b==null&&number == "0"){ return; }  // защита от ввода числа 0 первым в b

        if(a!=null && action==null && floatA && number=="."){ return; } // защита от ввода второй точки в числе a
        if(b!=null && result==null && floatB && number=="."){ return; } // защита от ввода второй точки в числе b


        if(a==null)      { a = number; } else
        if(action==null) {

            a+=number;

            if(number == "."){ floatA = true; } // защита от ввода второй точки в числе

        } else

        if(b == null)    { b = number; } else
        if(result==null) {
            b+=number;

            if(number == "."){ floatB = true; } // защита от ввода второй точки в числе
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
            floatA = false;
            floatB = false;
        }
    }

    void resetText(){ text = ""; }

    ///////// outPut ///////////////
    String getText(){ return text; }

}
