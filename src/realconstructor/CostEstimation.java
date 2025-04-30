package realconstructor;

public class CostEstimation extends ConstructionMaterial {

    public CostEstimation(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial() {}

    @Override
    public void useMaterial() {}

    @Override
    public void estimateCost() {
        double costPerTon;
        if (materialQuantity >= 5 && materialQuantity <= 15) {
            costPerTon = 200000;
        } else if (materialQuantity > 15) {
            costPerTon = 180000;
        } else {
            System.out.println("No valid quantity to estimate cost.");
            return;
        }

        double total = costPerTon * materialQuantity;
        System.out.println("Contractor: " + contractorName + " (" + contractorId + ")");
        System.out.println("Used Quantity: " + materialQuantity + " tons");
        System.out.println("Cost per ton: " + costPerTon + " RWF");
        System.out.println("Total Estimated Cost: " + total + " RWF");
    }
}