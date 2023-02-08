package beans;


public class MathBean {

    private int x, difficulty=0;
    private TutorMath mathGen;
    int score = 0;
    String question;
    String status;
    int answer;

    public int getScore() {
        return score;
    }
    public String getQuestion() {
        return question;
    }
    public String getStatus() {
        return status;
    }
    public int getDifficulty() {
        return difficulty;
    }

    public void setAnswer(String s) {
        try {
            answer = Integer.parseInt(s);
            processAnswer();
        }
        catch (NumberFormatException nfe) {
            status = "Invalid answer. Enter an integer.";
        }
    }
    public void setDifficulty(String s) {
        try {
            difficulty = Integer.parseInt(s);
            processDifficulty();
        }
        catch (NumberFormatException nfe) {
            status = "Error setting difficulty level.";
        }
    } 

    public void init() {
        mathGen = new TutorMath(); 
        mathGen.setEquation(difficulty);
        question = mathGen.getEquation();
        x = mathGen.getX();
        status = "press [Enter] to submit answer";
    }

    private void processAnswer() {
            if (answer==x) {
                status = "You got it Right!";
                score++;
                mathGen.setEquation(difficulty);
                question=mathGen.getEquation();
                x = mathGen.getX();
            }
            else {
                status = "Sorry, x is not equal to "+answer;
                score--;
            }
    }
    private void processDifficulty() {
                mathGen.setEquation(difficulty);
                question=mathGen.getEquation();
                x = mathGen.getX();
    }
}

/**
* The core math utilities part of this program
**/
class TutorMath {
    private int m, x, b, y, n;
    private String equation, equation2="";
    private boolean two = true;

    // given positive max, generate whole number in range 0 to max, inclusive
    private int getRandInt(int max) { max++; return((int)(Math.random()*max));}

    // given positive max, generate whole number in range -max to +max, inclusive
    private int getPlusMinusInt(int max) {  return(getRandInt(max*2) - max);}

    // given positive arg return "+", given negative return "-"
    private String getSign(int aNumber) { return((aNumber >= 0)? "+":"-");}

    public TutorMath() {} // not ready for prime time yet

    public int getX() { return x;};

/* not used now
    private String getY() { 
        String s1=""+y;
        String s2=n+"y";
        return((two)? s2:s1);
    } //either "y" or its value as a string
*/
    public String getAnswer() {
        if (two) return("X = "+x+"  The complete solution is: {X = "+x+", Y = "+y+"}");
        else return("X = "+x);
    }

    public String getEquation() { 
        //quick fix, should really return enumeration or ...
        if(!equation2.equals("")) equation2 = "and "+equation2;
        return(equation+" "+equation2);
    }

    public void setEquation(int difficulty) {
        int switcher = getRandInt(1);//mixed, unless reset
        if (difficulty==0) switcher=0; //easy only, one equation
        else if (difficulty==1) switcher=1; //hard only, two equations
        switch (switcher) {
        case 0:  two=false; equation2=""; setEquation1(); break;
        default: two=true; setEquation2();
        }
    }

    private void setEquation1() {
        // can't have m==0, because then mx+b=y would have x=infinity, too hard for kids
        m = getPlusMinusInt(5);   while (m==0) m=getPlusMinusInt(5);
        x = getPlusMinusInt(20);
        b = getPlusMinusInt(50);
        y=m*x+b;
        int switcher = getRandInt(3); 
        switch (switcher) {
        case 0: equation=m+"x"+" "+getSign(b)+" "+Math.abs(b)+" = "+y; break;
        case 1: equation=b+" "+getSign(m)+" "+Math.abs(m)+"x"+" = "+y; break;
        case 2: equation=y+" = "+m+"x"+" "+getSign(b)+" "+Math.abs(b); break;
        default:equation=y+" = "+b+" "+getSign(m)+" "+Math.abs(m)+"x";
        }
    }

    private void setEquation2() {
        // can't have m==0, because then mx+b=y would have x=infinity, too hard for kids
        m = getPlusMinusInt(5);   while (m==0) m=getPlusMinusInt(5);
        n = getPlusMinusInt(5);   while (n==0) n=getPlusMinusInt(5);
        x = getPlusMinusInt(20);
        y = getPlusMinusInt(20);
        b=n*y-m*x;
        int switcher = getRandInt(3); 
        switch (switcher) {
        case 0: equation=m+"x"+" "+getSign(b)+" "+Math.abs(b)+" = "+n+"y"; break;
        case 1: equation=b+" "+getSign(m)+" "+Math.abs(m)+"x"+" = "+n+"y"; break;
        case 2: equation=n+"y"+" = "+m+"x"+" "+getSign(b)+" "+Math.abs(b); break;
        default:equation=n+"y"+" = "+b+" "+getSign(m)+" "+Math.abs(m)+"x";
        }
        if (!two) return;
        m = getPlusMinusInt(5);   while (m==0) m=getPlusMinusInt(5);
        n = getPlusMinusInt(5);   while (n==0) n=getPlusMinusInt(5);
        b=n*y-(m*x);
        switcher = getRandInt(3); 
        switch (switcher) {
        case 0: equation2=m+"x"+" "+getSign(b)+" "+Math.abs(b)+" = "+n+"y"; break;
        case 1: equation2=b+" "+getSign(m)+" "+Math.abs(m)+"x"+" = "+n+"y"; break;
        case 2: equation2=n+"y"+" = "+m+"x"+" "+getSign(b)+" "+Math.abs(b); break;
        default:equation2=n+"y"+" = "+b+" "+getSign(m)+" "+Math.abs(m)+"x";
        }
    }
}

