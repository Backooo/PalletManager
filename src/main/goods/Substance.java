package main.goods;

import java.util.Objects;

public abstract class Substance extends Pallet{

    private double density;

    /**
     * Creates a pallet from given values
     *
     * @param description - describes the content
     * @param width       - width of the pallet
     * @param depth       - depth of the pallet
     * @param height      - height of the pallet
     * @param cooling     - true, if the pallet requires cooling
     * @param duration    - estimated duration of stocking in days
     * @param density     - density in gram per liter
     */
    protected Substance(String description, int width, int depth, int height, boolean cooling, int duration, double density, int price) {
        super(description, width, depth, height, cooling, duration, price);
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Substance substance = (Substance) o;
        return Double.compare(substance.density, density) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), density);
    }
}
