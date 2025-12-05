package model.services;

public interface MachineRules {

    default boolean NegativeRule(double amountEntered) {
        if (amountEntered < 0){
            return false;
        }else {
            return true;
        }

    }

    int increaseProductAmount(int amount);

}
