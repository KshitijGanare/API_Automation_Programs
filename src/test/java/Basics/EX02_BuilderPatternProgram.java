package Basics;

public class EX02_BuilderPatternProgram {

    public EX02_BuilderPatternProgram step1(){
        System.out.println("Step1");
        return this;
    }

    public EX02_BuilderPatternProgram step2(){
        System.out.println("Step2");
        return this;
    }

    public EX02_BuilderPatternProgram step3(){
        System.out.println("Step3");
        return this;
    }


    public static void main(String[] args) {
        EX02_BuilderPatternProgram o2 = new EX02_BuilderPatternProgram();
        o2.step3().step2().step3();
    }
}


/*
- this cannot be used from static context
- Inside class, this se current object ke variable/method ko access karte hain
- Jab local variable aur instance variable ka naam same ho, toh this se confusion door hota hai
- Method chaining me return this use hota hai
- Constructor ke andar doosre constructor ko call karne ke liye this() use hota hai
- Class ke andar hi kaam karne ke liye this, aur class ke bahar se access karne ke liye object ka naam

*/