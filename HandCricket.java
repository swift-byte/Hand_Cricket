import java.util.*;
import java.util.Random;
class HandCricket{
    int score,input,ai,y,k,target;
    int numbers[] = {1,2,4,5,6,3,6,3,1,2,5,6,5,1,2,5,6,3,6,1,1,6,6,3,4,2,2,5,5,6,6};
    String option[] = {"Bat","Bowl"};
    String opt;
    int opt_;
    String toss[] = {"Heads","Tails"};
    boolean f;
    Scanner s = new Scanner(System.in);
    void toss(){
        Random random = new Random();
        y = random.nextInt(2);
        System.out.println("----TOSS TIME----");
        System.out.println("Heads(1) or Tails(2)");
        k = s.nextInt();
        if(k == y){
            System.out.println("You won the toss! what do you want to do:\n1.Bat\n2.Bowl");
            opt_ = s.nextInt(); 
        }
        else{
            opt = option[y];
            System.out.println("You lost the toss! Computer chose to "+ opt + " first");
        }
    }
    void logic(){
        Random random = new Random();
        System.out.println("Enter a number: ");
        input = s.nextInt();
        y = random.nextInt(31);
        ai = numbers[y];
    }
    void bat(){
        if((opt == option[1]) || (opt_ == 1)){
            System.out.println("You are batting, Good luck!");
            System.out.println();
            f = true;
            while(f){
                logic();
                System.out.println("Computer(◣_◢): "+ai);
                if(input!=ai){
                    f = true;
                    score = score + input;
                    System.out.println("Score: "+score);
                    System.out.println();
                }
                if(score>=50){
                    System.out.println("Wooohooo that's a 50, see you at the 100 run mark");
                }
                if(score>=100){
                    System.out.println("That's a century! hats off!");
                }
                if(input>6){
                    System.out.println("Invalid input score not added");
                    score = score - input;
                }
                if(input == ai){
                    f = false;
                    System.out.println();
                    System.out.println("You are out!");
                    System.out.println();
                    System.out.println("Score: "+score);
                    target = score + 1;
                    System.out.println("Target for computer: "+target);
                    bowl_2();
                }
            }
        }   
    }
    void bowl(){
        score = 0;
        if(( opt == option[0]) || (opt_ == 2)){
            System.out.println("You are bowling, Good luck!");
            System.out.println();
            f = true;
            while(f){
                logic();
                System.out.println("Computer(◣_◢): "+ai);
                if(input!=ai){
                    f = true;
                    score = score + ai;
                    System.out.println("Computer Score: "+score);
                    System.out.println();
                }
                if(input>6){
                    System.out.println("Invalid input ball not counted");
                    score = score - ai;
                }
                if(input==ai){
                    f = false;
                    System.out.println("computer is out!");
                    System.out.println();
                    System.out.println("Time to chase!");
                    System.out.println();
                    System.out.println("Computer Score: "+score);
                    target = score + 1;
                    System.out.println("Target: "+target);
                    bat_2();
                }
            }
        } 
    }
    void bat_2(){
        score = 0;
        System.out.println();
        System.out.println("You are batting, Good luck!");
        System.out.println();
	f = true;
        while(f){
            logic();
            System.out.println("Computer(◣_◢): "+ai);  
            if(input!=ai){
                f = true;
                score = score + input;
                System.out.println("Score: "+score);
                System.out.println();
            }
            if(score>=50){
                System.out.println("Wooohooo that's a 50, hope you chase down the target");
            }
            if(score>=100){
                System.out.println("That's a century! hats off!");
            }
            if(input>6){
                    System.out.println("Invalid input");
                    score = score - input;
                }
            if(input == ai){
                f = false;
                System.out.println();
                System.out.println("Score: "+score);
                System.out.println("You lost by " + (target-score) + " runs");
                System.out.println();
                System.out.println("Computer Won!");
                System.out.println();
                System.out.println("GG ヘ( ^o^)ノ＼(^_^ )");
            }
             if(target <= score){
                f = false;
                System.out.println("You won!");
                System.out.println();
                System.out.println("GG ヘ( ^o^)ノ＼(^_^ )");
            }
        }
    }
    void bowl_2(){
        score = 0;
        System.out.println();
        System.out.println("You are bowling, Good luck!");
        System.out.println();
	f = true;
            while(f){
            logic();
            System.out.println("Computer(◣_◢): "+ai);
            if(input!=ai){
                f = true;
                score = score + ai;
                System.out.println("Computer Score: "+score);
            }
            if(input>6){
                    System.out.println("Invalid input ball not counted");
                    score = score - ai;
                }
            if(input == ai){
                f = false;
                System.out.println("Score: "+score);
                System.out.println();
                
                System.out.println("You Won!");
                System.out.println();
                System.out.println("Computer lost by " + (target-score) + " runs");
                System.out.println();
                System.out.println("GG ヘ( ^o^)ノ＼(^_^ )");
            }
             if(target <= score){
                f = false;
                System.out.println();
                System.out.println("Computer Won!");
                System.out.println();
                System.out.println("GG ヘ( ^o^)ノ＼(^_^ )");
            }
        }
    }     
    void main(){
        System.out.println();
        System.out.println("-----HAND CRICKET-----");
        System.out.println();
        System.out.println("Rules:\n\n1)Input numbers within a range of 1-6 only\n2)You have only one wicket\n3)Scoring is simple, unless you and the computer play the same number whatever you input is added to your score\n4)You will loose your one and only wicket if you and the computer both play the same number\n5)You win if you successfully chase down the target set by computer or restrict the computer from chasing down your target\n6)You Lose if you fail rule 5");
        System.out.println("Note that draw is always in the favour of computer, which means the computer wins even if it's a draw");
        System.out.println();
        System.out.println("Simple as that! (｡◕‿◕｡)");
        System.out.println();
        toss();
        bowl();
        bat();
    }
}   


