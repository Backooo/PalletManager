package main.stock;

import main.goods.Pallet;
import main.manager.StockManager;

public class Elf implements IStockWorker {

    @Override
    public String computeNextOperation(int x, int y, Pallet[] registeredPallets, Stack[] stacks, Pallet inventory, Pallet requested) {
        int pos1 = 100;
        int pos2 = 100;
        boolean flag = false;
        for (int i = 0; i < stacks.length; i++) {
            for (int j = 0; j < stacks[i].stack.length - 1; j++) {
                if (requested.equals(stacks[i].stack[j])) {
                    pos1 = i;
                    pos2 = j;
                    flag = true;
                    System.out.println(pos1 + " " + pos2);
                    System.out.println(requested);
                    System.out.println(stacks);
                    break;
                }
            }
        }
        if (inventory != null) {
            flag = true;
        }
        if (!flag) {
            return "";
        } else {
            if (inventory == null && x != 10) {
                return "W";
            } else if (inventory == null && x == 10) {
                if (y < pos1) {
                    return "S";
                } else if (y > pos1) {
                    return "N";
                } else {
                    return "P";
                }
            } else {
                if (requested.equals(inventory)) {
                    if (x != 20) {
                        return "E";
                    } else if (y != 0) {
                        return "N";
                    } else {
                        return "D";
                    }
                } else {
                    if (stacks[y].isPlacingPossible(inventory) && y != pos1) {
                        //System.out.println(inventory);
                        return "D";
                    } else {
                        return "S";
                    }
                }
            }
        }
    }
}
