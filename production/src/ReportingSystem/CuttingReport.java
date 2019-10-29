package ReportingSystem;

import CustomerDataBase.CustomerkeyBoardInput;
import OrderDataBase.Order;
import OrderDataBase.OrderInformationFromKeyBoardInput;

import java.util.ArrayList;

public class CuttingReport implements ReportSystem {
    String name;
    String address;
    String dueDate;
    ArrayList blockCollection = new ArrayList();
    Order generatingOrder = new Order(dueDate,blockCollection);
    int orderNumber = 0;
    @Override
    public ReportSystem displayOutputToTerminal() {
        CustomerkeyBoardInput customer = new CustomerkeyBoardInput();
        OrderInformationFromKeyBoardInput order = new OrderInformationFromKeyBoardInput();
        name = customer.getNameFromTheUser();
        address = customer.getAddressFromTheUser();
        generatingOrder = order.generateAnOrderFromTheInformationProvided();
        orderNumber = generatingOrder.getOrderNumer();
        dueDate = generatingOrder.getDueDate();
        blockCollection = generatingOrder.getBlockCollection();
        System.out.println("Your cutting list has been generated:");
        System.out.print("Name: "+name +" "+ "Address: " + address+" "+ "Due Date: " + dueDate + " "+ "Order #: "+String.format("%04d%n", orderNumber));
        int totalSquare = (int) blockCollection.get(2) + (int) blockCollection.get(5) + (int) blockCollection.get(8);
        int totalTriangle = (int) blockCollection.get(11) + (int) blockCollection.get(14) + (int) blockCollection.get(17);
        int totalCircle = (int) blockCollection.get(20) + (int) blockCollection.get(23) + (int) blockCollection.get(26);
        final Object[][] table = new String[4][];
        table[0] = new String[] { "  ", "Qty" };
        table[1] = new String[] { "Square", String.valueOf(totalSquare)};
        table[2] = new String[] { "Triangle", String.valueOf(totalTriangle)};
        table[3] = new String[] { "Circle", String.valueOf(totalCircle)};

        for (final Object[] row : table) {
            System.out.format("%15s%15s\n", row);
        }
        return null;
    }
}
