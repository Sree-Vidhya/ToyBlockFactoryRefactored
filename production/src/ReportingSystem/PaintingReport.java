package ReportingSystem;

import CustomerDataBase.CustomerkeyBoardInput;
import OrderDataBase.Order;
import OrderDataBase.OrderInformationFromKeyBoardInput;

import java.util.ArrayList;

public class PaintingReport implements ReportSystem {
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
        System.out.println("Your invoice report has been generated:");
        System.out.print("Name: "+name +" "+ "Address: " + address+" "+ "Due Date: " + dueDate + " "+ "Order #: "+String.format("%04d%n", orderNumber));
        final Object[][] table = new String[4][];
        String red = String.valueOf( blockCollection.get(0));
        String square = String.valueOf( blockCollection.get(1));
        String redSquare = String.valueOf( blockCollection.get(2));
        String blue = String.valueOf(blockCollection.get(3));
        String blueSquare = String.valueOf(blockCollection.get(5));
        String yellow = String.valueOf(blockCollection.get(6));
        String yellowSquare = String.valueOf(blockCollection.get(8));
        String triangle = String.valueOf( blockCollection.get(10));
        String redTriangle = String.valueOf(blockCollection.get(11));
        String blueTriangle = String.valueOf(blockCollection.get(14));
        String yellowTriangle = String.valueOf(blockCollection.get(17));
        String circle = String.valueOf(blockCollection.get(19));
        String redCircle = String.valueOf(blockCollection.get(20));
        String blueCircle = String.valueOf(blockCollection.get(23));
        String yellowCircle = String.valueOf(blockCollection.get(26));
        int redTotal = (Integer.parseInt(redSquare)+Integer.parseInt(redTriangle)+Integer.parseInt(redCircle));
        table[0] = new String[] { "  ",red , blue };
        table[1] = new String[] { square,redSquare,blueSquare};
        table[2] = new String[] { triangle, redTriangle ,blueTriangle };
        table[3] = new String[] { circle, redCircle,blueCircle };

        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s\n", row);
        }
        return null;
    }
}
