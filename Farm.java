package task;

import java.util.Random;
import java.util.Scanner;

public class Farm extends FarmImpl{
    short farmHealth = 50;
    short selfMood = 50;
    short money = 50;
    short daysLeft = 365;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void nextDay() {
        while(daysLeft>0){
            System.out.printf("День %d.\nСостояние фермы: %d\nНастроение: %d\nФинансы: %d", 365-daysLeft, farmHealth, selfMood, money);
            int randEvent = random.nextInt(5);
            if (randEvent == 0) {
                System.out.println("Произошло нашествие саранчи");
                System.out.print("Вы можете избавиться от саранчи используя инсектициды. Хотите ли? (y/n): ");
                if(scanner.next().equalsIgnoreCase("y")){
                    System.out.println("Вы спасли ферму!");
                    money-=5;
                    selfMood++;
                } else {
                    System.out.println("Саранча подпортила ваш урожай, но не критично.");
                    farmHealth-=5;
                    selfMood--;
                }
            } else if (randEvent == 1) {
                System.out.println("Пришли кочевники. Они просят у вас немного лишней еды. Хотите поделиться? (y/n): ");
                if(scanner.next().equalsIgnoreCase("y")){
                    System.out.println("Один из кочевников назвал Вас 'добрая душа' =)");
                    selfMood++;
                } else {
                    System.out.println("Кочевники погрустнели и ушли");
                    selfMood--;
                }
            } else if (randEvent == 2) {
                System.out.println("Засуха. Растениям и животным нужно больше воды. Купить воды? (y/n): ");
                if(scanner.next().equalsIgnoreCase("y")){
                    System.out.println("Вы помогли животным и растениям не умереть от жажды!");
                    money-=10;
                    farmHealth+=10;
                } else {
                    System.out.println("Растения сохнут, животные убегают с фермы. Но завтра все будет по-новому");
                    farmHealth-=10;
                }
            } else if (randEvent == 3) {
                System.out.println("Приехал торговец удобрениями. Хотите попробовать продать ему свои удобрения? (y/n): ");
                if(scanner.next().equalsIgnoreCase("y") && random.nextInt(2)==1){
                    System.out.println("'Отличные удобрения!'");
                    money+=10;
                    selfMood+=2;
                } else {
                    System.out.println("Торговца не заинтересовали ваши удобрения.");
                    selfMood--;
                }
            } else {
                System.out.println("Перекупщик хочет купить у вас корову за хорошие деньги, но обещает расплатиться потом. Хотите продать? (y/n): ");
                if(scanner.next().equalsIgnoreCase("y") && random.nextInt(2)==0){
                    farmHealth-=10;
                    money+=20;
                    selfMood+=2;
                } else {
                    System.out.println("Вы отказались");
                }
            }
        }
        System.out.println("День кончился");
    }
}
