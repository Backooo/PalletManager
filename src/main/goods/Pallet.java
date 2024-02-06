package main.goods;

import main.manager.IncomingPalletManager;

import java.util.Objects;

public abstract class Pallet {

    private String description = "";
    private int id;
    private int width;
    private int depth;
    protected int height;
    private boolean cooling;
    private long incoming;
    private long outgoing;
    private int price;

    private static int nextid = 1;

    /**
     * Creates a pallet from given values
     * @param description - describes the content
     * @param width - width of the pallet
     * @param depth - depth of the pallet
     * @param height - height of the pallet
     * @param cooling - true, if the pallet requires cooling
     * @param duration - estimated duration of stocking in days
     * @param price - price per liter or unit
     */
    protected Pallet(String description, int width, int depth, int height, boolean cooling, int duration, int price) {
        this.id = nextid++;
        this.description = description;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.cooling = cooling;
        this.incoming = System.currentTimeMillis();
        this.outgoing = this.incoming + (duration * 24 * 60 * 60 * 1000);
        this.price = price;
    }

    /**
     * Calculates the current weight of the pallet.
     * @return weight in gram
     */
    public abstract int getWeight();

    /**
     * Calculates the current total value of the pallet.
     * @return total value in Euro.
     */
    public abstract int getValue();


    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pallet pallet = (Pallet) o;
        return id == pallet.id && width == pallet.width && depth == pallet.depth && height == pallet.height && cooling == pallet.cooling && incoming == pallet.incoming && outgoing == pallet.outgoing && price == pallet.price && description.equals(pallet.description);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(description, id, width, depth, height, cooling, incoming, outgoing, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Pallet) {
            Pallet test = (Pallet) obj;
            if (test.id == this.id && test.cooling == this.cooling && test.depth == this.depth && test.description.equals(this.description) && test.height == this.height && test.incoming == this.incoming && test.outgoing == this.outgoing && test.price == this.price && test.width == this.width ) {
                return true;
            }
        }
        return false;
    }

    /*@Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.description);
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.width);
        hash = 31 * hash + Objects.hashCode(this.depth);
        hash = 31 * hash + Objects.hashCode(this.height);
        hash = 31 * hash + Objects.hashCode(this.cooling);
        hash = 31 * hash + Objects.hashCode(this.incoming);
        hash = 31 * hash + Objects.hashCode(this.outgoing);
        hash = 31 * hash + Objects.hashCode(this.price);
        return hash;
    }*/
}
