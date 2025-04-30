package realconstructor;

public class MaterialUsage extends ConstructionMaterial {

    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {}

    @Override
    public void useMaterial() {
        if (materialBalance - materialQuantity >= 2) {
            materialBalance -= materialQuantity;
            System.out.println("Material used: " + materialQuantity + " tons. Remaining balance: " + materialBalance + " tons");
        } else {
            System.out.println("Insufficient material. Balance must remain at least 2 tons.");
        }
    }

    @Override
    public void estimateCost() {}
}