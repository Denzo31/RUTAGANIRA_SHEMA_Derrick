package realconstructor;

public class MaterialDelivery extends ConstructionMaterial {

    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {
        if (materialQuantity >= 1 && materialQuantity <= 10) {
            materialBalance += materialQuantity;
            System.out.println("Delivery accepted. Updated balance: " + materialBalance + " tons");
        } else {
            System.out.println("Delivery rejected. Quantity must be between 1 and 10 tons.");
        }
    }

    @Override
    public void useMaterial() {}

    @Override
    public void estimateCost() {}
}