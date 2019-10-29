package OrderDataBaseTest;

import FactoryBlockDataBase.Block;
import FactoryBlockDataBase.Cut.Circle;
import FactoryBlockDataBase.Cut.Square;
import FactoryBlockDataBase.Cut.Triangle;
import FactoryBlockDataBase.Paint.Blue;
import FactoryBlockDataBase.Paint.Red;
import FactoryBlockDataBase.Paint.Yellow;
import OrderDataBase.Order;
import OrderDataBase.OrderInformation;
import OrderDataBase.OrderRepository;

import java.util.ArrayList;

public class MockOrderInformationFromKeyBoardInput implements OrderInformation {
    Block block;
    Order order;
    ArrayList blockCollection = new ArrayList();
    int orderNumber;

    public MockOrderInformationFromKeyBoardInput(Order order) {
        this.order = order;
    }

    Order getOrder;
    Order getOrderwithOrderNumber;
    @Override
    public int generateNextOrderNumber() {
        return order.getOrderNumer() ;
    }

    @Override
    public ArrayList creatingBlockCollectionFromUserInput() {
        blockCollection = new ArrayList();
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

    @Override
    public Order generateAnOrderFromTheInformationProvided() {
        String dueDate = "5th Nov";
        blockCollection = creatingBlockCollectionFromUserInput();
        order = new Order(dueDate,blockCollection);
        return order;
    }
//    public int getOrderNumberToSearchInTheRepository(1)
//    {
//        return orderNumber;
//    }

    @Override
    public Order getOrderWithOrderNumber(int orderNumber) {
        getOrder =  OrderRepository.getOrderFromDataBase(orderNumber);
        return getOrder;
    }

    @Override
    public Order getOrderFromDatabase() {
        getOrderwithOrderNumber = getOrderWithOrderNumber(orderNumber);
        if(order != null) {
            System.out.println(order);
        } else {
            System.out.println("No such order in database");
        }
        return order;
    }
}
