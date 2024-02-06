package main.stock;
import main.manager.IncomingPalletManager;
import main.goods.Pallet;

public class Wichtel implements IStockWorker {

    @Override
    public String computeNextOperation(int x, int y, Pallet[] registeredPallets, Stack[] stacks, Pallet inventory, Pallet requested) {
        //System.out.println(x);
        //System.out.println(y);
            if (inventory == null && x == 0 && y == 0) {
                return "P";
            } else if (inventory == null && x != 0) {
                return "W";
            } else if (inventory == null && y != 0) {
                return "N";
            } else if (x != 10 && inventory != null) {
                return "E";
            } else if (inventory != null && x==10) {
                if (stacks[y].isPlacingPossible(inventory)) {
                    //System.out.println(inventory);
                    return "D";
                } else {
                    return "S";
                }
            }
		return "";
    }
}
