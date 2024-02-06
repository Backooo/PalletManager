package main.manager;

import main.goods.Pallet;

import java.util.*;

public class IncomingPalletManager {

    private Pallet[] pallets;

    IncomingPalletManager() {
        pallets = new Pallet[0];
    }

    public Pallet[] getPallets() {
        return pallets;
    }

    /**
     * Registers given pallets
     * @param pallets - pallets to register
     */
    public void registerPallets(Pallet... pallets) {
        if (pallets == null || pallets.length == 0) {
            return;
        }
        Pallet[] oldPallets = this.pallets;
        Pallet[] newPallets = new Pallet[oldPallets.length + pallets.length];

        for (int i = 0; i < newPallets.length; i++) {
            if (i < oldPallets.length) {
                newPallets[i] = oldPallets[i];
            } else {
                newPallets[i] = pallets[i-oldPallets.length];
            }
        }
        //Remove leading null values in this.pallets here
        Pallet[] ultraPallets = new Pallet[newPallets.length-1];
        if (newPallets[0] == null) {
            List<Pallet> list= new ArrayList<>();
            Collections.addAll(list, newPallets);
            while(true) {
                if (list.get(0) == null) {
                    list.remove(0);
                } else {
                    break;
                }
            }
            list.toArray(ultraPallets);
            this.pallets = ultraPallets;
        } else {
            this.pallets = newPallets;
        }
    }

    /*@Override
    public native int hashCode() {

    }
    */

    /**
     * Removes a given Pallet from registered pallets
     * @param pallet - pallet to remove
     * @return removed pallet or null (if given pallet wasn't in array)
     */
    public Pallet removePallet(Pallet pallet) {
        Pallet[] oldPallets = this.pallets;
        boolean flag1 = false;
        for (int i = 0; i < oldPallets.length; i++) {
            if (pallet.equals(oldPallets[i])) {
                oldPallets[i] = null;
                flag1 = true;
            }
        }
        if (flag1) {
            return pallet;
        } else {
            return null;
        }
    }
}