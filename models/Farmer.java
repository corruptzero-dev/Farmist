package task.models;

public class Farmer {
    public short farmHealth = 50;
    public short selfMood = 50;
    public short money = 50;
    public short daysLeft = 365;
    
    public boolean isOk(Farmer farmer){
        return farmer.money>0&&farmer.money<100&&farmer.selfMood>0&&farmer.selfMood<100&&farmer.farmHealth>0&&farmer.farmHealth<100;
    }
    public void gameOver(Farmer farmer){
        if(farmer.daysLeft==0){
            System.out.println("Вы ушли на пенсию! Отличная работа.");
        } else {
            System.out.println("\nВы проиграли. Причина:");
            if(farmer.selfMood<=0){
                System.out.printf("Вам стало очень грустно и вы решили молча уехать.\nНастроение(%d) <= 0", farmer.selfMood);
            } else if(farmer.selfMood>=100){
                System.out.printf("Вы познали смысл жизни и решили стать отшельником.\nНастроение(%d) >= 100", farmer.selfMood);
            } else if (farmer.farmHealth<=0){
                System.out.printf("Вы запустили ферму. Больше никто не хочет покупать у вас что-либо.\nСостояние фермы(%d) <= 0", farmer.farmHealth);
            } else if (farmer.farmHealth>=100){
                System.out.printf("Животные выгнали вас с фермы.\nСостояние фермы(%d) >= 100", farmer.farmHealth);
            } else if (farmer.money<=0){
                System.out.printf("У вас не осталось денег на корм животным и семена.\nФинансы(%d) <= 0", farmer.money);
            } else if (farmer.money>=100){
                System.out.printf("Вы молча улетели на Сейшелы.\nФинансы(%d) >= 100", farmer.money);
            } else {
                throw new Error("Что-то пошло не так.");
            }
        }
    }
}
