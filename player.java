public class player {
    double money;
    int items;
    int person;

    player(int person){
        if (person == 1){
            money = 25000000;
        }else if(person == 2){
            money = 20000000.0;
        }else if (person == 3){
            money = 600000000.0;
        }else{
            money = 5000000.0;
        }
    }
}
