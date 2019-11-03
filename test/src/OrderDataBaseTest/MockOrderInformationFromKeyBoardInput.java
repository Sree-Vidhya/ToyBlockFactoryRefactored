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

    public int validateKeyBoardInput(String keyBoardInputMock)
    {
        int changingkeyboardInputToInteger;
        if(keyBoardInputMock.matches("")) {
             changingkeyboardInputToInteger = 0;
            return changingkeyboardInputToInteger;
        }
        else {
            try{
                int yourNumber = Integer.parseInt(keyBoardInputMock);
            }catch (NumberFormatException ex) {
                keyBoardInputMock = "0";
            }
            changingkeyboardInputToInteger = Integer.parseInt(keyBoardInputMock);
            return changingkeyboardInputToInteger;
        }
    }
    @Override
    public ArrayList creatingBlockCollectionFromUserInput() {
        blockCollection = new ArrayList();
        int redSquare = validateKeyBoardInput("1");
        blockCollection.add(redSquare);
        int blueSquare = validateKeyBoardInput("");
        blockCollection.add(blueSquare);
        int yellowSquare = validateKeyBoardInput("1");
        blockCollection.add(yellowSquare);
        int redTriangle = validateKeyBoardInput("");
        blockCollection.add(redTriangle );
        int blueTriangle = validateKeyBoardInput("2");
        blockCollection.add(blueTriangle );
        int yellowTriangle = validateKeyBoardInput("");
        blockCollection.add(yellowTriangle );
        int redCircle = validateKeyBoardInput("");
        blockCollection.add(redCircle );
        int blueCircle = validateKeyBoardInput("1");
        blockCollection.add(blueCircle );
        int yellowCircle = validateKeyBoardInput("2");
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
