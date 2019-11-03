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

public class PaintingReportTest {
    @Test
    public void displayingOutput() {
        String name = "Sree";
        String address = "1 Bob Avenue, Auckland";
        int custID = 1;
        ArrayList blockCollection = new ArrayList();
            String redSquare = "1";
            blockCollection.add(redSquare);
            String blueSquare = "";
            blockCollection.add(blueSquare);
            String yellowSquare = "1";
            blockCollection.add(yellowSquare);
            String redTriangle = "";
            blockCollection.add(redTriangle );
            String blueTriangle = "2";
            blockCollection.add(blueTriangle );
            String yellowTriangle = "";
            blockCollection.add(yellowTriangle );
            String redCircle = "";
            blockCollection.add(redCircle );
            String blueCircle = "1";
            blockCollection.add(blueCircle );
            String yellowCircle = "2";
            blockCollection.add(yellowCircle );
            Order order = new Order("12th",blockCollection );
            StringBuilder stringBuilderForPrintingInNewLine = new StringBuilder();
            StringBuilder stringBuilderForPrintingInSameLine = new StringBuilder();
            StringBuilder stringBuilderForFormattingString = new StringBuilder();
            int orderNumber = 0001;
            String dueDate = "12th";
            stringBuilderForPrintingInNewLine.append("\n");
            stringBuilderForPrintingInNewLine.append("Your painting report has been generated:");
            stringBuilderForPrintingInNewLine.append("\n");
            stringBuilderForPrintingInNewLine.append("----------------------------------------");
            stringBuilderForPrintingInSameLine.append("Name: "+name +" "+ "Address: " + address+" "+ "Due Date: " + dueDate + " "+ "Order #: "+ format("%04d%n", orderNumber));
            final Object[][] table = new String[4][];
            Block squareInRed = new Block(new Square(),new Red());
            Block triangleInBlue = new Block(new Triangle(),new Blue());
            Block circleInYellow = new Block(new Circle(),new Yellow());
            table[0] = new String[] { "  ",squareInRed.getColor().getColor() , triangleInBlue.getColor().getColor(), circleInYellow.getColor().getColor()};
            table[1] = new String[] { squareInRed.getShape().getShape(),redSquare,blueSquare,yellowSquare};
            table[2] = new String[] { triangleInBlue.getShape().getShape(), redTriangle ,blueTriangle,yellowTriangle };
            table[3] = new String[] { circleInYellow.getShape().getShape(), redCircle,blueCircle, yellowCircle };

            for (final Object[] row : table) {
                stringBuilderForFormattingString.append(format("%20s%20s%20s%20s\n", row));
            }
        String expected = stringBuilderForPrintingInNewLine.toString() + "\n" + stringBuilderForPrintingInSameLine.toString() + "\n" + stringBuilderForFormattingString.toString();
            MockPrintingreports mock = new MockPrintingreports();
            assertEquals(expected,mock.displayOutputToTerminal("Sree","1 Bob Avenue, Auckland",order));
    }
}
