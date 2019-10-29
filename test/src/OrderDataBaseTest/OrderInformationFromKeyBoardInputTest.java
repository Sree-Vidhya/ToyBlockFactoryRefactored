package OrderDataBaseTest;

import FactoryBlockDataBase.Block;
import FactoryBlockDataBase.Cut.Circle;
import FactoryBlockDataBase.Cut.Square;
import FactoryBlockDataBase.Cut.Triangle;
import FactoryBlockDataBase.Paint.Blue;
import FactoryBlockDataBase.Paint.Red;
import FactoryBlockDataBase.Paint.Yellow;
import OrderDataBase.Order;
import OrderDataBase.OrderRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderInformationFromKeyBoardInputTest {
    Block block;
    Order order;
    ArrayList blockCollection = new ArrayList();
    int interger;
    public int validateInput(String input){
        if(input == "") {
            interger = 0;
        }
        else {
            return interger;
        }
        return interger;
    }
    public ArrayList testInputForBlockCollection()
    {
        block = new Block(new Square(), new Red());
        String redSquare = "1";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(redSquare);
        block = new Block(new Square(), new Blue());
        String blueSquare = "";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(blueSquare);
        block = new Block(new Square(), new Yellow());
        String yellowSquare = "1";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(yellowSquare);
        block = new Block(new Triangle(), new Red());
        String redTriangle = "";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(redTriangle );
        block = new Block(new Triangle(), new Blue());
        String blueTriangle = "2";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(blueTriangle );
        block = new Block(new Triangle(), new Yellow());
        String yellowTriangle = "";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(yellowTriangle );
        block = new Block(new Circle(), new Red());
        String redCircle = "";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(redCircle );
        block = new Block(new Circle(), new Blue());
        String blueCircle = "1";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(blueCircle );
        block = new Block(new Circle(), new Yellow());
        String yellowCircle = "2";
        blockCollection.add(block.getShape().getShape());
        blockCollection.add(block.getColor().getColor());
        blockCollection.add(yellowCircle );
        return blockCollection;
    }

    @Test
    public void creatingBlockCollectionFromUserInputReturnsBlockCollection() {
        blockCollection = testInputForBlockCollection();
        MockOrderInformationFromKeyBoardInput mock = new MockOrderInformationFromKeyBoardInput(order);
        assertEquals(blockCollection,mock.creatingBlockCollectionFromUserInput());
    }

    @Test
    public void creatingAnOrderReturnsAnOrder() {
        blockCollection = testInputForBlockCollection();
        order = new Order("5th Nov",blockCollection);
        MockOrderInformationFromKeyBoardInput mock = new MockOrderInformationFromKeyBoardInput(order);
        assertEquals(order.getDueDate(),mock.generateAnOrderFromTheInformationProvided().getDueDate());
        assertEquals(order.getOrderNumer(),mock.generateAnOrderFromTheInformationProvided().getOrderNumer());
        assertEquals(order.getBlockCollection(),mock.generateAnOrderFromTheInformationProvided().getBlockCollection());
    }
    @Test
    public void generateNextOrderNumberReturnsNextOrderNumber() {
        blockCollection = testInputForBlockCollection();
        order = new Order("5th Nov",blockCollection);
        assertEquals(1,order.getOrderNumer());
    }

    @Test
    public void getOrderWithOrderNumber() {
        blockCollection = testInputForBlockCollection();
        order = new Order("5th Nov",blockCollection);
        order.getOrderNumer();
        OrderRepository repo = new OrderRepository();
        repo.addOrdertoDatabase(order);
        MockOrderInformationFromKeyBoardInput mockOrder = new MockOrderInformationFromKeyBoardInput(order);
        Order getOrder =  mockOrder.getOrderWithOrderNumber(1);
        assertEquals(order,getOrder);
    }

}
