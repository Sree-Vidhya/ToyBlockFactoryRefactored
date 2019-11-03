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
import static org.junit.Assert.assertEquals;

public class MockInvoiceReportsTest {

    @Test
    public void displayingOutput() {
        String name = "Sree";
        String address = "1 Bob Avenue, Auckland";
        int custID = 1;
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
        StringBuilder stringBuilderForPrintingInNewLineForPrices = new StringBuilder();
        int orderNumber = 0001;
        String dueDate = "12th";
        stringBuilderForPrintingInNewLine.append("\n");
        stringBuilderForPrintingInNewLine.append("Your invoice report has been generated:");
        stringBuilderForPrintingInNewLine.append("\n");
        stringBuilderForPrintingInNewLine.append("----------------------------------------");
        stringBuilderForPrintingInSameLine.append("Name: "+name +" "+ "Address: " + address+" "+ "Due Date: " + dueDate + " "+ "Order #: "+ format("%04d%n", orderNumber));
        final Object[][] table = new String[4][];
        Block squareInRed = new Block(new Square(),new Red());
        Block triangleInBlue = new Block(new Triangle(),new Blue());
        Block circleInYellow = new Block(new Circle(),new Yellow());
        int redTotal = (redSquare+redTriangle+redCircle);
        table[0] = new String[] { "  ",squareInRed.getColor().getColor() , triangleInBlue.getColor().getColor(), circleInYellow.getColor().getColor()};
        table[1] = new String[] { squareInRed.getShape().getShape(), String.valueOf(redSquare), String.valueOf(blueSquare), String.valueOf(yellowSquare)};
        table[2] = new String[] { triangleInBlue.getShape().getShape(), String.valueOf(redTriangle), String.valueOf(blueTriangle), String.valueOf(yellowTriangle)};
        table[3] = new String[] { circleInYellow.getShape().getShape(), String.valueOf(redCircle), String.valueOf(blueCircle), String.valueOf(yellowCircle)};

        for (final Object[] row : table) {
            stringBuilderForFormattingString.append(format("%20s%20s%20s%20s\n", row));
        }
        int totalSquare = (int) blockCollection.get(0) + (int) blockCollection.get(1) + (int) blockCollection.get(2);
        int totalTriangle = (int) blockCollection.get(3) + (int) blockCollection.get(4) + (int) blockCollection.get(5);
        int totalCircle = (int) blockCollection.get(6) + (int) blockCollection.get(7) + (int) blockCollection.get(8);
        Block squareBlock = new Block(new Square(),new Red());
        Block triangleBlock = new Block(new Square(),new Red());
        Block circleBlock = new Block(new Square(),new Red());

        stringBuilderForPrintingInNewLineForPrices.append(squareInRed.getShape().getShape() +"\t\t\t\t"+totalSquare+" @ "+"$"+squareBlock.getShape().getPriceOftheShape()+" ppi = $"+(totalSquare*squareBlock.getShape().getPriceOftheShape()));
        stringBuilderForPrintingInNewLineForPrices.append("\n");
        stringBuilderForPrintingInNewLineForPrices.append(triangleInBlue.getShape().getShape()+"\t\t\t"+totalTriangle+" @ "+"$"+triangleBlock.getShape().getPriceOftheShape()+" ppi = $"+(totalTriangle*triangleBlock.getShape().getPriceOftheShape()));
        stringBuilderForPrintingInNewLineForPrices.append("\n");
        stringBuilderForPrintingInNewLineForPrices.append(circleInYellow.getShape().getShape()+"\t\t\t\t"+totalCircle+" @ "+"$"+circleBlock.getShape().getPriceOftheShape()+" ppi = $"+(totalCircle*circleBlock.getShape().getPriceOftheShape()));
        stringBuilderForPrintingInNewLineForPrices.append("\n");
        stringBuilderForPrintingInNewLineForPrices.append(squareBlock.getColor().getColor()+" color surcharge"+"\t"+(redTotal)+" @ "+squareBlock.getColor().getPriceOftheColor()+" ppi = $"+redTotal*squareBlock.getColor().getPriceOftheColor());
        stringBuilderForPrintingInNewLineForPrices.append("\n");
        String expected = stringBuilderForPrintingInNewLine.toString() + "\n" + stringBuilderForPrintingInSameLine.toString() + "\n" + stringBuilderForFormattingString.toString() + "\n" +stringBuilderForPrintingInNewLineForPrices.toString();
        MockInvoiceReports mock = new MockInvoiceReports();
        assertEquals(expected,mock.displayOutputToTerminal("Sree","1 Bob Avenue, Auckland",order));
    }
}
