package java.android.lesson_2_calculator;

public class Logic {
    private Value a = new Value();
    private Value b = new Value();
    private String action = "";
    private String text = "";

    class Value{
        String text = "",lastSymbol = "";
        boolean dot;
        int length;

        void addSymbol(String symbol){
            length++;
            text += symbol;
            lastSymbol = symbol;
            if(symbol.equals(".")){ dot = true; }
        }

        void reset(){
            text = "";
            lastSymbol = "";
            dot = false;
            length = 0;
        }

        boolean ban(String symbol){
            if(length == 7)                       { return true; } // ограничение на количество вводимых цифр в число
            if(length == 6 && symbol.equals(".")) { return true; } // ограничение на количество вводимых цифр в число

            if(text.equals("") && ( symbol.equals(".") || symbol.equals("0") ) ){ return true; } // запрет на ввод в начале числа 0 или .
            if(symbol.equals(".") && dot){ return true; }                                        // запрет на ввод второй точки в число
            return false;
        }

        boolean complete(){ return (!lastSymbol.equals(".") && !text.equals("")); } // число завершённое, после него можно ставить знаки +-*/=

        String getText(){ return text; }
    }

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


    ///////////////// BASE METHODS ////////////////////

    void inputNumber(String number){

        if( (a.getText()).equals("") && !a.ban(number) ){ text = ""; }  // автоматическое обнуление строки когда мы заного начинаем расчёт

        if(action.equals("")) {
            if(a.ban(number)) { return;  }
            else  { a.addSymbol(number); }
        }
        else{
            if(b.ban(number)) { return;  }
            else  { b.addSymbol(number); }
        }

        text += number;
    }

    void inputAction(String action){
        if(a.complete() && this.action.equals("")){
            this.action = action;
            text += " " + this.action + " ";
        }
    }

    void result(){
        if(b.complete()){
            text += " = "+action(action, floatValue(a.getText()), floatValue(b.getText()) );

            a.reset();
            action = "";
            b.reset();
        }
    }

    ///////// outPut ///////////////
    String getText(){ return text; }

}
