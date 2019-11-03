package ReportingSystemTest;

import FactoryBlockDataBase.Block;
import FactoryBlockDataBase.Cut.Circle;
import FactoryBlockDataBase.Cut.Square;
import FactoryBlockDataBase.Cut.Triangle;
import FactoryBlockDataBase.Paint.Blue;
import FactoryBlockDataBase.Paint.Red;
import FactoryBlockDataBase.Paint.Yellow;
import OrderDataBase.Order;
import org.junit.Test;

import java.util.ArrayList;

import static java.lang.String.format;
import static org.junit.Assert.*;

public class MockCuttingreportsTest {
    @Test
    public void displayOutputToTerminal() {
        String name = "Sree";
        String address = "1 Bob Avenue, Auckland";
        int custID = 1;
        Block block;
        ArrayList blockCollection = new ArrayList();
        int redSquare = 1;
        blockCollection.add(redSquare);
        int blueSquare = 0;
        blockCollection.add(blueSquare);
        int yellowSquare = 1;
        blockCollection.add(yellowSquare);
        int redTriangle = 0;
        blockCollection.add(redTriangle );
        int blueTriangle = 2;
        blockCollection.add(blueTriangle );
        int yellowTriangle = 0;
        blockCollection.add(yellowTriangle );
        int redCircle = 0;
        blockCollection.add(redCircle );
        int blueCircle = 1;
        blockCollection.add(blueCircle );
        int yellowCircle = 2;
        blockCollection.add(yellowCircle );
        Order order = new Order("12th",blockCollection );
        StringBuilder stringBuilderForPrintingInNewLine = new StringBuilder();
        StringBuilder stringBuilderForPrintingInSameLine = new StringBuilder();
        StringBuilder stringBuilderForFormattingString = new StringBuilder();
        int orderNumber = 0001;
        String dueDate = "12th";
        stringBuilderForPrintingInNewLine.append("\n");
        stringBuilderForPrintingInNewLine.append("Your cutting list has been generated:");
        stringBuilderForPrintingInNewLine.append("\n");
        stringBuilderForPrintingInNewLine.append("-------------------------------------");
        stringBuilderForPrintingInSameLine.append("Name: "+name +" "+ "Address: " + address+" "+ "Due Date: " + dueDate + " "+ "Order #: "+ format("%04d%n", orderNumber));
        stringBuilderForPrintingInNewLine.append("\n");
        int totalSquare = (int) blockCollection.get(0) + (int) blockCollection.get(1) + (int) blockCollection.get(2);
        int totalTriangle = (int) blockCollection.get(3) + (int) blockCollection.get(4) + (int) blockCollection.get(5);
        int totalCircle = (int) blockCollection.get(6) + (int) blockCollection.get(7) + (int) blockCollection.get(8);
        final Object[][] table = new String[4][];
        block = new Block(new Square(),new Red());
        table[0] = new String[] { "  ", "Qty" };
        table[1] = new String[] { block.getShape().getShape(), String.valueOf(totalSquare)};
        block = new Block(new Triangle(), new Blue());
        table[2] = new String[] { block.getShape().getShape(), String.valueOf(totalTriangle)};
        block = new Block(new Circle(),new Yellow());
        table[3] = new String[] { block.getShape().getShape(), String.valueOf(totalCircle)};

        for (final Object[] row : table) {
            stringBuilderForFormattingString.append(    format("%20s%20s\n", row));
        }
        stringBuilderForPrintingInNewLine.append("\n");
        String expected =  stringBuilderForPrintingInNewLine.toString() + "\n" + stringBuilderForPrintingInSameLine.toString() + "\n" + stringBuilderForFormattingString.toString() ;
        MockCuttingreports mock = new MockCuttingreports();
        assertEquals(expected,mock.displayOutputToTerminal("Sree","1 Bob Avenue, Auckland",order));
    }
}
